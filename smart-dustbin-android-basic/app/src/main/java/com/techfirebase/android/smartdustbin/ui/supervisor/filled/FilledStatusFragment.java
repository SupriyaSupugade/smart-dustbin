package com.techfirebase.android.smartdustbin.ui.supervisor.filled;

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

public class FilledStatusFragment extends Fragment {
  private View rootView;
  private TextView emptyView;
  private RecyclerView recyclerView;
  private RecyclerView.LayoutManager layoutManager;
  private RecyclerView.Adapter mAdapter;
  private ApiInterface apiInterface;
  private AlertDialogManager alert = new AlertDialogManager();
  private List<FilledStatusModel> filledList;
  private ProgressBar spinner;

  public FilledStatusFragment() {}

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
    //    spinner = new ProgressBar(container.getContext());
    spinner = rootView.findViewById(R.id.supervisorProgBar);
    spinner.setVisibility(View.VISIBLE);
    //    spinner.setVisibility(View.GONE);
    // use this setting to improve performance if you know that changes
    // in content do not change the layout size of the RecyclerView
    // recyclerView.setHasFixedSize(true);

    // use a linear layout manager
    layoutManager = new LinearLayoutManager(getActivity());
    recyclerView.setLayoutManager(layoutManager);

    // specify an adapter
    getDustbinList();
    // add the divider line between rows
    recyclerView.addItemDecoration(
        new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
    // set adapter in the recycler view

    return rootView;
  }

  private void getDustbinList() {
    /*filledList = new ArrayList<>();

    apiInterface = ApiClient.getClient().create(ApiInterface.class);

    apiInterface
        .getDustbinList("filled")
        .enqueue(
            new Callback<List<DustbinResponse>>() {
              @Override
              public void onResponse(
                  Call<List<DustbinResponse>> call, Response<List<DustbinResponse>> response) {
                List<DustbinResponse> dustbinList = response.body();
                if (dustbinList != null) {
                  for (DustbinResponse dustbinResponse : dustbinList) {
                    Area area = dustbinResponse.getArea();
                    filledList.add(
                        new FilledStatusModel(
                            area.getDustbinId(),
                            area.getAreaName(),
                            area.getWorkers().get(0).getWorkerName(),
                            area.getWorkers().get(0).getWorkerMobileNo(),
                            new SimpleDateFormat("HH:mm")
                                .format(new Date(Long.parseLong(dustbinResponse.getTimestamp())))));
                  }
                }

                spinner.setVisibility(View.GONE);

                if (filledList.isEmpty()) {
                  recyclerView.setVisibility(View.GONE);
                  emptyView.setVisibility(View.VISIBLE);
                } else {
                  recyclerView.setVisibility(View.VISIBLE);
                  emptyView.setVisibility(View.GONE);
                  // specify an adapter
                  mAdapter = new FilledStatusAdapter(filledList);
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
    spinner.setVisibility(View.GONE);
    recyclerView.setVisibility(View.GONE);
    emptyView.setVisibility(View.VISIBLE);
  }
}
