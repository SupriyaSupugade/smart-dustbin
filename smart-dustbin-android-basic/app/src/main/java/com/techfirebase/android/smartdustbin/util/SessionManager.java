package com.techfirebase.android.smartdustbin.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.techfirebase.android.smartdustbin.ui.login.LoginActivity;
import com.techfirebase.android.smartdustbin.ui.supervisor.MainSupervisorActivity;
import com.techfirebase.android.smartdustbin.ui.worker.MainWorkerActivity;


public class SessionManager {
  // Shared Preferences
  SharedPreferences pref;

  // Editor for Shared preferences
  SharedPreferences.Editor editor;

  // Context
  Context _context;

  // Shared pref mode
  int PRIVATE_MODE = 0;

  // Sharedpref file name
  private static final String PREF_NAME = "SmartDustbinUserPref";

  // All Shared Preferences Keys
  private static final String IS_LOGIN = "IsLoggedIn";

  // User name (make variable public to access from outside)
  public static final String KEY_NAME = "username";

  // User type(worker or supervisor)
  public static final String KEY_TYPE = "type";

  // Constructor
  public SessionManager(Context context) {
    this._context = context;
    pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
    editor = pref.edit();
  }

  // Create login session

  public void createLoginSession(String username, String usertype) {
    // Storing login value as TRUE
    editor.putBoolean(IS_LOGIN, true);

    // Storing name in pref
    editor.putString(KEY_NAME, username);

    // Storing user type
    editor.putString(KEY_TYPE, usertype);

    // commit changes
    editor.apply();
  }

  // Get stored session data

  public String getUsername() {
    return pref.getString(KEY_NAME, null);
  }

  public String getUsertype() {
    return pref.getString(KEY_TYPE, null);
  }

  /**
   * Check login method wil check user login status If false it will redirect user to login page
   * Else won't do anything
   */
  public void checkLogin() {
    // Check login status
    if (!this.isLoggedIn()) {
      // user is not logged in redirect him to Login Activity
      Intent i = new Intent(_context, LoginActivity.class);
      // Closing all the Activities
      i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

      // Add new Flag to start new Activity
      i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

      // Staring Login Activity
      _context.startActivity(i);
    } else {
      // user is logged in
      Intent i;
      if (getUsertype().equals("supervisor"))
        i = new Intent(_context, MainSupervisorActivity.class);
      else i = new Intent(_context, MainWorkerActivity.class);
      // Closing all the Activities
      i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
      // Add new Flag to start new Activity
      i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
      // start new activity
      _context.startActivity(i);
    }
  }

  /** Clear session details */
  public void logoutUser() {
    // Clearing all data from Shared Preferences
    editor.clear();
    editor.commit();

    // After logout redirect user to Login Activity
    Intent i = new Intent(_context, LoginActivity.class);
    // Closing all the Activities
    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

    // Add new Flag to start new Activity
    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

    // Staring Login Activity
    _context.startActivity(i);
  }
  // Get Login State
  public boolean isLoggedIn() {
    return pref.getBoolean(IS_LOGIN, false);
  }
}
