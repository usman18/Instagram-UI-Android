package com.uk.instagramui.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.uk.instagramui.Fragments.HomeFragment;
import com.uk.instagramui.Fragments.NotificationsFragment;
import com.uk.instagramui.Fragments.ProfileFragment;
import com.uk.instagramui.Fragments.SearchFragment;
import com.uk.instagramui.R;

public class MainActivity extends AppCompatActivity {
	
	//Random image urls below
	public static final String profilePicUrl = "https://instagram.fnag1-1.fna.fbcdn.net/vp/92a15d2c91d06d45f9a5b72ffd4cf3bd/5D84C9FD/t51.2885-19/s150x150/54731743_2011997322443409_3029283709959274496_n.jpg?_nc_ht=instagram.fnag1-1.fna.fbcdn.net";
	public static final String images[] = {profilePicUrl,
		"https://blog.rackspace.com/wp-content/uploads/2018/09/pumping-iron-arnold-schwarzenegger-1-1108x0-c-default.jpg",
		"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSijnCjlpixxnEcvYeKm-1pg6s2ohuD2VMcMoIzTZInCSZ57SJN",
		"https://pbs.twimg.com/profile_images/798351849984294912/okhePpJW.jpg",
		"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRhuaOnKGXWUAV7UMA9UhUQB66kaIne0HYKUDOgfzr8dCO2tchv"
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initialize();
	}
	
	
	private void initialize() {
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
		BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
		
		loadFragment(new HomeFragment());               //Default is home fragment
		
		bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
				
				switch (menuItem.getItemId()) {
					case R.id.home:
						return loadFragment(new HomeFragment());
					case R.id.search:
						return loadFragment(new SearchFragment());
					case R.id.notifications:
						return loadFragment(new NotificationsFragment());
					case R.id.profile:
						return loadFragment(new ProfileFragment());
				}
				
				return false;
			}
		});
	}
	
	
	private boolean loadFragment(Fragment fragment){
		
		if (fragment != null) {
			FragmentManager fm  = getSupportFragmentManager();
			fm.beginTransaction()
				.replace(R.id.container, fragment)
				.commit();
			return true;
		}
		return false;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		return true;
	}
}
