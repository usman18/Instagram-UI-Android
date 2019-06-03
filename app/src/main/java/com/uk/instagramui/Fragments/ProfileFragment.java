package com.uk.instagramui.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import static com.uk.instagramui.Activities.MainActivity.storyImages;
import static com.uk.instagramui.Activities.MainActivity.url;

public class ProfileFragment extends Fragment {
	
	//Random image url for demonstration
	
	
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
		
		
		if (!isDetached() && getContext() != null) {
			Glide.with(getContext())
				.load(url)
				.into(profilePic);
		}
		
		stories.add(new Story(url, true));
		stories.add(new Story(storyImages[1], true));
		stories.add(new Story(storyImages[2], true));
		stories.add(new Story(storyImages[3], false));
		stories.add(new Story(storyImages[4], false));
		
		storyAdapter = new StoryAdapter(getContext(), stories);
		
		LinearLayoutManager storiesLayoutManager = new LinearLayoutManager(getContext());
		storiesLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
		rvStories.setLayoutManager(storiesLayoutManager);
		
		rvStories.setAdapter(storyAdapter);
		
		for (int i = 0; i < 12; i++) {                  //Populating a few images
			String storyImage = storyImages[i%5];
			posts.add(new Post(storyImage));
		}
		
		postAdapter = new PostAdapter(getContext(), posts);
		rvPosts.setLayoutManager(new GridLayoutManager(getContext(), 3));
		rvPosts.setAdapter(postAdapter);
		rvPosts.setNestedScrollingEnabled(false);
	}
}