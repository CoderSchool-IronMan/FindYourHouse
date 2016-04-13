package com.vanistudio.homer;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.vanistudio.homer.Fragment.HomeListRecyclerViewFragment;

/**
 * Created by thuynh6 on 4/11/2016.
 */
public class HomeListActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_list);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        HomeListRecyclerViewFragment fragment = new HomeListRecyclerViewFragment();
        fragmentTransaction.add(R.id.flHomeList, fragment);
        fragmentTransaction.commit();

    }
}
