package com.vanistudio.homer.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
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
import java.util.List;

/**
 * Created by thuynh6 on 4/12/2016.
 */
public class HomeListRecyclerViewAdapter extends RecyclerView.Adapter<HomeListRecyclerViewAdapter.ViewHolder> {
    private ArrayList<Homer_Estate> mEstate;
    private Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public RecyclerView rvHomeGallery;
        public TextView tvHomePrice;

        public ViewHolder(View itemView) {
            super(itemView);
            rvHomeGallery = (RecyclerView) itemView.findViewById(R.id.rvHomeGallery_HomeListRecyclerViewRow);
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
    public void onBindViewHolder(ViewHolder holder, int position) {
        Homer_Estate estate = mEstate.get(position);
        StaggeredGridLayoutManager gridLayoutManager =
                new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        holder.rvHomeGallery.setLayoutManager(gridLayoutManager);
        holder.rvHomeGallery.setAdapter(new HomeGalleryRecyclerViewAdapter(mContext, mEstate.get(position).getImages()));

        TextView tvHomePrice = holder.tvHomePrice;
        tvHomePrice.setText(estate.getPrice());
    }

    @Override
    public int getItemCount() {
        return mEstate.size();
    }

}
