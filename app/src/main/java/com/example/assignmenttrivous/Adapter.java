package com.example.assignmenttrivous;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context mContext;
    LayoutInflater inflater;
    List<News> news;
    RecyclerView mRecyclerView;

    public Adapter(Context ctx, List<News> news) {
        super();
        mContext=ctx;
        this.inflater = LayoutInflater.from(ctx);
        this.news = news;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.custom_list_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycle1);
        //mRecyclerView.setHasFixedSize(true);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.description.setText(news.get(position).getDescription());
        holder.title.setText(news.get(position).getTitle());
        holder.publisher.setText(news.get(position).getPublishedAt());

        Picasso.with(this.mContext)
                .load(news.get(position).getImageurl())
                .into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url1=news.get(position).getUrl();
                Intent i = new Intent(mContext, web1.class);
                i.putExtra("need",url1);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(i);
                Log.e("url->","url->"+url1);
            }
        });
    }

    @Override
    public int getItemCount() {
        //return (null != news ? news.size() : 0);
        return news.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView description,title,publisher;
        ImageView imageView;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            description=itemView.findViewById(R.id.des);
            title=itemView.findViewById(R.id.tit);
            publisher=itemView.findViewById(R.id.pub);
            imageView=itemView.findViewById(R.id.ima);
        }
    }
}
