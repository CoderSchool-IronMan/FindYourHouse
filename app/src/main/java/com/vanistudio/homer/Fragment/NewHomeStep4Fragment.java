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
import android.widget.Button;
import android.widget.Spinner;

import com.vanistudio.homer.R;

/**
 * Created by thuynh6 on 4/21/2016.
 */
public class NewHomeStep4Fragment extends Fragment {
    private Spinner snPriceUnit;
    private Button btStep4Next;
    private OnButtonNextClickListener nextListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_home_step_4, container, false);
        snPriceUnit = (Spinner) view.findViewById(R.id.snStep4PriceUnit);
        btStep4Next = (Button) view.findViewById(R.id.btStep4Next);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.new_home_step_4_price, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        snPriceUnit.setAdapter(adapter);

        snPriceUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
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

        btStep4Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextListener.OnSetHomePrice();
            }
        });
    }

    public interface OnButtonNextClickListener {
        public void OnSetHomePrice();
    }
}
