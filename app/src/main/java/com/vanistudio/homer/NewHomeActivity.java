package com.vanistudio.homer;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vanistudio.homer.Fragment.HomeListRecyclerViewFragment;
import com.vanistudio.homer.Fragment.NewHomeStep1Fragment;
import com.vanistudio.homer.Fragment.NewHomeStep2Fragment;
import com.vanistudio.homer.Fragment.NewHomeStep2MapViewFragment;

public class NewHomeActivity extends AppCompatActivity implements NewHomeStep1Fragment.OnItemClickListener,
                                                                  NewHomeStep2Fragment.OnButtonMapViewClickListener,
                                                                  NewHomeStep2Fragment.OnButtonNextClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_home);

        NewHomeStep1Fragment fragment = new NewHomeStep1Fragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.flNewHome, fragment);
        fragmentTransaction.commit();
    }

    private void replaceFragment (Fragment fragment){
        String backStateName = fragment.getClass().getName();

        FragmentManager fragmentManager = getFragmentManager();
        boolean fragmentPopped = fragmentManager.popBackStackImmediate(backStateName, 0);

        if (!fragmentPopped){ //fragment not in back stack, create it.
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.flNewHome, fragment);
            fragmentTransaction.addToBackStack(backStateName);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onBackPressed(){
        if(getFragmentManager().getBackStackEntryCount()>0){
            getFragmentManager().popBackStack();
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public void onSpaceTypeSelected(String spaceType) {
        //update Homer_Estate object
        NewHomeStep2Fragment fragment = new NewHomeStep2Fragment();
        replaceFragment(fragment);
    }

    @Override
    public void OpenMapViewFragment() {
        NewHomeStep2MapViewFragment fragment = new NewHomeStep2MapViewFragment();
        replaceFragment(fragment);
    }

    @Override
    public void OnSetAddressFromForm() {

    }
}
