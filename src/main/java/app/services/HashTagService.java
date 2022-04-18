package app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.models.HashTag;
import app.repositories.HashTagRepository;

@Service
public class HashTagService {

	@Autowired
	private HashTagRepository hashTagRepository;

	public List<HashTag> getAllHashTags() {
		List<HashTag> hashTags = new ArrayList<>();
		hashTagRepository.findAll().forEach(hashTags::add);
		return hashTags;
	}

	public HashTag createHashTag(HashTag hashTag) {
		return hashTagRepository.save(hashTag);
	}
}
