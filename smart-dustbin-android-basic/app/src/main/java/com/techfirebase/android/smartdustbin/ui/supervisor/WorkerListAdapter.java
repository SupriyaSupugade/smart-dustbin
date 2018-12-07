package com.techfirebase.android.smartdustbin.ui.supervisor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techfirebase.android.smartdustbin.R;
import com.techfirebase.android.smartdustbin.domain.Worker;

import java.util.List;

public class WorkerListAdapter extends RecyclerView.Adapter<WorkerListAdapter.MyViewHolder> {
  private List<Worker> workerList;

  public WorkerListAdapter(List<Worker> workerList) {
    this.workerList = workerList;
  }

  public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView workerId, area, workerName, mobileNo;

    public MyViewHolder(View rowItemView) {
      super(rowItemView);
      workerId = rowItemView.findViewById(R.id.workerId);
      area = rowItemView.findViewById(R.id.areaName);
      workerName = rowItemView.findViewById(R.id.workerName);
      mobileNo = rowItemView.findViewById(R.id.mobileNo);
    }
  }

  @Override
  public WorkerListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View ItemView =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_worker_list, parent, false);
    return new WorkerListAdapter.MyViewHolder(ItemView);
  }

  @Override
  public void onBindViewHolder(WorkerListAdapter.MyViewHolder holder, int position) {
    Worker list = workerList.get(position);
    holder.workerId.setText(Integer.toString(list.getWorkerId()));
    holder.area.setText(list.getWorkerAddress());
    holder.workerName.setText(list.getWorkerName());
    holder.mobileNo.setText(list.getWorkerMobileNo());
  }

  @Override
  public int getItemCount() {
    return workerList.size();
  }
}
