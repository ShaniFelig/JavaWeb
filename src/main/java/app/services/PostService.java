package app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.models.FilterCriteria;
import app.models.Hashtag;
import app.models.Post;
import app.repositories.HashtagRepository;
import app.repositories.PostRepository;

@Service // Singleton Service. Spring will detect in the class path all the classes that
			// have the @Service annotation, create an instance of them and register them.
			// A class that want to use this service should create a private member of this
			// type with the @Autowired annotation. Upon app startup spring will inject the
			// dependency
public class PostService {

	@Autowired
	private PostRepository postRepository;
	@Autowired
	private HashtagRepository hashtagRepository;

	public List<Post> getAllPosts() {
		List<Post> posts = new ArrayList<>();
		postRepository.findAll().forEach(posts::add);
		return posts;
	}

	public List<Post> filterPosts(FilterCriteria filters) {
		List<Post> result = new ArrayList<>();
		List<Post> posts = getAllPosts();
		List<String> filterHashtagsStrings = filters.getHashtags();

		for (Post currentPost : posts) {

			if ((filters.getEndingDate() == null
					|| (filters.getEndingDate() != null && currentPost.getDate().before(filters.getEndingDate())))
					&& (filters.getStartingDate() == null || filters.getStartingDate() != null
							&& currentPost.getDate().after(filters.getStartingDate()))
					&& (filterHashtagsStrings == null || this.containsHashtag(currentPost, filterHashtagsStrings))
					&& (filters.getPublishers() == null || filters.getPublishers().contains(currentPost.getUserName()))) {

				result.add(currentPost);
			}
		}
		return result;

	}

	public boolean containsHashtag(Post post, List<String> filterHashtagsStrings) {

		List<Hashtag> filtertags = hashtagRepository.findByContentIn(filterHashtagsStrings);
		Set<Hashtag> postTags = post.getTags();
		for (Hashtag filterTag : filtertags) {
			if (postTags.contains(filterTag)) {
				return true;
			}
		}
		return false;
	}

	public Post getPostById(int id) {
		return postRepository.findById(id).get();
	}

	public Post addOrUpdate(Post post) {

		// post exists -> update
		if (post.getPostId() != 0) { // post exists
			Post currentPost = postRepository.findById(post.getPostId()).get();
			currentPost.setDescription(post.getDescription());
			currentPost.setImageSorce(post.getImageSorce());
			currentPost.setTags(post.getTags());
			return postRepository.save(currentPost);
		}
		return postRepository.save(post);
	}
}
