package com.vanistudio.homer.Fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.vanistudio.homer.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by thuynh6 on 4/19/2016.
 */
public class NewHomeStep1Fragment extends Fragment {
    private ListView lvSpaceType;
    private OnItemClickListener listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_home_step_1, container, false);

        lvSpaceType = (ListView) view.findViewById(R.id.lvNewHomeSpaceType);

        ArrayList<String> optionList = new ArrayList<>();
        optionList = getSpaceTypeList();

        ArrayAdapter listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_view_new_home_space_type, optionList);
        lvSpaceType.setAdapter(listAdapter);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            Activity activity = (Activity) context;
            listener = (OnItemClickListener) activity;
        }
        catch (ClassCastException e){

        }
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        try {

            listener = (OnItemClickListener) context;
        }
        catch (ClassCastException e){

        }
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lvSpaceType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.onSpaceTypeSelected(lvSpaceType.getItemAtPosition(position).toString());
            }
        });
    }


    public interface OnItemClickListener {
        public void onSpaceTypeSelected(String spaceType);
    }

    private ArrayList<String> getSpaceTypeList(){
        String[] options = new String[] { "Apartment", "House", "Land" };
        ArrayList<String> optionList = new ArrayList<String>();
        optionList.addAll(Arrays.asList(options));
        return optionList;
    }
}
