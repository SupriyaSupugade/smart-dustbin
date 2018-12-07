package com.techfirebase.android.smartdustbin.ui.supervisor.abovehalf;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.techfirebase.android.smartdustbin.R;
import com.techfirebase.android.smartdustbin.rest.ApiInterface;
import com.techfirebase.android.smartdustbin.util.AlertDialogManager;

import java.util.List;

public class AboveHalfStatusFragment extends Fragment {
  private View rootView;
  private TextView emptyView;
  private RecyclerView recyclerView;
  private RecyclerView.LayoutManager layoutManager;
  private RecyclerView.Adapter mAdapter;
  private AlertDialogManager alert = new AlertDialogManager();
  private List<AboveHalfStatusModel> aboveHalfFilledList;
  private ApiInterface apiInterface;
  private ProgressBar spinner;

  public AboveHalfStatusFragment() {}

  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    // Inflate the layout for this fragment
    rootView = inflater.inflate(R.layout.recyclerview, container, false);
    recyclerView = rootView.findViewById(R.id.myRecyclerView);
    emptyView = rootView.findViewById(R.id.empty_view);

    spinner = rootView.findViewById(R.id.supervisorProgBar);
    spinner.setVisibility(View.VISIBLE);

    // use this setting to improve performance if you know that changes
    // in content do not change the layout size of the RecyclerView
    // recyclerView.setHasFixedSize(true);

    // use a linear layout manager
    layoutManager = new LinearLayoutManager(getActivity());
    recyclerView.setLayoutManager(layoutManager);

    // add the divider line between rows
    recyclerView.addItemDecoration(
        new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

    getDustbinList();

    return rootView;
  }

  private void getDustbinList() {

    //aboveHalfFilledList = new ArrayList<>();
    /*apiInterface = ApiClient.getClient().create(ApiInterface.class);

    apiInterface
        .getDustbinList("above-half-filled")
        .enqueue(
            new Callback<List<DustbinResponse>>() {
              @Override
              public void onResponse(
                  Call<List<DustbinResponse>> call, Response<List<DustbinResponse>> response) {
                List<DustbinResponse> dustbinList = response.body();
                if (dustbinList != null) {
                  for (DustbinResponse dustbinResponse : dustbinList) {
                    Area area = dustbinResponse.getArea();
                    aboveHalfFilledList.add(
                        new AboveHalfStatusModel(
                            area.getDustbinId(),
                            area.getAreaName(),
                            new SimpleDateFormat("HH:mm")
                                .format(new Date(Long.parseLong(dustbinResponse.getTimestamp())))));
                  }
                }

                spinner.setVisibility(View.GONE);

                if (aboveHalfFilledList.isEmpty()) {
                  recyclerView.setVisibility(View.GONE);
                  emptyView.setVisibility(View.VISIBLE);
                } else {
                  recyclerView.setVisibility(View.VISIBLE);
                  emptyView.setVisibility(View.GONE);
                  // specify an adapter
                  mAdapter = new AboveHalfStatusAdapter(aboveHalfFilledList);
                  // set the adapter
                  recyclerView.setAdapter(mAdapter);
                }
              }

              @Override
              public void onFailure(Call<List<DustbinResponse>> call, Throwable t) {
                spinner.setVisibility(View.GONE);
                Log.e(TAG, t.toString());
                alert.showAlertDialog(
                    getActivity(), "Loading Failed", "Network error occurred. Try again", false);
              }
            });*/
    //code for checking
    spinner.setVisibility(View.GONE);
    recyclerView.setVisibility(View.GONE);
    emptyView.setVisibility(View.VISIBLE);
  }
}
