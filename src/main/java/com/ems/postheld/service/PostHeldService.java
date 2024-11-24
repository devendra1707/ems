package com.ems.postheld.service;

import java.util.List;

import com.ems.postheld.payload.PostHeldDto;

public interface PostHeldService {

	public PostHeldDto createPostHeld(PostHeldDto postHeldDto, int staffCategoryId);

	public PostHeldDto updatePostHeld(int postHeldId, PostHeldDto postHeldDto, int staffCategoryId);

	public PostHeldDto getPostHeld(int postHeldId);

	public List<PostHeldDto> postHeldList();

	public void deletePostHeld(int postHeldId);
}
