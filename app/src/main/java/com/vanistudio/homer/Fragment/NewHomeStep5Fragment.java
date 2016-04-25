package com.vanistudio.homer.Fragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sangcomz.fishbun.FishBun;
import com.sangcomz.fishbun.define.Define;
import com.vanistudio.homer.Adapter.NewHomeGalleryRecyclerViewAdapter;
import com.vanistudio.homer.R;

import java.util.ArrayList;

/**
 * Created by thuynh6 on 4/22/2016.
 */
public class NewHomeStep5Fragment extends Fragment {
    private Button btnAddImages;
    private ArrayList<String> path = new ArrayList<>();
    private RecyclerView rvGallery;
    private NewHomeGalleryRecyclerViewAdapter adapter;
    private OnButtonNextClickListener nextListener;
    private Button btnStep5Next;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_home_step_5, container, false);
        btnStep5Next = (Button) view.findViewById(R.id.btStep5Next);
        btnAddImages = (Button) view.findViewById(R.id.btStep5Gallery);
        btnAddImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FishBun.with(NewHomeStep5Fragment.this)
                        .setPickerCount(10)
                        .setActionBarColor(Color.parseColor("#3F51B5"), Color.parseColor("#303F9F"))
                        .setArrayPaths(path)
                        .setCamera(true)
                        .setButtonInAlbumActiviy(false)
                        .startAlbum();
            }
        });
        rvGallery = (RecyclerView) view.findViewById(R.id.rvStep5Gallery);
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        gridLayoutManager.setAutoMeasureEnabled(true);
        //StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        rvGallery.setLayoutManager(gridLayoutManager);

        adapter = new NewHomeGalleryRecyclerViewAdapter(getActivity(), path);
        rvGallery.setAdapter(adapter);

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Define.ALBUM_REQUEST_CODE:
                if (resultCode == getActivity().RESULT_OK) {
                    path.addAll(data.getStringArrayListExtra(Define.INTENT_PATH));
                    adapter.notifyDataSetChanged();
                    break;
                }
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            Activity activity = (Activity) context;
            nextListener = (OnButtonNextClickListener) activity;
        }
        catch (ClassCastException e){

        }
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        try {
            nextListener = (OnButtonNextClickListener) context;
        }
        catch (ClassCastException e){

        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnStep5Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextListener.OnSetGallery();
            }
        });
    }

    public interface OnButtonNextClickListener {
        public void OnSetGallery();
    }
}
