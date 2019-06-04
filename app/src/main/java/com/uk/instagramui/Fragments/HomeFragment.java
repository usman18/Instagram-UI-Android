package com.uk.instagramui.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uk.instagramui.Activities.MainActivity;
import com.uk.instagramui.Adapters.TimelinePostAdapter;
import com.uk.instagramui.Model.TimelinePost;
import com.uk.instagramui.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
	
	private RecyclerView rvPosts;
	private TimelinePostAdapter postAdapter;
	private ArrayList<TimelinePost> posts;
	
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.home_layout, container, false);
	}
	
	
	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		
		
		posts = new ArrayList<>();
		rvPosts = view.findViewById(R.id.rvPosts);
		
		//Populating posts
		posts.add(new TimelinePost(MainActivity.images[0], "schwarzenegger", MainActivity.images[1],112, "How is that UI boy?", "10 min ago"));
		posts.add(new TimelinePost(MainActivity.images[3], "Conor McGregor", MainActivity.images[3],200, "World Champion!", "2 hr ago"));
		
		rvPosts.setLayoutManager(new LinearLayoutManager(getContext()));
		
		postAdapter = new TimelinePostAdapter(getContext(), posts);
		rvPosts.setAdapter(postAdapter);
		
	}
}
