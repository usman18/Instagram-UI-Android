package com.uk.instagramui.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.uk.instagramui.Model.TimelinePost;
import com.uk.instagramui.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class TimelinePostAdapter extends RecyclerView.Adapter<TimelinePostAdapter.PostViewHolder> {
	
	private Context context;
	private ArrayList<TimelinePost> posts;
	
	public TimelinePostAdapter(Context context, ArrayList<TimelinePost> posts) {
		this.context = context;
		this.posts = posts;
	}
	
	@NonNull
	@Override
	public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
		return new PostViewHolder(LayoutInflater.from(context)
			.inflate(R.layout.home_post_layout, viewGroup, false));
	}
	
	@Override
	public void onBindViewHolder(@NonNull PostViewHolder postViewHolder, int i) {
		TimelinePost post = posts.get(i);
		
		Glide.with(context)
			.load(post.getProfilePic())
			.into(postViewHolder.profilePic);
		

		Glide.with(context)
			.load(post.getImageUrl())
			.into(postViewHolder.imgPost);
		
		postViewHolder.tvName.setText(post.getName());
		postViewHolder.tvLikes.setText(post.getLikes() + " likes");
		postViewHolder.tvCaption.setText(post.getCaption());
		postViewHolder.tvDate.setText(post.getDate());
		
	}
	
	@Override
	public int getItemCount() {
		if (posts != null) {
			return posts.size();
		}
		return 0;
	}
	
	class PostViewHolder extends RecyclerView.ViewHolder {
		CircleImageView profilePic;
		TextView tvName;
		ImageView imgPost;
		TextView tvLikes;
		TextView tvCaption;
		TextView tvDate;
		
		PostViewHolder(@NonNull View itemView) {
			super(itemView);
			profilePic = itemView.findViewById(R.id.profile_image);
			tvName = itemView.findViewById(R.id.tvName);
			imgPost = itemView.findViewById(R.id.imgPost);
			tvLikes = itemView.findViewById(R.id.tvLikes);
			tvCaption = itemView.findViewById(R.id.tvCaption);
			tvDate = itemView.findViewById(R.id.tvDate);
			
		}
	}
}