package com.techfirebase.android.smartdustbin.util;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;


public class AlertDialogManager {
  /**
   * Function to display simple Alert Dialog
   *
   * @param context - application context
   * @param title - alert dialog title
   * @param message - alert message
   *
   */
  public void showAlertDialog(Context context, String title, String message, Boolean status) {
    AlertDialog.Builder builder = new AlertDialog.Builder(context);

    // Setting Dialog Title
    builder.setTitle(title);

    // Setting Dialog Message
    builder.setMessage(message);

    // Setting OK Button
    builder.setPositiveButton(
        "OK",
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            // positive button logic
          }
        });

    AlertDialog alertDialog = builder.create();
    // Showing Alert Message
    alertDialog.show();
  }
}
