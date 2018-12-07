package com.techfirebase.android.smartdustbin.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class Utils {
  /**
   * Utility method to hide keyboard, use this when user click on any button(like signIn or singUp)
   * of any activity or fragment
   *
   * @param activity pass this from activity or pass this.getActivity() from fragment
   */
  public static void hideKeyboard(Activity activity) {
    View view = activity.getCurrentFocus();
    if (view != null) {
      InputMethodManager imm =
          (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
      if (imm != null) {
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
      }
    }
  }
}
