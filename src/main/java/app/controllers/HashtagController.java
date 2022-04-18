package app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.models.HashTag;
import app.services.HashTagService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class HashtagController {

	@Autowired // Handles the dependency injection of the service
	private HashTagService hashtagService;

	@GetMapping("/hashtags")
	public List<HashTag> getAllHashtagss() {
		return hashtagService.getAllHashTags();
	}

	@PostMapping("/hashtags")
	public HashTag createHashTag(@RequestBody HashTag hashtag) {
		return hashtagService.createHashTag(hashtag);
	}
}
