package com.uk.instagramui.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.uk.instagramui.Adapters.PostAdapter;
import com.uk.instagramui.Adapters.StoryAdapter;
import com.uk.instagramui.Model.Post;
import com.uk.instagramui.Model.Story;
import com.uk.instagramui.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.uk.instagramui.Activities.MainActivity.images;
import static com.uk.instagramui.Activities.MainActivity.profilePicUrl;

public class ProfileFragment extends Fragment {
	
	private CircleImageView profilePic;
	
	private RecyclerView rvStories;
	private StoryAdapter storyAdapter;
	
	private RecyclerView rvPosts;
	private PostAdapter postAdapter;
	
	private ArrayList<Story> stories;
	private ArrayList<Post> posts;
	
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.profile_layout, container, false);
	}
	
	
	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		
		profilePic = view.findViewById(R.id.profile_image);
		
		rvStories = view.findViewById(R.id.rvStories);
		rvPosts = view.findViewById(R.id.rvPosts);
		
		stories = new ArrayList<>();
		posts = new ArrayList<>();
		
		
		loadProfilePic();
		
		populateStories();
		storyAdapter = new StoryAdapter(getContext(), stories);
		
		LinearLayoutManager storiesLayoutManager = new LinearLayoutManager(getContext());
		storiesLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
		rvStories.setLayoutManager(storiesLayoutManager);
		
		rvStories.setAdapter(storyAdapter);
		
		populatePosts();
		postAdapter = new PostAdapter(getContext(), posts);
		StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
		rvPosts.setLayoutManager(staggeredGridLayoutManager);
		rvPosts.setAdapter(postAdapter);
		rvPosts.setNestedScrollingEnabled(false);
	
	}
	
	
	
	private void loadProfilePic() {
		
		if (!isDetached() && getContext() != null) {
			Glide.with(getContext())
				.load(profilePicUrl)
				.into(profilePic);
		}
		
	}
	
	
	
	private void populateStories() {
		//Population logic goes here
		
		stories.add(new Story(profilePicUrl, true));
		stories.add(new Story(images[1], true));
		stories.add(new Story(images[2], true));
		stories.add(new Story(images[3], false));
		stories.add(new Story(images[4], false));
		
	}
	
	
	
	private void populatePosts() {
		//Population logic goes here
		
		for (int i = 0; i < 12; i++) {                  //Populating a few images
			String storyImage = images[i%5];
			posts.add(new Post(storyImage));
		}
	}
	
	
}