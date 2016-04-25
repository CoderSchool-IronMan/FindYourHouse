package com.vanistudio.homer.Fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.vanistudio.homer.R;

/**
 * Created by thuynh6 on 4/19/2016.
 */
public class NewHomeStep2Fragment extends Fragment {
    private Button btStep2Next;
    private Button btStep2MapView;
    private OnButtonMapViewClickListener mapListener ;
    private OnButtonNextClickListener nextListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_home_step_2, container, false);

        btStep2Next = (Button) view.findViewById(R.id.btStep2Next);
        btStep2MapView = (Button) view.findViewById(R.id.btStep2MapView);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            Activity activity = (Activity) context;
            nextListener = (OnButtonNextClickListener) activity;
            mapListener = (OnButtonMapViewClickListener) activity;
        }
        catch (ClassCastException e){

        }
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        try {
            nextListener = (OnButtonNextClickListener) context;
            mapListener = (OnButtonMapViewClickListener) context;
        }
        catch (ClassCastException e){

        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btStep2MapView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapListener.OpenMapViewFragment();
            }
        });

        btStep2Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextListener.OnSetAddressFromForm();
            }
        });
    }

    public interface OnButtonMapViewClickListener {
        public void OpenMapViewFragment();
    }

    public interface OnButtonNextClickListener {
        public void OnSetAddressFromForm();
    }
}

