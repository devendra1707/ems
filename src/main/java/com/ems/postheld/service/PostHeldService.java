package com.ems.postheld.service;

import java.util.List;

import com.ems.postheld.model.PostHeld;

public interface PostHeldService {

	public PostHeld createPostHeld(PostHeld postHeld);

	public PostHeld updatePostHeld(int postHeldId, PostHeld postHeld);

	public PostHeld getPostHeld(int postHeldId);

	public List<PostHeld> postHeldList();

	public void deletePostHeld(int postHeldId);
}
