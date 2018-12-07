package com.techfirebase.android.smartdustbin.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.techfirebase.android.smartdustbin.R;
import com.techfirebase.android.smartdustbin.ui.supervisor.MainSupervisorActivity;
import com.techfirebase.android.smartdustbin.ui.worker.MainWorkerActivity;
import com.techfirebase.android.smartdustbin.util.AlertDialogManager;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity
    implements SignInFragment.OnLogInButtonClickListener,
        SignUpFragment.OnSubmitButtonClickListener {
  private Toolbar myToolbar;
  private TabLayout tabLayout;
  private ViewPager viewPager;
  private AlertDialogManager alert = new AlertDialogManager();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    // set toolbar as the appbar of the activity
    myToolbar = (Toolbar) findViewById(R.id.logInToolbar);
    setSupportActionBar(myToolbar);

    // Setting ViewPager
    viewPager = (ViewPager) findViewById(R.id.logInViewpager);
    setupViewPager(viewPager);

    // Set Tabs using view pager
    tabLayout = (TabLayout) findViewById(R.id.logInTabs);
    tabLayout.setupWithViewPager(viewPager);
  }

  private void setupViewPager(ViewPager viewPager) {
    ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
    adapter.addFragment(new SignInFragment(), "SIGNIN");
    adapter.addFragment(new SignUpFragment(), "SIGNUP");
    viewPager.setAdapter(adapter);
  }

  class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager manager) {
      super(manager);
    }

    @Override
    public Fragment getItem(int position) {
      return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
      return mFragmentList.size();
    }

    public void addFragment(Fragment fragment, String title) {
      mFragmentList.add(fragment);
      mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
      return mFragmentTitleList.get(position);
    }
  }

  @Override
  public void onLogInButtonClicked(String userType) {
    if (userType.equals("supervisor")) {
      Intent openSupervisor = new Intent(this, MainSupervisorActivity.class);
      startActivity(openSupervisor);
      finish();
    } else {
      Intent openWorker = new Intent(this, MainWorkerActivity.class);
      startActivity(openWorker);
      finish();
    }
  }

  @Override
  public void onSubmitButtonClicked() {
    Intent openLogInScreen = new Intent(this, LoginActivity.class);
    startActivity(openLogInScreen);
    finish();
  }
}
