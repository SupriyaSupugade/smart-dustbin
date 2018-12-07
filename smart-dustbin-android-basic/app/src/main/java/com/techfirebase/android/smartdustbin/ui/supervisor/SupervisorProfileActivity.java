package com.techfirebase.android.smartdustbin.ui.supervisor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.EditText;

import com.techfirebase.android.smartdustbin.R;
import com.techfirebase.android.smartdustbin.domain.Supervisor;
import com.techfirebase.android.smartdustbin.rest.ApiClient;
import com.techfirebase.android.smartdustbin.rest.ApiInterface;
import com.techfirebase.android.smartdustbin.util.AlertDialogManager;
import com.techfirebase.android.smartdustbin.util.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SupervisorProfileActivity extends AppCompatActivity {
  private EditText fullName, mobileNo, adhar, email;
  private Toolbar myToolbar;
  private SessionManager session;
  private ApiInterface apiInterface;
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
    email = findViewById(R.id.addressEmail);

    session = new SessionManager(this);

    apiInterface = ApiClient.getClient().create(ApiInterface.class);
    apiInterface
        .getSupervisorById(session.getUsername())
        .enqueue(
            new Callback<Supervisor>() {
              @Override
              public void onResponse(Call<Supervisor> call, Response<Supervisor> response) {
                Supervisor supervisor = response.body();
                fullName.setText(supervisor.getSupervisorName());
                fullName.setKeyListener(null);

                mobileNo.setText(supervisor.getSupervisorMobileNo());
                mobileNo.setKeyListener(null);

                adhar.setText(supervisor.getSupervisorAdharNo());
                adhar.setKeyListener(null);

                email.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_address, 0, 0, 0);
                email.setText(supervisor.getSupervisorEmail());
                email.setKeyListener(null);
              }

              @Override
              public void onFailure(Call<Supervisor> call, Throwable t) {
                Log.e("TAG", t.toString());
                alert.showAlertDialog(
                    getApplicationContext(),
                    "Loading failed..",
                    "Network error occured. Try again",
                    false);
              }
            });
  }
}
