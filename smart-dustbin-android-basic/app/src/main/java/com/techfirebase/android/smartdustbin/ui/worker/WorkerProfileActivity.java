package com.techfirebase.android.smartdustbin.ui.worker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.EditText;

import com.techfirebase.android.smartdustbin.R;
import com.techfirebase.android.smartdustbin.domain.Worker;
import com.techfirebase.android.smartdustbin.rest.ApiClient;
import com.techfirebase.android.smartdustbin.rest.ApiInterface;
import com.techfirebase.android.smartdustbin.util.AlertDialogManager;
import com.techfirebase.android.smartdustbin.util.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class WorkerProfileActivity extends AppCompatActivity {
  private EditText fullName, mobileNo, adhar, address;
  private SessionManager session;
  private ApiInterface apiInterface;
  private Toolbar myToolbar;
  private AlertDialogManager alert = new AlertDialogManager();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_profile);

    // set toolbar as the appbar of the activity
    myToolbar = findViewById(R.id.profileToolbar);
    setSupportActionBar(myToolbar);

    fullName = findViewById(R.id.fullName);
    mobileNo = findViewById(R.id.mobileNo);
    adhar = findViewById(R.id.adharNo);
    address = findViewById(R.id.addressEmail);

    session = new SessionManager(this);

    apiInterface = ApiClient.getClient().create(ApiInterface.class);
    apiInterface
        .getWorkerById(session.getUsername())
        .enqueue(
            new Callback<Worker>() {
              @Override
              public void onResponse(Call<Worker> call, Response<Worker> response) {
                Worker worker = response.body();
                fullName.setText(worker.getWorkerName());
                fullName.setKeyListener(null);

                mobileNo.setText(worker.getWorkerMobileNo());
                mobileNo.setKeyListener(null);

                adhar.setText(worker.getWorkerAdharNo());
                adhar.setKeyListener(null);

                address.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_address, 0, 0, 0);
                address.setText(worker.getWorkerAddress());
                address.setKeyListener(null);
              }

              @Override
              public void onFailure(Call<Worker> call, Throwable t) {
                Log.e(TAG, t.toString());
                alert.showAlertDialog(
                    getApplicationContext(),
                    "Loading failed..",
                    "Network error occured. Try again",
                    false);
              }
            });
  }
}
