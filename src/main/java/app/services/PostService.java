package app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public Post getPostById(int id) {
		return postRepository.findById(id).get();
	}

	/*
	 * public int getUserIdByUserName(String userName) { List<User> users = new
	 * ArrayList<>(); postRepository.findAll().forEach(users::add);
	 * 
	 * for (User user : users) { if (user.getUserName().equals(userName)) { return
	 * user.getUserId(); } }
	 * 
	 * return -1; // Should throw exception? }
	 * 
	 * public User addUser(User user) { return postRepository.save(user); }
	 * 
	 * public void updateUser(User user) { postRepository.save(user); }
	 * 
	 * public void deleteUser(int id) { postRepository.deleteById(id); }
	 */
}
