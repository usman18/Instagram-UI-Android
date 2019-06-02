package com.uk.instagramui.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.uk.instagramui.Fragments.HomeFragment;
import com.uk.instagramui.Fragments.NotificationsFragment;
import com.uk.instagramui.Fragments.ProfileFragment;
import com.uk.instagramui.Fragments.SearchFragment;
import com.uk.instagramui.R;

public class MainActivity extends AppCompatActivity {
	
	private BottomNavigationView bottomNavigationView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		bottomNavigationView = findViewById(R.id.bottomNav);
		
		loadFragment(new HomeFragment());
		
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
	
}
