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

import com.bumptech.glide.Glide;
import com.uk.instagramui.Adapters.StoryAdapter;
import com.uk.instagramui.Model.Story;
import com.uk.instagramui.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {
	
	//Random image url for demonstration
	private final String url = "https://instagram.fnag1-1.fna.fbcdn.net/vp/92a15d2c91d06d45f9a5b72ffd4cf3bd/5D84C9FD/t51.2885-19/s150x150/54731743_2011997322443409_3029283709959274496_n.jpg?_nc_ht=instagram.fnag1-1.fna.fbcdn.net";
	
	private String storyImages[] = {url,
		"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT0OtAYGGM9KBwBTfROmvIxNQQn6Mp3GPB_3akrAzw5hqU1mwTH",
		"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTX9oZAoe-82dFBs6SerY7Ggi4370lWpVyJ57b4o3zqfB-P5W1u",
		"https://upload.wikimedia.org/wikipedia/commons/b/be/Arnold_Schwarzenegger_-_2019_%2833730956438%29_%28cropped%29.jpg",
		"https://upload.wikimedia.org/wikipedia/en/0/0d/Avengers_Endgame_poster.jpg"
	};
	
	private CircleImageView profilePic;
	
	private RecyclerView rvStories;
	private StoryAdapter storyAdapter;
	
	private ArrayList<Story> stories;
	
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
		
		stories = new ArrayList<>();
		
		stories.add(new Story(url, true));
		stories.add(new Story(storyImages[1], true));
		stories.add(new Story(storyImages[2], true));
		stories.add(new Story(storyImages[3], false));
		stories.add(new Story(storyImages[4], false));
		
		
		if (!isDetached() && getContext() != null) {
			Glide.with(getContext())
				.load(url)
				.into(profilePic);
		}
		
		storyAdapter = new StoryAdapter(getContext(), stories);
		
		
		LinearLayoutManager storiesLayoutManager = new LinearLayoutManager(getContext());
		storiesLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
		rvStories.setLayoutManager(storiesLayoutManager);
		
		rvStories.setAdapter(storyAdapter);
		
	}
}
