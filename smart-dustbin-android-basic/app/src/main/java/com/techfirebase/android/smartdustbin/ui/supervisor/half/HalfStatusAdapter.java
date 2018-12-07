package com.techfirebase.android.smartdustbin.ui.supervisor.half;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techfirebase.android.smartdustbin.R;

import java.util.List;



public class HalfStatusAdapter extends RecyclerView.Adapter<HalfStatusAdapter.MyViewHolder> {
    private List<HalfStatusModel> dustbinList;
    public HalfStatusAdapter(List<HalfStatusModel> dustbinList) {
        this.dustbinList = dustbinList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView dustbinId, area , time;
        public MyViewHolder(View rowItemView) {
            super(rowItemView);
            dustbinId = rowItemView.findViewById(R.id.dustbinId);
            area = rowItemView.findViewById(R.id.areaName);
            time = rowItemView.findViewById(R.id.halfTime);
        }
    }
    @Override
    public HalfStatusAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View ItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_filled_half, parent, false);
        return new HalfStatusAdapter.MyViewHolder(ItemView);
    }

    @Override
    public void onBindViewHolder(HalfStatusAdapter.MyViewHolder holder, int position) {
    if (!dustbinList.isEmpty()) {
          HalfStatusModel statusModel = dustbinList.get(position);
          holder.dustbinId.setText(statusModel.getDustbinId());
          holder.area.setText(statusModel.getArea());
          holder.time.setText(statusModel.getTime());
        }
    }

    @Override
    public int getItemCount() {
        return  dustbinList.size();
    }
}
