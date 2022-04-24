package app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.models.FilterCriteria;
import app.models.Post;
import app.services.PostService;
import app.services.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PostController {

	@Autowired
	private PostService postService;

	@Autowired
	private UserService userService;

	@GetMapping("/posts")
	public List<Post> getAllPosts() {
		return postService.getAllPosts();
	}

	@GetMapping("/posts/{postId}")
	public Post getPostById(@PathVariable int postId) {
		return postService.getPostById(postId);
	}

	@PostMapping("/posts")
	public Post createPost(@RequestBody Post post) {
		String userName = userService.getUserById(post.getUserId()).getUserName();
		post.setUserName(userName);
		return postService.addOrUpdate(post);
	}

	@PostMapping("/posts/filter")
	public List<Post> getFilteredPosts(@RequestBody FilterCriteria filters) {
		return postService.filterPosts(filters);
	}
}
