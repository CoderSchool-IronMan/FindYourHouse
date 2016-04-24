package com.vanistudio.homer.Fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.vanistudio.homer.R;

/**
 * Created by thuynh6 on 4/21/2016.
 */
public class NewHomeStep3Fragment extends Fragment {
    private Button btStep3Next;
    private OnButtonNextClickListener nextListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_home_step_3, container, false);
        btStep3Next = (Button) view.findViewById(R.id.btStep3Next);
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

        btStep3Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextListener.OnSetHomeSpec();
            }
        });
    }

    public interface OnButtonNextClickListener {
        public void OnSetHomeSpec();
    }
}
