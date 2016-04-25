package com.vanistudio.homer.Fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vanistudio.homer.R;

/**
 * Created by thuynh6 on 4/21/2016.
 */
public class NewHomeStep2MapViewFragment extends Fragment {
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_new_home_step_2_map_view, container, false);
            return view;
        }
}
