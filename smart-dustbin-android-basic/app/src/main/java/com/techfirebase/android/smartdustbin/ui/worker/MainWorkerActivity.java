package com.techfirebase.android.smartdustbin.ui.worker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.techfirebase.android.smartdustbin.R;
import com.techfirebase.android.smartdustbin.rest.ApiInterface;
import com.techfirebase.android.smartdustbin.util.AlertDialogManager;
import com.techfirebase.android.smartdustbin.util.SessionManager;

import java.util.List;

public class MainWorkerActivity extends AppCompatActivity {
  private TextView emptyView;
  private Toolbar myToolbar;
  private SessionManager session;
  private RecyclerView recyclerView;
  private RecyclerView.LayoutManager layoutManager;
  private RecyclerView.Adapter mAdapter;
  private List<MainWorkerModel> filledList;
  private ApiInterface apiInterface;
  private AlertDialogManager alert = new AlertDialogManager();
  private SessionManager sessionObject;
  private ProgressBar spinner;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_worker);

    sessionObject = new SessionManager(getApplicationContext());

    // set toolbar as the appbar of the activity
    myToolbar = findViewById(R.id.workerToolbar);
    setSupportActionBar(myToolbar);

    // sesion class instance
    session = new SessionManager(getApplicationContext());

    recyclerView = findViewById(R.id.workerRecyclerView);
    emptyView = findViewById(R.id.empty_view);
    spinner = findViewById(R.id.workerProgBar);
    spinner.setVisibility(View.VISIBLE);

    // use this setting to improve performance if you know that changes
    // in content do not change the layout size of the RecyclerView
    // recyclerView.setHasFixedSize(true);

    // use a linear layout manager
    layoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);

    getFilledItems();

    // add the divider line between rows
    recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
  }

  private void getFilledItems() {
    /*final String userid = sessionObject.getUsername();
    filledList = new ArrayList<>();

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
                    if (userid != null
                        && userid.equals(area.getWorkers().get(0).getWorkerMobileNo())) {
                      filledList.add(
                          new MainWorkerModel(
                              area.getDustbinId(),
                              area.getAreaName(),
                              new SimpleDateFormat("HH:mm")
                                  .format(
                                      new Date(Long.parseLong(dustbinResponse.getTimestamp())))));
                    }
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
                  mAdapter = new MainWorkerAdapter(filledList);
                  // set the adapter
                  recyclerView.setAdapter(mAdapter);
                }
              }

              @Override
              public void onFailure(Call<List<DustbinResponse>> call, Throwable t) {
                spinner.setVisibility(View.GONE);
                Log.e(TAG, t.toString());
                alert.showAlertDialog(
                    getApplicationContext(),
                    "Loading Failed",
                    "Network error occurred. Try again",
                    false);
              }
            });*/
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.worker_menu, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle item selection
    switch (item.getItemId()) {
      case R.id.logOutItem:
        session.logoutUser();
        return true;
      case R.id.profileItem:
        Intent openProfile = new Intent(this, WorkerProfileActivity.class);
        startActivity(openProfile);
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }
}
