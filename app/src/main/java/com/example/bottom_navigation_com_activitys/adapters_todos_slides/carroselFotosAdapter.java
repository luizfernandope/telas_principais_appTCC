package com.example.bottom_navigation_com_activitys.adapters_todos_slides;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.bottom_navigation_com_activitys.R;

import java.util.ArrayList;

public class carroselFotosAdapter extends PagerAdapter {


    Context context;
    ArrayList<Integer> images;

    public carroselFotosAdapter(Context context, ArrayList<Integer>images){
        this.context = context;
        this.images = images;
    }


    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_carrosel_fotos_adapter, null);
        ImageView imageView = view.findViewById(R.id.imageView_carroselFotos_inicio);
        Glide.with(context).asBitmap().load(images.get(position)).into(imageView);

        container.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}