package com.vanistudio.homer.Fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vanistudio.homer.Adapter.HomeListRecyclerViewAdapter;
import com.vanistudio.homer.Model.Homer_Estate;
import com.vanistudio.homer.Model.Homer_Image;
import com.vanistudio.homer.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thuynh6 on 4/11/2016.
 */
public class HomeListRecyclerViewFragment extends Fragment {
    private ArrayList<Homer_Estate> estates;

    private HomeListRecyclerViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_list_recycler_view, container, false);
        RecyclerView rvHomeList = (RecyclerView) view.findViewById(R.id.rvHomeList);

        //CustomLayoutManager gridLayoutManager = new CustomLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        gridLayoutManager.setAutoMeasureEnabled(true);
        //StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        rvHomeList.setLayoutManager(gridLayoutManager);

        adapter = new HomeListRecyclerViewAdapter(getActivity(), estates);
        rvHomeList.setAdapter(adapter);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        estates = new ArrayList<>();
        populateData();
    }

    public void addAll(ArrayList<Homer_Estate> estates) {
        estates.addAll(estates);
        adapter.notifyDataSetChanged();
    }

    private void populateData(){
        Homer_Image i1 = new Homer_Image();
        i1.setTitle("hinh 1");
        i1.setUrl("https://source.unsplash.com/category/buildings");

        Homer_Image i2 = new Homer_Image();
        i2.setTitle("hinh 2");
        i2.setUrl("https://source.unsplash.com/category/nature");
        //i2.setUrl("https://pbs.twimg.com/profile_images/638751551457103872/KN-NzuRl.png");

        ArrayList<Homer_Image> g = new ArrayList<>();
        g.add(i1);
        g.add(i2);

        Homer_Estate h1 = new Homer_Estate();
        h1.setPrice("2.2b");
        h1.setImages(g);

        Homer_Estate h2 = new Homer_Estate();
        h2.setPrice("900m");
        h2.setImages(g);

        Homer_Estate h3 = new Homer_Estate();
        h3.setPrice("1.5b");
        h3.setImages(g);

        Homer_Estate h4 = new Homer_Estate();
        h4.setPrice("1.5b");
        h4.setImages(g);

        Homer_Estate h5 = new Homer_Estate();
        h5.setPrice("1.5b");
        h5.setImages(g);

        Homer_Estate h6 = new Homer_Estate();
        h6.setPrice("1.5b");
        h6.setImages(g);

        Homer_Estate h7 = new Homer_Estate();
        h7.setPrice("1.5b");
        h7.setImages(g);

        estates.add(h1);
        estates.add(h2);
        estates.add(h3);
        estates.add(h4);
        estates.add(h5);
        estates.add(h6);
        estates.add(h7);
    }
}
