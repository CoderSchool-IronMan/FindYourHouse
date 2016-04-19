package com.vanistudio.homer.Fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.vanistudio.homer.R;

/**
 * Created by User on 4/14/2016.
 */
public class HomeDetailFragment extends Fragment {
    ImageView img_detail;
    TextView detail_view;
    FragmentTransaction ft;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View HomeDetailFrg = inflater.inflate(R.layout.home_detail_fragment, container, false);
        img_detail = (ImageView)HomeDetailFrg.findViewById(R.id.img_detail);
        ft = getFragmentManager().beginTransaction();
        img_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageListFragment imageListFragment = new ImageListFragment();
                ft.replace(R.id.frame, imageListFragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        detail_view = (TextView)HomeDetailFrg.findViewById(R.id.tv_detail_views);
        detail_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommentDetailFragment commentDetailFragment = new CommentDetailFragment();
                ft.replace(R.id.frame,commentDetailFragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        RatingBar rb_detail = (RatingBar)HomeDetailFrg.findViewById(R.id.rb_detail);
        rb_detail.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getActivity(), String.valueOf(rating), Toast.LENGTH_LONG).show();
            }
        });
        return HomeDetailFrg;
    }
}
