package com.vanistudio.homer.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vanistudio.homer.Model.Homer_Estate;
import com.vanistudio.homer.Model.Homer_Image;
import com.vanistudio.homer.R;

import java.util.ArrayList;

/**
 * Created by thuynh6 on 4/14/2016.
 */
public class HomeGalleryRecyclerViewAdapter extends RecyclerView.Adapter<HomeGalleryRecyclerViewAdapter.ViewHolder> {
    private ArrayList<Homer_Image> mImages;
    private Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivHomeGallery;

        public ViewHolder(View itemView) {
            super(itemView);
            ivHomeGallery = (ImageView) itemView.findViewById(R.id.ivHomeGallery_HomeGalleryRecyclerViewCell);
        }
    }

    public HomeGalleryRecyclerViewAdapter(Context context, ArrayList<Homer_Image> images) {
        mImages = images;
        mContext = context;
    }

    @Override
    public HomeGalleryRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View imageView = inflater.inflate(R.layout.recycler_view_home_gallery_cell, parent, false);
        ViewHolder viewHolder = new ViewHolder(imageView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HomeGalleryRecyclerViewAdapter.ViewHolder holder, int position) {
        Homer_Image image = mImages.get(position);
        ImageView ivHomeGallery = holder.ivHomeGallery;
        Picasso.with(mContext).load(image.getUrl()).fit().centerCrop().into(ivHomeGallery);
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

}
