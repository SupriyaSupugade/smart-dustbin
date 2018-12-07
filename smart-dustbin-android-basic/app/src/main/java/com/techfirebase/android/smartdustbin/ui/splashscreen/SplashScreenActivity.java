package com.techfirebase.android.smartdustbin.ui.splashscreen;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.techfirebase.android.smartdustbin.R;
import com.techfirebase.android.smartdustbin.util.SessionManager;


public class SplashScreenActivity extends AppCompatActivity {
  private boolean isUserLoggedIn;
  // Splash screen timer
  private static int SPLASH_TIME_OUT = 3000;
  private SessionManager userSession;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_screen_splash);

    userSession = new SessionManager(getApplicationContext());

    new Handler()
        .postDelayed(
            new Runnable() {
              /*
               * Showing splash screen with a timer. This will be useful when you
               * want to show case your app logo / company
               */

              @Override
              public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity if user is already logged in
                /*if (isUserLoggedIn == true) {
                  Intent openSupervisor =
                      new Intent(getApplicationContext(), MainSupervisorActivity.class);
                  startActivity(openSupervisor);
                  // close this activity
                  finish();
                } else { // if user is not logged in
                  Intent openLogin =
                      new Intent(getApplicationContext(), LoginActivity.class);
                  startActivity(openLogin);
                  // close this activity
                  finish();
                }*/
                userSession.checkLogin();
              }
            },
            SPLASH_TIME_OUT);
  }

  /**
   * Async Task to make http call
   *
   * <p>private class PrefetchData extends AsyncTask<Void, Void, Void> { @Override protected void
   * onPreExecute() { super.onPreExecute(); // before making http calls
   *
   * <p>} @Override protected Void doInBackground(Void... arg0) { /* Will make http call here This
   * call will download required data before launching the app example: 1. Downloading and storing
   * in SQLite 2. Downloading images 3. Fetching and parsing the xml / json 4. Sending device
   * information to server 5. etc.,
   *
   * <p>return null; } @Override protected void onPostExecute(Void result) {
   * super.onPostExecute(result); // After completing http call // will close this activity and
   * lauch main activity Intent i = new Intent(SplashScreen.this, MainActivity.class);
   * i.putExtra("now_playing", now_playing); i.putExtra("earned", earned); startActivity(i);
   *
   * <p>// close this activity finish(); }
   *
   * <p>}
   */
}
