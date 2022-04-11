package app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.models.Like;
import app.models.LikeRequest;
import app.services.LikeService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class LikeController {

	@Autowired // Handles the dependency injection of the service
	private LikeService likeService;

	// uses the postId field directly to create a new like
	@PostMapping("/likes")
	public Like addLike(@RequestBody Like like) {
		return likeService.addLike(like);
	}

	// uses LikeRequest which then gets the Post from the DB and creates a new Like
	// object
	@PostMapping("/newLike")
	public Like newLike(@RequestBody LikeRequest likeRequest) {
		return likeService.newLike(likeRequest);
	}

	@GetMapping("/likes")
	public List<Like> getAllLikes() {
		return likeService.getAllLikes();
	}

	@DeleteMapping("/likes/{userId}")
	public void deleteUserLikes(@PathVariable int userId) {
		likeService.deleteUserLikes(userId);
	}
}
