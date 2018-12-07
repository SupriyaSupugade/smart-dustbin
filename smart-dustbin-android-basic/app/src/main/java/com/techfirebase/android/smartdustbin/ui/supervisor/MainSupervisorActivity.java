package com.techfirebase.android.smartdustbin.ui.supervisor;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.techfirebase.android.smartdustbin.R;
import com.techfirebase.android.smartdustbin.ui.supervisor.abovehalf.AboveHalfStatusFragment;
import com.techfirebase.android.smartdustbin.ui.supervisor.belowhalf.BelowHalfStatusFragment;
import com.techfirebase.android.smartdustbin.ui.supervisor.filled.FilledStatusFragment;
import com.techfirebase.android.smartdustbin.ui.supervisor.half.HalfStatusFragment;
import com.techfirebase.android.smartdustbin.util.SessionManager;

import java.util.ArrayList;
import java.util.List;

/** Created by Shivangi Singh on 28-03-2018. */
public class MainSupervisorActivity extends AppCompatActivity
  implements NavigationView.OnNavigationItemSelectedListener{
  private Toolbar myToolbar;
  private TabLayout tabLayout;
  private ViewPager viewPager;
  private SessionManager session;
  private DrawerLayout myDrawerLayout;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_supervisor);

    // set toolbar as the appbar of the activity
    myToolbar = (Toolbar) findViewById(R.id.supervisorToolbar);
    setSupportActionBar(myToolbar);

    myDrawerLayout = findViewById(R.id.drawer_layout);

    // enable app bar's "home" button and change it to use menu icon
    ActionBar actionBar = getSupportActionBar();
    actionBar.setDisplayHomeAsUpEnabled(true);
    actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

    // handle navigation click events
    NavigationView navigationView = findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this); //intiallizing nav view

    // Setting ViewPager
    viewPager = (ViewPager) findViewById(R.id.supervisorViewpager);
    setupViewPager(viewPager);

    // Set Tabs using view pager
    tabLayout = (TabLayout) findViewById(R.id.supervisorTabs);
    tabLayout.setupWithViewPager(viewPager);
    // sesion class instance
    session = new SessionManager(getApplicationContext());
  }

  private void setupViewPager(ViewPager viewPager) {
    ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
    adapter.addFragment(new FilledStatusFragment(), "FILLED");
    adapter.addFragment(new AboveHalfStatusFragment(), "ABOVE HALF");
    adapter.addFragment(new HalfStatusFragment(), "HALF");
    adapter.addFragment(new BelowHalfStatusFragment(), "BELOW HALF");
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

  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle item selection
    switch (item.getItemId()) {
      case android.R.id.home:
        myDrawerLayout.openDrawer(GravityCompat.START);
        return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @Override
  public void onBackPressed(){
    if (myDrawerLayout.isDrawerOpen(GravityCompat.START)) {
      myDrawerLayout.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
      // set item as selected to persist highlight
      menuItem.setChecked(true);
      // close drawer when item is tapped
      myDrawerLayout.closeDrawers();

      // Add code here to update the UI based on the item selected
      switch (menuItem.getItemId()) {
        case R.id.logOutItem:
          session.logoutUser();
          return true;
        case R.id.workerListItem:
          Intent openWorkerList = new Intent(this, WorkerListActivity.class);
          startActivity(openWorkerList);
          return true;
        case R.id.profileItem:
          Intent openProfile = new Intent(this, SupervisorProfileActivity.class);
          startActivity(openProfile);
          return true;
        case R.id.actionAddDustbin:
          Intent addDustbim = new Intent(this, AddDustbinDetailActivity.class);
          startActivity(addDustbim);
          return  true;
        case R.id.actionAssignWorker:
          Intent openAssignWorker = new Intent(this, AssignWorkerActivity.class);
          startActivity(openAssignWorker);
          return true;
      }

      return true;
    }

}
