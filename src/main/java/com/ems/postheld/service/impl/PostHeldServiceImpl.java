package com.ems.postheld.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ems.postheld.exception.PostHeldNotFoundException;
import com.ems.postheld.model.PostHeld;
import com.ems.postheld.payload.PostHeldDto;
import com.ems.postheld.repo.PostHeldRepo;
import com.ems.postheld.service.PostHeldService;
import com.ems.staffcategory.exception.StaffCategoryNotFoundException;
import com.ems.staffcategory.model.StaffCategory;
import com.ems.staffcategory.repo.StaffCategoryRepo;

@Service
public class PostHeldServiceImpl implements PostHeldService {

	private PostHeldRepo postHeldRepo;
	private ModelMapper modelMapper;
	private StaffCategoryRepo categoryRepo;

	public PostHeldServiceImpl(PostHeldRepo postHeldRepo, ModelMapper modelMapper, StaffCategoryRepo categoryRepo) {
		this.postHeldRepo = postHeldRepo;
		this.modelMapper = modelMapper;
		this.categoryRepo = categoryRepo;
	}

	@Override
	public PostHeldDto createPostHeld(PostHeldDto postHeldDto, int staffCategoryId) {

		StaffCategory staffCategory = categoryRepo.findById(staffCategoryId)
				.orElseThrow(() -> new StaffCategoryNotFoundException("Staff Category Not Found"));

		PostHeld postHeld = modelMapper.map(postHeldDto, PostHeld.class);
		postHeld.setStaffCategory(staffCategory);
		PostHeld saveHeld = postHeldRepo.save(postHeld);
		return modelMapper.map(saveHeld, PostHeldDto.class);
	}

	@Override
	public PostHeldDto updatePostHeld(int postHeldId, PostHeldDto postHeldDto, int staffCategoryId) {
		PostHeld postHeld = postHeldRepo.findById(postHeldId)
				.orElseThrow(() -> new PostHeldNotFoundException("PostHeld Not Found"));

		StaffCategory staffCategory = categoryRepo.findById(staffCategoryId)
				.orElseThrow(() -> new StaffCategoryNotFoundException("Staff Category Not Found"));

		postHeld.setTitle(postHeldDto.getTitle());
		postHeld.setStaffCategory(staffCategory);
		PostHeld updateHeld = postHeldRepo.save(postHeld);

		return modelMapper.map(updateHeld, PostHeldDto.class);
	}

	@Override
	public PostHeldDto getPostHeld(int postHeldId) {

		PostHeld postHeld = postHeldRepo.findById(postHeldId)
				.orElseThrow(() -> new PostHeldNotFoundException("PostHeld Not Found"));
		return modelMapper.map(postHeld, PostHeldDto.class);
	}

	@Override
	public List<PostHeldDto> postHeldList() {
		List<PostHeld> helds = postHeldRepo.findAll();
		List<PostHeldDto> heldDtos = helds.stream().map((held) -> modelMapper.map(held, PostHeldDto.class))
				.collect(Collectors.toList());

		return heldDtos;
	}

	@Override
	public void deletePostHeld(int postHeldId) {
		postHeldRepo.deleteById(postHeldId);
	}

}
