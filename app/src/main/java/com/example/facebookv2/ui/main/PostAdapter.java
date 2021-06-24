package com.example.facebookv2.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facebookv2.R;
import com.example.facebookv2.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
  private List<PostModel>moviList = new ArrayList<>();

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
    holder.titleTV.setText(moviList.get(position).getTitle());
    holder.userTV.setText(moviList.get(position).getUserId()+"");
    holder.bodyTV.setText(moviList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return moviList.size();}

 public void setList(List<PostModel> moviList){
        this.moviList= moviList;
        notifyDataSetChanged();
 }
    public class PostViewHolder extends RecyclerView.ViewHolder{
        TextView titleTV,userTV,bodyTV;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.titleTV);
            userTV = itemView.findViewById(R.id.userIDTV);
            bodyTV = itemView.findViewById(R.id.titleTV);
        }
    }
}
