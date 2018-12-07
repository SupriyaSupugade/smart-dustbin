package com.techfirebase.android.smartdustbin.ui.supervisor;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.techfirebase.android.smartdustbin.R;
import com.techfirebase.android.smartdustbin.domain.DustbinDetail;
import com.techfirebase.android.smartdustbin.rest.ApiClient;
import com.techfirebase.android.smartdustbin.rest.ApiInterface;
import com.techfirebase.android.smartdustbin.util.AlertDialogManager;
import com.techfirebase.android.smartdustbin.util.SessionManager;

import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddDustbinDetailActivity extends AppCompatActivity implements LocationListener {
  private EditText areaId, dustbinId, sensorId, lattitude, longitude;
  private TextView locationText;
  private Button btnAdd, btnGetLocation;
  private Toolbar myToolbar;
  private SessionManager session;
  private ApiInterface apiInterface;
  private AlertDialogManager alert = new AlertDialogManager();
  private LocationManager locationManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_dustbin_detail);

    // set toolbar as the appbar of the activity
    myToolbar = findViewById(R.id.addDustbinToolbar);
    setSupportActionBar(myToolbar);

    areaId = findViewById(R.id.areaId);
    dustbinId = findViewById(R.id.dustbinId);
    sensorId = findViewById(R.id.sensorId);
    lattitude = findViewById(R.id.lattitude);
    longitude = findViewById(R.id.longitude);
    locationText = findViewById(R.id.fullAddress);
    btnAdd = findViewById(R.id.addDustbinBtn);
    btnGetLocation = findViewById(R.id.getLocationBtn);

    btnGetLocation.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            getLocation();
          }
        });
    btnAdd.setOnClickListener(
        new View.OnClickListener() {
          public void onClick(View v) {
            // your handler code here
            int area_id = Integer.parseInt(areaId.getText().toString());

            DustbinDetail dustbinDetail =
                new DustbinDetail(
                    0,
                    dustbinId.getText().toString(),
                    sensorId.getText().toString(),
                    lattitude.getText().toString(),
                    longitude.getText().toString(),
                    area_id);
            saveDustbinDetail(dustbinDetail);
          }
        });

    session = new SessionManager(this);
  }

  void getLocation() {
    try {
      locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
      locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 5, this);
    } catch (SecurityException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void onLocationChanged(Location location) {
    lattitude.setText(Double.toString(location.getLatitude()));
    longitude.setText(Double.toString(location.getLongitude()));
    lattitude.setEnabled(false);
    lattitude.setFocusable(false);
    longitude.setEnabled(false);
    longitude.setFocusable(false);

    try {
      Geocoder geocoder = new Geocoder(this, Locale.getDefault());
      List<Address> addresses =
          geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
      Address address = addresses.get(0);
      locationText.setText(address.getAddressLine(0));
      for (int i = 1; i <= address.getMaxAddressLineIndex(); i++) {
        locationText.setText(", " + address.getAddressLine(i));
      }
      locationText.setVisibility(View.VISIBLE);
    } catch (Exception e) {

    }
  }

  @Override
  public void onProviderDisabled(String provider) {
    Toast.makeText(this, "Please Enable GPS and Internet", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onStatusChanged(String provider, int status, Bundle extras) {}

  @Override
  public void onProviderEnabled(String provider) {}

  private void saveDustbinDetail(DustbinDetail dustbinDetail) {
    apiInterface = ApiClient.getClient().create(ApiInterface.class);
    apiInterface
            .saveDustbinDetail(dustbinDetail)
            .enqueue(
                    new Callback<DustbinDetail>() {
                      @Override
                      public void onResponse(Call<DustbinDetail> call, Response<DustbinDetail> response) {
                        if (response.isSuccessful() && response.body() != null) {
                          DustbinDetail areaWorkerResponse = response.body();
                          areaId.setText("");
                          dustbinId.setText("");
                          sensorId.setText("");
                          lattitude.setEnabled(true);
                          lattitude.setText("");
                          lattitude.setFocusable(true);
                          longitude.setEnabled(true);
                          longitude.setText("");
                          longitude.setFocusable(true);
                          locationText.setVisibility(View.GONE);
                          locationText.setText("");


                          Toast.makeText(
                                  getApplicationContext(),
                                  "Successfully assigned worker to the area",
                                  Toast.LENGTH_SHORT)
                                  .show();
                        }
                      }

                      @Override
                      public void onFailure(Call<DustbinDetail> call, Throwable t) {
                        Log.e("TAG", t.toString());
                        alert.showAlertDialog(
                                getApplicationContext(), "failed..", "Network error occured. Try again", false);
                      }
                    });
  }
}
