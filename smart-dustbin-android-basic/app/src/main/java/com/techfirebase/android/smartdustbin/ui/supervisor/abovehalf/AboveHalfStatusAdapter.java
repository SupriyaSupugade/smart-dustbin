package com.techfirebase.android.smartdustbin.ui.supervisor.abovehalf;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techfirebase.android.smartdustbin.R;

import java.util.List;

public class AboveHalfStatusAdapter
    extends RecyclerView.Adapter<AboveHalfStatusAdapter.MyViewHolder> {

  private List<AboveHalfStatusModel> dustbinList;

  public AboveHalfStatusAdapter(List<AboveHalfStatusModel> dustbinList) {
    this.dustbinList = dustbinList;
  }

  public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView dustbinId, area, time;

    public MyViewHolder(View rowItemView) {
      super(rowItemView);
      dustbinId = rowItemView.findViewById(R.id.dustbinId);
      area = rowItemView.findViewById(R.id.areaName);
      time = rowItemView.findViewById(R.id.halfTime);
    }
  }

  @Override
  public AboveHalfStatusAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View ItemView =
        LayoutInflater.from(parent.getContext())
            .inflate(R.layout.fragment_filled_below_half, parent, false);
    return new AboveHalfStatusAdapter.MyViewHolder(ItemView);
  }

  @Override
  public void onBindViewHolder(AboveHalfStatusAdapter.MyViewHolder holder, int position) {
    if (!dustbinList.isEmpty()) {
      AboveHalfStatusModel statusModel = dustbinList.get(position);
      holder.dustbinId.setText(statusModel.getDustbinId());
      holder.area.setText(statusModel.getArea());
      holder.time.setText(statusModel.getTime());
    }
  }

  @Override
  public int getItemCount() {
    return dustbinList.size();
  }
}
