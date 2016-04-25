package com.vanistudio.homer;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vanistudio.homer.Fragment.NewHomeStep1Fragment;
import com.vanistudio.homer.Fragment.NewHomeStep2Fragment;
import com.vanistudio.homer.Fragment.NewHomeStep2MapViewFragment;
import com.vanistudio.homer.Fragment.NewHomeStep3Fragment;
import com.vanistudio.homer.Fragment.NewHomeStep4Fragment;
import com.vanistudio.homer.Fragment.NewHomeStep5Fragment;
import com.vanistudio.homer.Fragment.NewHomeStepFinalFragment;

public class NewHomeActivity extends AppCompatActivity implements NewHomeStep1Fragment.OnItemClickListener,
                                                                  NewHomeStep2Fragment.OnButtonMapViewClickListener,
                                                                  NewHomeStep2Fragment.OnButtonNextClickListener,
                                                                  NewHomeStep3Fragment.OnButtonNextClickListener,
                                                                  NewHomeStep4Fragment.OnButtonNextClickListener,
                                                                  NewHomeStep5Fragment.OnButtonNextClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_home);

        NewHomeStep1Fragment fragment = new NewHomeStep1Fragment();
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.flNewHome, fragment);
        fragmentTransaction.commit();
    }

    private void replaceFragment_old (Fragment fragment){
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

    private void replaceFragment (android.support.v4.app.Fragment fragment){
        String backStateName = fragment.getClass().getName();

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        boolean fragmentPopped = fragmentManager.popBackStackImmediate(backStateName, 0);

        if (!fragmentPopped){ //fragment not in back stack, create it.
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
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
        //update Homer_Address object
        NewHomeStep3Fragment fragment = new NewHomeStep3Fragment();
        replaceFragment(fragment);
    }

    @Override
    public void OnSetHomeSpec() {
        //update Homer_Estate spec
        NewHomeStep4Fragment fragment = new NewHomeStep4Fragment();
        replaceFragment(fragment);
    }

    @Override
    public void OnSetHomePrice() {
        //update Homer price
        NewHomeStep5Fragment fragment = new NewHomeStep5Fragment();
        replaceFragment(fragment);
    }

    @Override
    public void OnSetGallery() {
        //set Homer_Images
        NewHomeStepFinalFragment fragment = new NewHomeStepFinalFragment();
        replaceFragment(fragment);
    }
}
