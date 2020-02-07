package com.example.hospitalapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import com.example.hospitalapp.R;

public class ViewPagerClass extends PagerAdapter {
    private Context context;
    public ViewPagerClass(Context context) {
        this.context = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.layoutimages, null);
        ImageView imageView = view.findViewById(R.id.image);
        imageView.setImageDrawable(context.getResources().getDrawable(getImageAt(position)));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object view) {
        container.removeView((View) view);
    }
    /*
    Returns the count of the total pages
    */
    @Override
    public int getCount() {
        return 4;
    }
    /*
    Used to determine whether the page view is associated with object key returned by instantiateItem.
    Since here view only is the key we return view==object
    */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return object == view;
    }
    private int getImageAt(int position) {
        switch (position) {
            case 0:
                return R.drawable.mone;

            case 1:
                return R.drawable.mthree;
            case 2:
                return R.drawable.smil;

            default:
                return R.drawable.mfive;
        }
    }
    }