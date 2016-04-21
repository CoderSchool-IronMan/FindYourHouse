package com.vanistudio.homer.Fragment;

import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.vanistudio.homer.R;

/**
 * Created by User on 4/14/2016.
 */
public class CommentDetailFragment extends Fragment {
    ImageView imgComment;
    ImageView iv_report;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View frg_comment = inflater.inflate(R.layout.comment_detail_fragment, container, false);
        imgComment = (ImageView)frg_comment.findViewById(R.id.imgComment);
        iv_report = (ImageView)frg_comment.findViewById(R.id.iv_report);

        imgComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    showCustomDialog();
            }
            private void showCustomDialog(){
                final Dialog customDialog = new Dialog(getActivity());
                customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                customDialog.setContentView(R.layout.comment_dialog);
                final EditText etComment = (EditText)customDialog.findViewById(R.id.etComment);
                ((Button) customDialog.findViewById(R.id.btnCommentSend)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), etComment.getText().toString(),Toast.LENGTH_LONG).show();
                        customDialog.dismiss();
                    }
                });
                customDialog.show();
            }

        });
        iv_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
            private void showCustomDialog(){
                final Dialog customDialog = new Dialog(getActivity());
                customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                customDialog.setContentView(R.layout.comment_dialog);
                final EditText etComment = (EditText)customDialog.findViewById(R.id.etComment);
                ((Button) customDialog.findViewById(R.id.btnCommentSend)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), etComment.getText().toString(),Toast.LENGTH_LONG).show();
                        customDialog.dismiss();
                    }
                });
                customDialog.show();
            }

        });


        return frg_comment;
    }


}
