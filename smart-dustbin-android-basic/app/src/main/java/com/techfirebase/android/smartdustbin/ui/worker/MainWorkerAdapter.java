package com.techfirebase.android.smartdustbin.ui.worker;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techfirebase.android.smartdustbin.R;

import java.util.List;

public class MainWorkerAdapter extends RecyclerView.Adapter<MainWorkerAdapter.MyViewHolder> {
  private List<MainWorkerModel> filledList;

  public MainWorkerAdapter(List<MainWorkerModel> listItem) {

    this.filledList = listItem;
  }

  public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView dustbinId, area, fillTime;

    public MyViewHolder(View rowItemView) {
      super(rowItemView);
      dustbinId = rowItemView.findViewById(R.id.dustbinId);
      area = rowItemView.findViewById(R.id.areaName);
      fillTime = rowItemView.findViewById(R.id.fillTime);
    }
  }

  @Override
  public MainWorkerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View ItemView =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dustbin_list, parent, false);
    return new MainWorkerAdapter.MyViewHolder(ItemView);
  }

  @Override
  public void onBindViewHolder(MainWorkerAdapter.MyViewHolder holder, int position) {

    MainWorkerModel list = filledList.get(position);
    holder.dustbinId.setText(list.getDustbinId());
    holder.area.setText(list.getArea());
    holder.fillTime.setText(list.getTime());
  }

  @Override
  public int getItemCount() {
    return filledList.size();
  }
}
