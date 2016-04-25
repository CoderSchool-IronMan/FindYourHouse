package com.vanistudio.homer.Adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vanistudio.homer.CustomLayoutManager;
import com.vanistudio.homer.Model.Homer_Estate;
import com.vanistudio.homer.R;

import java.util.ArrayList;

/**
 * Created by thuynh6 on 4/12/2016.
 */
public class HomeListRecyclerViewAdapter extends RecyclerView.Adapter<HomeListRecyclerViewAdapter.ViewHolder> {
    private ArrayList<Homer_Estate> mEstate;
    private Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public RecyclerView rvHomeGallery;
        //public ImageView ivHomeGallery;
        public TextView tvHomePrice;

        public ViewHolder(View itemView) {
            super(itemView);
            rvHomeGallery = (RecyclerView) itemView.findViewById(R.id.rvHomeGallery_HomeListRecyclerViewRow);
            //ivHomeGallery = (ImageView) itemView.findViewById(R.id.ivHomeGallery_HomeListRecyclerViewRow);
            tvHomePrice = (TextView) itemView.findViewById(R.id.tvHomePrice_HomeListRecyclerViewRow);
        }
    }

    public HomeListRecyclerViewAdapter(Context context, ArrayList<Homer_Estate> estates) {
        mEstate = estates;
        mContext = context;
    }

    @Override
    public HomeListRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View estateView = inflater.inflate(R.layout.recycler_view_home_list_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(estateView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HomeListRecyclerViewAdapter.ViewHolder holder, int position) {
        Homer_Estate estate = mEstate.get(position);
        //StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        CustomLayoutManager gridLayoutManager = new CustomLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        //LinearLayoutManager gridLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        gridLayoutManager.setAutoMeasureEnabled(true);
        holder.rvHomeGallery.setLayoutManager(gridLayoutManager);
        holder.rvHomeGallery.setAdapter(new HomeGalleryRecyclerViewAdapter(mContext, mEstate.get(position).getImages()));
        //ImageView ivHomeGallery = holder.ivHomeGallery;
        //Picasso.with(mContext).load(estate.getImages().get(0).getUrl()).fit().centerCrop().into(ivHomeGallery);
        TextView tvHomePrice = holder.tvHomePrice;
        tvHomePrice.setText(estate.getPrice());
    }

    @Override
    public int getItemCount() {
        //return mEstate.size();
        return (null != mEstate ? mEstate.size() : 0);
    }

}
