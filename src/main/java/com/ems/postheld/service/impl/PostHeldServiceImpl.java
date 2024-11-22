package com.ems.postheld.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.postheld.exception.PostHeldNotFoundException;
import com.ems.postheld.model.PostHeld;
import com.ems.postheld.repo.PostHeldRepo;
import com.ems.postheld.service.PostHeldService;

@Service
public class PostHeldServiceImpl implements PostHeldService {

	private PostHeldRepo postHeldRepo;

	public PostHeldServiceImpl(PostHeldRepo postHeldRepo) {
		this.postHeldRepo = postHeldRepo;
	}

	@Override
	public PostHeld createPostHeld(PostHeld postHeld) {
		PostHeld createPostHeld = postHeldRepo.save(postHeld);
		return createPostHeld;
	}

	@Override
	public PostHeld updatePostHeld(int postHeldId, PostHeld postHeld) {
		PostHeld getPostHeld = postHeldRepo.findById(postHeldId)
				.orElseThrow(() -> new PostHeldNotFoundException("PostHeld Not Found"));
		if (getPostHeld != null) {
			getPostHeld.setTitle(postHeld.getTitle());
			postHeldRepo.save(getPostHeld);
		}

		return getPostHeld;
	}

	@Override
	public PostHeld getPostHeld(int postHeldId) {

		PostHeld getPostHeld = postHeldRepo.findById(postHeldId)
				.orElseThrow(() -> new PostHeldNotFoundException("PostHeld Not Found"));
		return getPostHeld;
	}

	@Override
	public List<PostHeld> postHeldList() {
		List<PostHeld> postHeldList = postHeldRepo.findAll();
		return postHeldList;
	}

	@Override
	public void deletePostHeld(int postHeldId) {
		postHeldRepo.deleteById(postHeldId);
	}

}
