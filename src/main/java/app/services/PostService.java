package app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.models.FilterCriteria;
import app.models.Post;
import app.repositories.PostRepository;

@Service // Singleton Service. Spring will detect in the class path all the classes that
			// have the @Service annotation, create an instance of them and register them.
			// A class that want to use this service should create a private member of this
			// type with the @Autowired annotation. Upon app startup spring will inject the
			// dependency
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public List<Post> getAllPosts() {
		List<Post> posts = new ArrayList<>();
		postRepository.findAll().forEach(posts::add);
		return posts;
	}

	public List<Post> filterPosts(FilterCriteria filters) {
		List<Post> result = new ArrayList<>();
		List<Post> posts = getAllPosts();
		List<Integer> filterUserIds = filters.getUserIds();

		Post currentPost;
		for (int i = 0; i < posts.size(); i++) {
			currentPost = posts.get(i);

			if (currentPost.getDate().before(filters.getEndDate())
					&& currentPost.getDate().after(filters.getStartDate())
					&& filterUserIds.contains(currentPost.getUserId())) {
				result.add(currentPost);
			}
		}
		return result;
	}

	public Post getPostById(int id) {
		return postRepository.findById(id).get();
	}

	public Post addOrUpdate(Post post) {
		return postRepository.save(post);
	}
}
