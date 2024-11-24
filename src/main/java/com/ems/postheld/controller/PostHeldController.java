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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ems.postheld.payload.PostHeldDto;
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
	public ResponseEntity<PostHeldDto> createPostHeld(@RequestBody PostHeldDto postHeld,
			@RequestParam int staffCategoryId) {
		PostHeldDto createPostHeld = postHeldService.createPostHeld(postHeld, staffCategoryId);

		return new ResponseEntity<PostHeldDto>(createPostHeld, HttpStatus.CREATED);
	}

	// Update PostHeld

	@PutMapping("/update/{postHeldId}")
	public ResponseEntity<PostHeldDto> updatePostHeld(@PathVariable("postHeldId") int postHeldId,
			@RequestBody PostHeldDto postHeld, @RequestParam int staffCategoryId) {
		PostHeldDto updatePostHeld = postHeldService.updatePostHeld(postHeldId, postHeld, staffCategoryId);
		return new ResponseEntity<PostHeldDto>(updatePostHeld, HttpStatus.OK);
	}

	// Get PostHeld By Id

	@GetMapping("/{postHeldId}")
	public ResponseEntity<PostHeldDto> getPostHeldById(@PathVariable("postHeldId") int postHeldId) {
		PostHeldDto getPostHeld = postHeldService.getPostHeld(postHeldId);
		return new ResponseEntity<PostHeldDto>(getPostHeld, HttpStatus.OK);
	}

	// Get All PostHeld

	@GetMapping("/")
	public ResponseEntity<List<PostHeldDto>> getAllPostHeld() {
		List<PostHeldDto> postHeldList = postHeldService.postHeldList();
		return new ResponseEntity<List<PostHeldDto>>(postHeldList, HttpStatus.OK);
	}

	// Delete PostHeld

	@DeleteMapping("/{postHeldId}")
	public void deletePostHeld(@PathVariable("postHeldId") int postHeldId) {
		postHeldService.deletePostHeld(postHeldId);
	}

}
