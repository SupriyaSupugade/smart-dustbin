package com.techfirebase.android.smartdustbin.ui.supervisor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.techfirebase.android.smartdustbin.R;
import com.techfirebase.android.smartdustbin.domain.AreaWorker;
import com.techfirebase.android.smartdustbin.rest.ApiClient;
import com.techfirebase.android.smartdustbin.rest.ApiInterface;
import com.techfirebase.android.smartdustbin.util.AlertDialogManager;
import com.techfirebase.android.smartdustbin.util.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AssignWorkerActivity extends AppCompatActivity{
    private EditText mobileNo, areaId;
    private Button btnAssign;
    private Toolbar myToolbar;
    private SessionManager session;
    private ApiInterface apiInterface;
    private AlertDialogManager alert = new AlertDialogManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_worker);

        // set toolbar as the appbar of the activity
        myToolbar = findViewById(R.id.assignWorkerToolbar);
        setSupportActionBar(myToolbar);

        mobileNo = findViewById(R.id.workerMobNo);
        areaId = findViewById(R.id.workerArea);
        btnAssign = findViewById(R.id.assignButton);
        btnAssign.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                int area_id = Integer.parseInt(areaId.getText().toString());
                AreaWorker areaWorker = new AreaWorker(0,area_id,mobileNo.getText().toString());
                saveAreaWorker(areaWorker);
            }
        });

        session = new SessionManager(this);
    }

    private void saveAreaWorker(AreaWorker areaWorker){
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        apiInterface
                .saveAreaWorker(areaWorker)
                .enqueue(
                        new Callback<AreaWorker>() {
                            @Override
                            public void onResponse(Call<AreaWorker> call, Response<AreaWorker> response) {
                                if (response.isSuccessful() && response.body() != null) {
                                    AreaWorker areaWorkerResponse = response.body();
                                    mobileNo.setText("");
                                    areaId.setText("");
                                    Toast.makeText(
                                            getApplicationContext(),
                                            "Successfully assigned worker to the area",
                                            Toast.LENGTH_SHORT)
                                            .show();
                                }
                            }

                            @Override
                            public void onFailure(Call<AreaWorker> call, Throwable t) {
                                Log.e("TAG", t.toString());
                                alert.showAlertDialog(
                                        getApplicationContext(), "failed..", "Network error occured. Try again", false);
                            }
                        });

    }



}
