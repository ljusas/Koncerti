package com.example.fujitsu.mojprojekat.activity.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.fujitsu.mojprojekat.R;
import com.example.fujitsu.mojprojekat.activity.fragments.DetailFragment;
import com.example.fujitsu.mojprojekat.activity.fragments.MasterFragment;

public class MainActivity extends AppCompatActivity
        implements MasterFragment.OnItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {

    private boolean landscape = false;

    private int position = 0;

    private MasterFragment masterFragment = null;

    private DetailFragment detailFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            this.position = savedInstanceState.getInt("position");
        }

        masterFragment = new MasterFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.master_view, masterFragment,"Master_Fragment_1");
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();

        detailFragment = new DetailFragment();
        detailFragment.setContent(position);
        if (findViewById(R.id.detail_view)!= null){
            landscape = true;
            getFragmentManager().popBackStack();
            ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.detail_view, detailFragment, "Detail_Fragment_1");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
        case R.id.action_settings:
            Intent settings = new Intent(this,SettingsActivity.class);
            startActivity(settings);
            break;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (id == R.id.nav_camera) {
            Toast.makeText(this,"Uspešno ste dodali jelo",Toast.LENGTH_SHORT).show();
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(this,"Uspešno ste obrisali jelo",Toast.LENGTH_SHORT).show();
            drawer.closeDrawer(GravityCompat.START);
            return  true;
        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(this,"Uspešno ste izmenili jelo",Toast.LENGTH_SHORT).show();
            drawer.closeDrawer(GravityCompat.START);
            return  true;
        } else if (id == R.id.nav_manage) {
            Toast.makeText(this,"Pokrenuli ste aplikaciju Moj projekat koju je proizveo ljusas",Toast.LENGTH_SHORT).show();
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void openDetails() {
        DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.master_view);
        if (detailFragment == null) {
            detailFragment = new DetailFragment();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.detail_view, detailFragment, "Detail_Fragment_1");
            fragmentTransaction.addToBackStack("Detail_Fragment_1");
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("position", position);
    }

    @Override
    public void onItemSelected(int position) {

        this.position = position;

        if (landscape) {
            detailFragment.updateContent(position);
        } else {
            detailFragment.setContent(position);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.master_view, detailFragment, "Detail_Fragment_1");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();
        }
    }
}
