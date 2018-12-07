package com.techfirebase.android.smartdustbin.ui.supervisor.belowhalf;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techfirebase.android.smartdustbin.R;

import java.util.List;


public class BelowHalfStatusAdapter extends RecyclerView.Adapter<BelowHalfStatusAdapter.MyViewHolder>{
    private List<BelowHalfStatusModel> dustbinList;
    public BelowHalfStatusAdapter(List<BelowHalfStatusModel> dustbinList) {
        this.dustbinList = dustbinList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView dustbinId, area , time;
        public MyViewHolder(View rowItemView) {
            super(rowItemView);
            dustbinId = rowItemView.findViewById(R.id.dustbinId);
            area = rowItemView.findViewById(R.id.areaName);
            time = rowItemView.findViewById(R.id.belowHalfTime);
        }
    }
    @Override
    public BelowHalfStatusAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View ItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_filled_below_half, parent, false);
        return new BelowHalfStatusAdapter.MyViewHolder(ItemView);
    }

    @Override
    public void onBindViewHolder(BelowHalfStatusAdapter.MyViewHolder holder, int position) {
        if(!dustbinList.isEmpty()){
            BelowHalfStatusModel statusModel = dustbinList.get(position);
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
