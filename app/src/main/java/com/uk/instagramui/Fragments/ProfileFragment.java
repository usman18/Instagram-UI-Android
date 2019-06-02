package com.uk.instagramui.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.uk.instagramui.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {
	
	//Random image url for demonstration
	private final String url = "https://instagram.fnag1-1.fna.fbcdn.net/vp/92a15d2c91d06d45f9a5b72ffd4cf3bd/5D84C9FD/t51.2885-19/s150x150/54731743_2011997322443409_3029283709959274496_n.jpg?_nc_ht=instagram.fnag1-1.fna.fbcdn.net";
	
	private CircleImageView profilePic;
	
	
	
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.profile_layout, container, false);
	}
	
	
	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		
		profilePic = view.findViewById(R.id.profile_image);
		
		if (!isDetached() && getContext() != null) {
			Glide.with(getContext())
				.load(url)
				.into(profilePic);
		}
		
	
	}
}
