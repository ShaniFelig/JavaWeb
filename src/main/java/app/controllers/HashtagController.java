package app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import app.models.Hashtag;
import app.services.HashTagService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class HashtagController {

	@Autowired // Handles the dependency injection of the service
	private HashTagService hashtagService;

	@GetMapping("/hashtags")
	public List<Hashtag> getAllHashtags() {
		return hashtagService.getAllHashTags();
	}

	/*
	 * @PostMapping("/hashtags") public Hashtag createHashTag(@RequestBody Hashtag
	 * hashtag) { return hashtagService.createHashTag(hashtag); }
	 */
}
