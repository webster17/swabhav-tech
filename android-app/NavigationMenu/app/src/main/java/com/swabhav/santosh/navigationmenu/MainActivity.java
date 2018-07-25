package com.swabhav.santosh.navigationmenu;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar(savedInstanceState);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setUpToolbar(Bundle savedInstanceState) {

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new FirstFragement()).commit();
            navigationView.setCheckedItem(R.id.navigation1);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation1:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FirstFragement()).commit();
                break;
            case R.id.navigation2:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SecondFragement()).commit();
                break;
            case R.id.navigation3:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ThirdFragement()).commit();
                break;
            case R.id.navigation4:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FourthFragement()).commit();
                break;
            case R.id.navigation5:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FifthFragement()).commit();
                break;
            case R.id.sharable:
                Toast.makeText(this, "Sharable Clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.drawable:
                Toast.makeText(this, "Drawable Clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation11:
                Snackbar.make(getCurrentFocus(), "2nd Group 1st Fragement Clicked!",
                        Snackbar
                                .LENGTH_SHORT).show();
                break;
            case R.id.navigation12:
                Snackbar.make(getCurrentFocus(), "2nd Group 2nd Fragement Clicked!", Snackbar
                        .LENGTH_SHORT).show();
                break;
            case R.id.navigation13:
                Snackbar.make(getCurrentFocus(), "2nd Group 3rd Fragement Clicked!", Snackbar
                        .LENGTH_SHORT).show();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    private void setUpNavDrawer() {
        if (toolbar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationIcon(R.drawable.ic_drawer);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "Clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
