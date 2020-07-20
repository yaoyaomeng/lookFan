package com.example.lookfan.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lookfan.R;
import com.example.lookfan.bean.HomeBean;
import com.example.lookfan.widget.HomeItemVIew;
import com.example.lookfan.widget.LoadItemView;

import java.util.ArrayList;
import java.util.List;

public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.ViewHolder> {
    private Context context;
    private List<HomeBean> homeBeans = new ArrayList<>();

   public HomeListAdapter(Context context) {
       this.context = context;
   }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            return new ViewHolder(new LoadItemView(parent.getContext()));
        } else {
            return new ViewHolder(new HomeItemVIew(parent.getContext()));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position == homeBeans.size())
            return;
                holder.setData(position);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == homeBeans.size()) {
            return 1;
        } else {
            return 0;
        }
    }

    public void updateData(List<HomeBean> result) {
        if (result != null) {
            homeBeans.clear();
            homeBeans.addAll(result);
        }
        notifyDataSetChanged();
    }


    public void updateMore(List<HomeBean> result) {
        if (result != null) {
            homeBeans.addAll(result);
        }
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return homeBeans.size() + 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView homeImage = itemView.findViewById(R.id.home_img);
        TextView titleText = itemView.findViewById(R.id.home_title);
        TextView tagText = itemView.findViewById(R.id.home_tag);
        TextView showText = itemView.findViewById(R.id.home_show);
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void setData(int position) {
            Glide.with(context).load(homeBeans.get(position).getImg()).into(homeImage);
            titleText.setText(homeBeans.get(position).getName());
            tagText.setText(homeBeans.get(position).getTag());
            showText.setText(homeBeans.get(position).getDesc());
        }
    }
}
