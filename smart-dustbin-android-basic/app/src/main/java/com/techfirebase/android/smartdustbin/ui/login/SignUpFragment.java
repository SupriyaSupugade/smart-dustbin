package com.techfirebase.android.smartdustbin.ui.login;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.techfirebase.android.smartdustbin.R;
import com.techfirebase.android.smartdustbin.domain.Supervisor;
import com.techfirebase.android.smartdustbin.domain.Worker;
import com.techfirebase.android.smartdustbin.rest.ApiClient;
import com.techfirebase.android.smartdustbin.rest.ApiInterface;
import com.techfirebase.android.smartdustbin.util.AlertDialogManager;
import com.techfirebase.android.smartdustbin.util.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/** Created by Shivangi Singh on 26-03-2018. */
public class SignUpFragment extends Fragment implements View.OnClickListener {
  private EditText userTxt,
      passwordTxt,
      confirmPasswrdTxt,
      fullNameTxt,
      adharTxt,
      addressTxt,
      emailTxt,
      idTxt;

  private Button btnSubmit, btnReset;
  private RadioGroup radioGroup;
  private RadioButton radioButton;
  private View rootView;
  private AlertDialogManager alert = new AlertDialogManager();
  private OnSubmitButtonClickListener mSubmitSupervisor;
  private ProgressBar spinner;

  public SignUpFragment() {
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
    rootView = inflater.inflate(R.layout.fragment_signup, container, false);
    userTxt = rootView.findViewById(R.id.signUpUserid);
    passwordTxt = rootView.findViewById(R.id.signUpPassword);
    confirmPasswrdTxt = rootView.findViewById(R.id.confirmPassword);
    fullNameTxt = rootView.findViewById(R.id.fullName);
    adharTxt = rootView.findViewById(R.id.adharNo);
    addressTxt = rootView.findViewById(R.id.address);
    emailTxt = rootView.findViewById(R.id.emailId);
    idTxt = rootView.findViewById(R.id.supervisorId);
    radioGroup = rootView.findViewById(R.id.signUpUser);
    btnReset = rootView.findViewById(R.id.resetButton);
    btnReset.setOnClickListener(this);
    btnSubmit = rootView.findViewById(R.id.submitButton);
    btnSubmit.setOnClickListener(this);

    spinner = rootView.findViewById(R.id.signUpProgBar);

    radioGroup.setOnCheckedChangeListener(
        new RadioGroup.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(RadioGroup group, int checkedId) {
            // checkedId is the RadioButton selected
            switch (checkedId) {
              case R.id.radioWorker:
                idTxt.setVisibility(View.VISIBLE);
                emailTxt.setEnabled(false);
                emailTxt.setFocusable(false);
                return;
              case R.id.radioSupervisor:
                idTxt.setVisibility(View.GONE);
                addressTxt.setEnabled(false);
                addressTxt.setFocusable(false);
                return;
              default:
                return;
            }
          }
        });

    return rootView;
  }

  @Override
  public void onClick(View v) {
    Utils.hideKeyboard(this.getActivity());
    spinner.setVisibility(View.VISIBLE);
    radioButton = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
    String userType = radioButton.getText().toString();

    if (v.getId() == R.id.resetButton) {
      // To do here

      userTxt.setText("");
      passwordTxt.setText("");
      confirmPasswrdTxt.setText("");
      fullNameTxt.setText("");
      radioButton.setChecked(false);
      idTxt.setVisibility(View.VISIBLE);
      addressTxt.setEnabled(true);
      addressTxt.setFocusableInTouchMode(true);
      addressTxt.setText("");
      emailTxt.setEnabled(true);
      emailTxt.setFocusableInTouchMode(true);
      emailTxt.setText("");
      adharTxt.setText("");
      spinner.setVisibility(View.GONE);
    } else {
      boolean isDataOk = getDataValidated(userType); // to get data validated
      if (isDataOk) {
        if (userType.equals("supervisor")) {
          Supervisor supervisor =
              new Supervisor(
                  0,
                  fullNameTxt.getText().toString(),
                  emailTxt.getText().toString(),
                  userTxt.getText().toString(),
                  passwordTxt.getText().toString(),
                  adharTxt.getText().toString());
          saveSupervisor(supervisor);
        } else {
          int id = Integer.parseInt(idTxt.getText().toString());
          Worker worker =
              new Worker(0,fullNameTxt.getText().toString(),
                  addressTxt.getText().toString(),
                  userTxt.getText().toString(),
                  adharTxt.getText().toString(),
                  passwordTxt.getText().toString(),id);

          saveWorker(worker);
        }
      }
      spinner.setVisibility(View.GONE);
    }
  }

  private boolean getDataValidated(String userType) {
    boolean flag = true;
    if (userTxt.getText().length() == 0
        || passwordTxt.getText().length() == 0
        || confirmPasswrdTxt.getText().length() == 0
        || fullNameTxt.getText().length() == 0
        || (userType.equals("worker") && addressTxt.getText().length() == 0)
        || (userType.equals("supervisor") && emailTxt.getText().length() == 0)) {
      alert.showAlertDialog(getActivity(), "signin failed..", "All fields are required", false);
      return false;
    }
    if (!Patterns.PHONE.matcher(userTxt.getText().toString()).matches()) {
      flag = false;
      userTxt.setError("Insert valid mobile no.(+91-XXXXXXXXXX)");
    }
    /*if (!Pattern.matches(
        passwordTxt.getText().toString(), "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})")) {
      flag = false;
      passwordTxt.setError("Invalid password");
      alert.showAlertDialog(
          getActivity(),
          "signin failed..",
          "password must6 to 20 characters long with at least one digit, one upper case letter, one lower case letter and one special symbol (“@#$%”)",
          false);
    }*/

    if (!passwordTxt.getText().toString().equals(confirmPasswrdTxt.getText().toString())) {
      flag = false;
      confirmPasswrdTxt.setError("Password does not match.Re-enter password");
    }

    if (userType.equals("supervisor")
        && !Patterns.EMAIL_ADDRESS.matcher(emailTxt.getText().toString()).matches()) {
      flag = false;
    }
    return flag;
  }

  // Container Activity must implement this interface
  public interface OnSubmitButtonClickListener {
    void onSubmitButtonClicked();
  }

  // to ensure that Activity implements the interface otherwise throw error
  public void onAttach(Context context) {
    super.onAttach(context);
    try {
      mSubmitSupervisor = (OnSubmitButtonClickListener) context;
    } catch (ClassCastException e) {
      throw new ClassCastException(
          context.toString() + " must implement OnSubmitButtonClickListener");
    }
  }

  private void saveSupervisor(Supervisor supervisor) {
    ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
    apiInterface
        .saveSupervisor(supervisor)
        .enqueue(
            new Callback<Supervisor>() {
              @Override
              public void onResponse(Call<Supervisor> call, Response<Supervisor> response) {
                if (response.isSuccessful() && response.body() != null) {
                  Supervisor supervisorResponse = response.body();
                  Toast.makeText(
                          getActivity(),
                          "Successfully registered.Login to your acccount",
                          Toast.LENGTH_SHORT)
                      .show();
                  mSubmitSupervisor.onSubmitButtonClicked();
                  spinner.setVisibility(View.GONE);
                }
              }

              @Override
              public void onFailure(Call<Supervisor> call, Throwable t) {
                spinner.setVisibility(View.GONE);
                Log.e(TAG, t.toString());
                alert.showAlertDialog(
                    getActivity(), "signin failed..", "Network error occured. Try again", false);
              }
            });
  }

  private void saveWorker(Worker worker) {
    ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
    apiInterface
        .saveWorker(worker)
        .enqueue(
            new Callback<Worker>() {
              @Override
              public void onResponse(Call<Worker> call, Response<Worker> response) {
                if (response.isSuccessful() && response.body() != null) {
                  Worker workerResponse = response.body();
                  Toast.makeText(
                          getActivity(),
                          "Successfully registered.Login to your acccount",
                          Toast.LENGTH_SHORT)
                      .show();
                  mSubmitSupervisor.onSubmitButtonClicked();
                  spinner.setVisibility(View.GONE);
                }
              }

              @Override
              public void onFailure(Call<Worker> call, Throwable t) {
                spinner.setVisibility(View.GONE);
                Log.e(TAG, t.toString());
                alert.showAlertDialog(
                    getActivity(), "signin failed..", "Network error occured. Try again", false);
              }
            });
  }
}
