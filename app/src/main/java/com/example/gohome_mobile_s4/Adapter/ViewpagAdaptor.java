package com.example.gohome_mobile_s4.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.example.gohome_mobile_s4.R;

public class ViewpagAdaptor extends PagerAdapter {

    Context context;
    int images[]={
            R.drawable.logohome,
            R.drawable.img2,
            R.drawable.img3
    };
    int heading[]={
      R.string.heading_one,
      R.string.heading_two,
      R.string.heading_three
    };
    int desc[]={
            R.string.desc_one,
            R.string.desc_two,
            R.string.desc_three
    };
    public ViewpagAdaptor (Context context){
        this.context = context;
    }
    @Override
    public int getCount(){
        return heading.length;
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object){
        return  view == (LinearLayout) object;
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position){
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_lay, container, false);
        ImageView slideImage = (ImageView) view.findViewById(R.id.img);
        TextView slideHead = (TextView) view.findViewById(R.id.titletext);
        TextView slideDesc = (TextView) view.findViewById(R.id.desctext);

        slideImage.setImageResource(images[position]);
        slideHead.setText(heading[position]);
        slideDesc.setText(desc[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout)object);
    }
}
