package com.example.lookfan.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lookfan.R;
import com.example.lookfan.bean.FanTabBean;
import com.example.lookfan.widget.CircleImageView;
import com.example.lookfan.widget.WeekItemView;

import java.util.ArrayList;
import java.util.List;

public class FanWeekAdapter extends RecyclerView.Adapter<FanWeekAdapter.ViewHolder> {
    private List<FanTabBean> mBeans = new ArrayList<>();
    private Context context;
    private onMyClick mListener;

    public FanWeekAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(new WeekItemView(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.itemView.setClickable(true);
        holder.setData(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onTabClick(mBeans.get(position).getTitle(),mBeans.get(position).getUrl());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mBeans.size();
    }

    public void updateData(List<FanTabBean> Bean) {
        if (mBeans != null) {
            mBeans.clear();
            mBeans.addAll(Bean);
        }
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView img = itemView.findViewById(R.id.img);
        private TextView title = itemView.findViewById(R.id.title);
        private TextView drama = itemView.findViewById(R.id.drama);

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void setData(int position) {
            Glide.with(context).load(mBeans.get(position).getImg()).into(img);
            title.setText(mBeans.get(position).getTitle());
            drama.setText(mBeans.get(position).getDrama());
        }
    }

    public void setonMyClickListener(onMyClick listener) {
        this.mListener = listener;
    }

    public interface onMyClick {
        void onTabClick(String title,String url);
    }
}
