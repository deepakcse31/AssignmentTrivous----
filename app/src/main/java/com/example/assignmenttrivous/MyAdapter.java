package com.example.assignmenttrivous;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {
    Context context;
    int totalTabs;
    public MyAdapter(Context c, FragmentManager fm, int totalTabs) {
        super(fm);
        context = c;
        this.totalTabs = totalTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                India india=new India();
                return india;
            case 1:
               Hindustan hindustan=new Hindustan();
               return hindustan;
            case 2:
               Livemint livemint=new Livemint();
               return livemint;
            case 3:
                Times times=new Times();
                return times;
            case 4:
               Google google=new Google();
               return google;
            case 5:
                Techradar techradar=new Techradar();
                return techradar;
            case 6:
                NDTV ndtv=new NDTV();
                return ndtv;
            case 7:
                News18 news18=new News18();
                return news18;
            case 8:
                InsideSport insideSport=new InsideSport();
                return insideSport;
            case 9:
                Business business=new Business();
                return business;
            case 10:
                Zoom zoom=new Zoom();
                return zoom;
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return totalTabs;
    }
}
