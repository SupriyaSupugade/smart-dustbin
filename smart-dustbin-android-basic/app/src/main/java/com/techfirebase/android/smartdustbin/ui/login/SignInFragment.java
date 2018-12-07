package com.techfirebase.android.smartdustbin.ui.login;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.techfirebase.android.smartdustbin.R;
import com.techfirebase.android.smartdustbin.domain.Worker;
import com.techfirebase.android.smartdustbin.rest.ApiClient;
import com.techfirebase.android.smartdustbin.rest.ApiInterface;
import com.techfirebase.android.smartdustbin.util.AlertDialogManager;
import com.techfirebase.android.smartdustbin.util.SessionManager;
import com.techfirebase.android.smartdustbin.util.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/** Created by Shivangi Singh on 26-03-2018. */
public class SignInFragment extends Fragment implements View.OnClickListener {
  private EditText userTxt, passwordTxt;
  private Button btnLogin;
  private RadioGroup radioGroup;
  private RadioButton radioButton;
  private View rootView;
  private OnLogInButtonClickListener mCallUser;
  private SessionManager session;
  private ApiInterface apiInterface;
  private ProgressBar spinner;
  // Alert Dialog Manager
  private AlertDialogManager alert = new AlertDialogManager();

  public SignInFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    rootView = inflater.inflate(R.layout.fragment_signin, container, false);

    userTxt = rootView.findViewById(R.id.signinUserid);
    passwordTxt = rootView.findViewById(R.id.signinPassword);
    radioGroup = rootView.findViewById(R.id.userType);
    btnLogin = rootView.findViewById(R.id.loginButton);
    btnLogin.setOnClickListener(this);

    spinner = rootView.findViewById(R.id.signInProgBar);
    // session class instance
    session = new SessionManager(getActivity());
    return rootView;
  }

  @Override
  public void onClick(View v) {
    Utils.hideKeyboard(this.getActivity());
    spinner.setVisibility(View.VISIBLE);
    final String username = userTxt.getText().toString();
    final String password = passwordTxt.getText().toString();
    radioButton = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
    String userType = radioButton.getText().toString();

    // Check if username, password is filled
    if (username.trim().length() > 0 && password.trim().length() > 0) {
      if (userType.equals("supervisor")) getSupervisorLogin(username, password);
      else getWorkerLogin(username, password);
    } else {
      // user didn't entered username or password
      // Show alert asking him to enter the details
      spinner.setVisibility(View.GONE);
      alert.showAlertDialog(
          getActivity(), "Login failed..", "Please enter username and password", false);
    }
  }

  private void getSupervisorLogin(final String username, final String password) {
    /*apiInterface = ApiClient.getClient().create(ApiInterface.class);
    apiInterface
        .getSupervisorById(username)
        .enqueue(
            new Callback<Supervisor>() {
              @Override
              public void onResponse(Call<Supervisor> call, Response<Supervisor> response) {
                Supervisor supervisor = response.body();

                if (supervisor.getSupervisorPassword().equals(password)) {
                  // Creating user login session
                  session.createLoginSession(username, "supervisor");
                  // calling login activity
                  mCallUser.onLogInButtonClicked("supervisor");
                  spinner.setVisibility(View.GONE);
                } else {
                  spinner.setVisibility(View.GONE);
                  // username / password doesn't match
                  alert.showAlertDialog(
                      getActivity(), "Login failed..", "Password is incorrect", false);
                }
              }

              @Override
              public void onFailure(Call<Supervisor> call, Throwable t) {
                spinner.setVisibility(View.GONE);
                Log.e(TAG, t.toString());
                alert.showAlertDialog(
                    getActivity(), "Login failed..", "Network error occured. Try again", false);
              }
            });*/

    //code just for checking
    if (password.equals("Abc@123")) {
      // Creating user login session
      session.createLoginSession(username, "supervisor");
      // calling login activity
      mCallUser.onLogInButtonClicked("supervisor");
      spinner.setVisibility(View.GONE);
    } else {
      spinner.setVisibility(View.GONE);
      // username / password doesn't match
      alert.showAlertDialog(
              getActivity(), "Login failed..", "Password is incorrect", false);
    }
  }

  private void getWorkerLogin(final String username, final String password) {
    apiInterface = ApiClient.getClient().create(ApiInterface.class);
    apiInterface
        .getWorkerById(username)
        .enqueue(
            new Callback<Worker>() {
              @Override
              public void onResponse(Call<Worker> call, Response<Worker> response) {
                Worker worker = response.body();

                if (worker.getWorkerPassword().equals(password)) {
                  // Creating user login session
                  session.createLoginSession(username, "worker");
                  // calling login activity
                  mCallUser.onLogInButtonClicked("worker");
                  spinner.setVisibility(View.GONE);
                } else {
                  spinner.setVisibility(View.GONE);
                  // username / password doesn't match
                  alert.showAlertDialog(
                      getActivity(), "Login failed..", "Password is incorrect", false);
                }
              }

              @Override
              public void onFailure(Call<Worker> call, Throwable t) {
                spinner.setVisibility(View.GONE);
                Log.e(TAG, t.toString());
                alert.showAlertDialog(
                    getActivity(), "Login failed..", "Network error occured. Try again", false);
              }
            });
  }
  // Container Activity must implement this interface
  public interface OnLogInButtonClickListener {
    void onLogInButtonClicked(String userType);
  }

  public void onAttach(Context context) {
    super.onAttach(context);
    try {
      mCallUser = (OnLogInButtonClickListener) context;
    } catch (ClassCastException e) {
      throw new ClassCastException(
          context.toString() + " must implement OnLogInButtonClickListener");
    }
  }
}
