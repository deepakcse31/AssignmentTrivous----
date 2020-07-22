package com.example.assignmenttrivous;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Techradar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Techradar extends Fragment {
    RequestQueue requestQueue;
    TextView textView;
    RecyclerView recyclerView;
    List<News> news1;
    Adapter adapter;
    View view;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Techradar() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Techradar.
     */
    // TODO: Rename and change types and number of parameters
    public static Techradar newInstance(String param1, String param2) {
        Techradar fragment = new Techradar();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        news1=new ArrayList<>();
        requestQueue= Volley.newRequestQueue(getActivity().getApplicationContext());
        login();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_techradar, container, false);
        recyclerView=view.findViewById(R.id.recycle1);
        return view;
    }
    public void login()
    {
        StringRequest request=new StringRequest(Request.Method.GET, "https://newsapi.org/v2/top-headlines?country=in&apiKey=290984b18d5b471283887db58e4dba3d",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.e("try","try"+"try");
                            JSONObject jobj = new JSONObject(response);
                            Log.e("Dekhlo","Dekhlo"+response);
                            JSONArray array1=jobj.getJSONArray("articles");
                            Log.e("Dekho3","Dekho3"+array1);
                            for (int i=0;i<array1.length();i++)
                            {
                                JSONObject object=array1.getJSONObject(i);//each json object acess through this
                                Log.e("Dekho4","Dekho4"+object);

                                JSONObject songsObject = object.getJSONObject("source");
                                Log.e("Dekho2","Dekho2"+songsObject);
                                String name1=songsObject.getString("name");
                                Log.e("Dekho6","Dekho6"+name1);
                                if (name1.equals("Techradar"))
                                {
                                    News news=new News();

                                    news.setImageurl(object.getString("urlToImage"));
                                    news.setDescription(object.getString("description"));
                                    news.setTitle(object.getString("title"));
                                    news.setPublishedAt(object.getString("publishedAt"));
                                    news.setUrl(object.getString("url"));
                                    news1.add(news);
                                    String name=object.getString("title");
                                    Log.e("Dekho5","Dekho5"+name);
                                }
                                else {
                                    Toast.makeText(getActivity().getApplicationContext(),"RamLal",Toast.LENGTH_LONG).show();
                                }
                            }
                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
                            //recyclerView.setHasFixedSize(true);
                            adapter=new Adapter(getActivity().getApplicationContext(),news1);
                            recyclerView.setAdapter(adapter);

                            //String name=object.getString("title");
                            //Log.e("Dekho5","Dekho5"+name);

                            // JSONObject songsObject = object.getJSONObject("source");
                            //Log.e("Dekho2","Dekho2"+songsObject);
                            //String name1=songsObject.getString("name");
                            //Log.e("Dekho6","Dekho6"+name1);
                            //JSONArray array=songsObject.getJSONArray("articles");
                            //Log.e("Dekho1","Dekho1"+array);
                            //JSONArray songsArray = songsObject.toJSONArray(songsObject.names());
//                                JSONArray jsonArray=jobj.getJSONArray("data");
                            //Log.e("Result->","Result->"+songsArray);
//                                Log.e("Result->","Result->"+jsonArray);

                            //String phone1=jobj.getString("phone");

                        } catch (JSONException e) {
                            Log.e("1try","try1"+"try1");
                            Toast.makeText(getActivity().getApplicationContext(),"There is some problem in link",Toast.LENGTH_LONG).show();
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("show","show"+error);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                return params;
            }
        };
        Volley.newRequestQueue(getActivity().getApplicationContext()).add(request);
    }
}
