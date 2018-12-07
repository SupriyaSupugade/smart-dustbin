package com.techfirebase.android.smartdustbin.ui.supervisor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.techfirebase.android.smartdustbin.R;
import com.techfirebase.android.smartdustbin.domain.Worker;
import com.techfirebase.android.smartdustbin.rest.ApiClient;
import com.techfirebase.android.smartdustbin.rest.ApiInterface;
import com.techfirebase.android.smartdustbin.util.AlertDialogManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class WorkerListActivity extends AppCompatActivity {
  private RecyclerView recyclerView;
  private RecyclerView.LayoutManager layoutManager;
  private RecyclerView.Adapter mAdapter;
  private ApiInterface apiInterface;
  private AlertDialogManager alert = new AlertDialogManager();
  private Toolbar myToolbar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_worker_list);

    // set toolbar as the appbar of the activity
    myToolbar = findViewById(R.id.workerListToolbar);
    setSupportActionBar(myToolbar);

    recyclerView = findViewById(R.id.workerListRecyclerView);

    // use this setting to improve performance if you know that changes
    // in content do not change the layout size of the RecyclerView
    recyclerView.setHasFixedSize(true);

    // use a linear layout manager
    layoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);

    // add the divider line between rows
    recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

    apiInterface = ApiClient.getClient().create(ApiInterface.class);
    apiInterface
        .getAllWorkers()
        .enqueue(
            new Callback<List<Worker>>() {
              @Override
              public void onResponse(Call<List<Worker>> call, Response<List<Worker>> response) {
                List<Worker> workerList = response.body();
                mAdapter = new WorkerListAdapter(workerList);
                // set the adapter
                recyclerView.setAdapter(mAdapter);
              }

              @Override
              public void onFailure(Call<List<Worker>> call, Throwable t) {
                Log.e(TAG, t.toString());
                alert.showAlertDialog(
                    getApplicationContext(),
                    "Loading Failed",
                    "Network error occured. Try again",
                    false);
              }
            });
  }
}
