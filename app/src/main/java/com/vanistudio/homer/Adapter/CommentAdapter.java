package com.vanistudio.homer.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vanistudio.homer.Comment;
import com.vanistudio.homer.R;

import java.util.List;

/**
 * Created by User on 4/21/2016.
 */
public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder>{
    private List<Comment> mComment;
    public CommentAdapter(List<Comment> comments){
        mComment = comments;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View item_view = inflater.inflate(R.layout.item_review, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(item_view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(CommentAdapter.ViewHolder viewHolder, int i) {
        Comment comment = mComment.get(i);
        viewHolder.setData(comment);

    }

    @Override
    public int getItemCount() {
        return mComment.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView tvName, tvDate, tvComment;
        public Comment comment;
        public ViewHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            tvName = (TextView)itemView.findViewById(R.id.tv_name);
            tvComment = (TextView)itemView.findViewById(R.id.tv_comment);
            tvDate = (TextView)itemView.findViewById(R.id.tv_date);
        }
        public void setData(Comment comment){
            this.comment = comment;
            tvName.setText(comment.getmName());
            tvDate.setText(comment.getmDate());
            tvComment.setText(comment.getmComment());

        }

        @Override
        public void onClick(View v) {

        }
    }
}
