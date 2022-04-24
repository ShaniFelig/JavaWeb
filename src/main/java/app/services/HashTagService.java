package app.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.models.Hashtag;
import app.repositories.HashtagRepository;

@Service
public class HashTagService {

	@Autowired
	private HashtagRepository hashTagRepository;

	private final List<Integer> hashtagIds = Arrays.asList(1, 2, 3);

	public List<Hashtag> getAllHashTags() {
		List<Hashtag> hashTags = new ArrayList<>();
		hashTagRepository.findAllById(hashtagIds).forEach(hashTags::add);
		return hashTags;
	}

	public Hashtag createHashTag(Hashtag hashTag) {
		return hashTagRepository.save(hashTag);
	}
}
