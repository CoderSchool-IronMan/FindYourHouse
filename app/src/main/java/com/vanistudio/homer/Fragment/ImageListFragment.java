package com.vanistudio.homer.Fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vanistudio.homer.R;

/**
 * Created by User on 4/14/2016.
 */
public class ImageListFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View img_list_frg = inflater.inflate(R.layout.image_list_fragment, container, false);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.addToBackStack(null);
        ft.commit();
        return img_list_frg;
    }
}
