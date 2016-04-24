package com.vanistudio.homer.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.vanistudio.homer.Model.Homer_Image;
import com.vanistudio.homer.R;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by thuynh6 on 4/24/2016.
 */
public class NewHomeGalleryRecyclerViewAdapter extends RecyclerView.Adapter<NewHomeGalleryRecyclerViewAdapter.ViewHolder> {
    private ArrayList<String> mImages;
    private Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivHomeGallery;

        public ViewHolder(View itemView) {
            super(itemView);
            ivHomeGallery = (ImageView) itemView.findViewById(R.id.ivGallery_NewHome);
        }
    }

    public NewHomeGalleryRecyclerViewAdapter(Context context, ArrayList<String> images) {
        mImages = images;
        mContext = context;
    }

    @Override
    public NewHomeGalleryRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View imageView = inflater.inflate(R.layout.recycler_view_new_home_gallery, parent, false);
        ViewHolder viewHolder = new ViewHolder(imageView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NewHomeGalleryRecyclerViewAdapter.ViewHolder holder, int position) {
        String image = mImages.get(position);
        ImageView ivHomeGallery = holder.ivHomeGallery;

        File file = new File(image);

        Picasso.with(mContext).load(file).fit().centerCrop().into(ivHomeGallery);
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

}
