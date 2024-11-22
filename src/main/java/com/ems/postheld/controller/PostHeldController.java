package com.ems.postheld.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.postheld.model.PostHeld;
import com.ems.postheld.service.PostHeldService;

@RestController
@RequestMapping("/postHeld")
public class PostHeldController {

	private PostHeldService postHeldService;

	public PostHeldController(PostHeldService postHeldService) {
		this.postHeldService = postHeldService;
	}

	// Create PostHeld

	@PostMapping("/create")
	public ResponseEntity<PostHeld> createPostHeld(@RequestBody PostHeld postHeld) {
		PostHeld createPostHeld = postHeldService.createPostHeld(postHeld);

		return new ResponseEntity<PostHeld>(createPostHeld, HttpStatus.CREATED);
	}

	// Update PostHeld

	@PutMapping("/update/{postHeldId}")
	public ResponseEntity<PostHeld> updatePostHeld(@PathVariable("postHeldId") int postHeldId,
			@RequestBody PostHeld postHeld) {
		PostHeld updatePostHeld = postHeldService.updatePostHeld(postHeldId, postHeld);
		return new ResponseEntity<PostHeld>(updatePostHeld, HttpStatus.OK);
	}

	// Get PostHeld By Id

	@GetMapping("/{postHeldId}")
	public ResponseEntity<PostHeld> getPostHeldById(@PathVariable("postHeldId") int postHeldId) {
		PostHeld getPostHeld = postHeldService.getPostHeld(postHeldId);
		return new ResponseEntity<PostHeld>(getPostHeld, HttpStatus.OK);
	}

	// Get All PostHeld

	@GetMapping("/")
	public ResponseEntity<List<PostHeld>> getAllPostHeld() {
		List<PostHeld> postHeldList = postHeldService.postHeldList();
		return new ResponseEntity<List<PostHeld>>(postHeldList, HttpStatus.OK);
	}

	// Delete PostHeld

	@DeleteMapping("/{postHeldId}")
	public void deletePostHeld(@PathVariable("postHeldId") int postHeldId) {
		postHeldService.deletePostHeld(postHeldId);
	}

}
