package com.vanistudio.homer;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.vanistudio.homer.Fragment.HomeDetailFragment;

public class DetailActivity extends AppCompatActivity {
    FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HomeDetailFragment homeDetailFragment = new HomeDetailFragment();
        ft = getFragmentManager().beginTransaction();
        ft.add(R.id.frame, homeDetailFragment);
        ft.commit();
    }
    public void onBackPressed(View view){
        onBackPressed();
    }
    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount()>0){
            getFragmentManager().popBackStack();
        }else{
            super.onBackPressed();
        }
    }
}

