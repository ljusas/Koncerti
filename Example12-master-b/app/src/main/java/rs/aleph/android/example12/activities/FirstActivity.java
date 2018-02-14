package rs.aleph.android.example12.activities;

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
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


import java.text.FieldPosition;

import rs.aleph.android.example12.DrawerActivity;
import rs.aleph.android.example12.R;
import rs.aleph.android.example12.SettingsActivity;
import rs.aleph.android.example12.async.SimpleSyncTask;


public class FirstActivity extends AppCompatActivity implements MasterFragment.OnItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {

	private boolean landscape = false;

	private int position = 0;

	private MasterFragment masterFragment = null;

	private DetailFragment detailFragment = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) 	{


		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);


		if (savedInstanceState != null) {
			this.position = savedInstanceState.getInt("position");
		}

		masterFragment = new MasterFragment();
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.add(R.id.master_view, masterFragment, "Master_Fragment_1");
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		ft.commit();

		detailFragment = new DetailFragment();
		detailFragment.setContent(position);
		if (findViewById(R.id.detail_view) != null) {
			landscape = true;
			getFragmentManager().popBackStack();
			ft = getFragmentManager().beginTransaction();
			ft.replace(R.id.detail_view, detailFragment, "Detail_Fragment_1");
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.commit();
		}

		Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
		setSupportActionBar(toolbar);
		toolbar.setLogo(R.drawable.ic_action_name);

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
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu,menu);

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()){
			case R.id.app_settings:
				Intent settings = new Intent(this, SettingsActivity.class);
				startActivity(settings);
				break;

			case R.id.app_name_restoran:
				Toast.makeText(getApplicationContext(),"Podesili ste ime restorana.", Toast.LENGTH_LONG).show();
				break;

			case R.id.app_addres_restoran:
				Toast.makeText(getApplicationContext(),"Podesili ste adresu restorana.", Toast.LENGTH_LONG).show();
				break;

			case R.id.app_about:
				Toast.makeText(getApplicationContext(),"Pokrenuli ste aplikaciju FTN Homework od autora ljusa",Toast.LENGTH_LONG).show();
				break;

			case R.id.app_delete:
				Toast.makeText(getApplicationContext(),"Izbrisali ste jelo",Toast.LENGTH_LONG).show();
				break;

			case R.id.app_change:
				Toast.makeText(getApplicationContext(),"Izmenili ste jelo",Toast.LENGTH_LONG).show();
				break;

			case R.id.app_add:
				Toast.makeText(getApplicationContext(),"Dodali ste jelo",Toast.LENGTH_LONG).show();
				break;

			case R.id.action_refresh:
				Toast.makeText(FirstActivity.this, "Sinhronizacija pokrenuta u pozadini niti. dobro :)",Toast.LENGTH_SHORT).show();
				new SimpleSyncTask(FirstActivity.this).execute();
				break;

				default:

		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onNavigationItemSelected(MenuItem item) {

		int id = item.getItemId();

			if (id == R.id.nav_camera) {
				Toast.makeText(getApplicationContext(), "Izabrali ste stavku iz menija", Toast.LENGTH_LONG).show();
			} else if (id == R.id.nav_gallery) {
				Toast.makeText(getApplicationContext(), "Izabrali ste stavku iz menija", Toast.LENGTH_LONG).show();
			} else if (id == R.id.nav_slideshow) {
				Toast.makeText(getApplicationContext(), "Izabrali ste stavku iz menija", Toast.LENGTH_LONG).show();
			} else if (id == R.id.nav_manage) {
				Intent manage = new Intent(FirstActivity.this, DrawerActivity.class);
				startActivity(manage);
			}

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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
	protected void onStart() {

		super.onStart();
	}

	@Override
    protected void onRestart() {

		super.onRestart();
    }


	@Override
	protected void onResume() {

		super.onResume();
	}


	@Override
	protected void onPause() {

		super.onPause();
	}

	@Override
	protected void onStop() {

		super.onStop();
	}

	@Override
	protected void onDestroy() {

		super.onDestroy();
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
