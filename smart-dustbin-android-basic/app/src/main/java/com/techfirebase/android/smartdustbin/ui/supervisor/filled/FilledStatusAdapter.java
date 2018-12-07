package com.techfirebase.android.smartdustbin.ui.supervisor.filled;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techfirebase.android.smartdustbin.R;

import java.util.List;



public class FilledStatusAdapter extends RecyclerView.Adapter<FilledStatusAdapter.MyViewHolder> {
    private List<FilledStatusModel> dustbinList;

    public FilledStatusAdapter(List<FilledStatusModel> dustbinList){
        this.dustbinList = dustbinList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView dustbinId, area , workerName, mobileNo, time;
        public MyViewHolder(View rowItemView) {
            super(rowItemView);
            dustbinId = rowItemView.findViewById(R.id.dustbinId);
            area = rowItemView.findViewById(R.id.areaName);
            workerName = rowItemView.findViewById(R.id.workerName);
            mobileNo = rowItemView.findViewById(R.id.workerMobileNo);
            time = rowItemView.findViewById(R.id.fillTime);
        }
    }

    @Override
    public FilledStatusAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View ItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_filled, parent, false);
        return new FilledStatusAdapter.MyViewHolder(ItemView);
    }

    @Override
    public void onBindViewHolder(FilledStatusAdapter.MyViewHolder holder, int position) {
        FilledStatusModel statusModel = dustbinList.get(position);
        holder.dustbinId.setText(statusModel.getDustbinId());
        holder.area.setText(statusModel.getArea());
        holder.workerName.setText(statusModel.getWorkerName());
        holder.mobileNo.setText(statusModel.getWorkerMobileNo());
        holder.time.setText(statusModel.getTime());
    }

    @Override
    public int getItemCount() {
        return dustbinList.size();
    }
}
