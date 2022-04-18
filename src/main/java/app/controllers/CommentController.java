package app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.models.Comment;
import app.services.CommentService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class CommentController {

	@Autowired // Handles the dependency injection of the service
	private CommentService commentService;

	@GetMapping("/comments")
	public List<Comment> getAllComments() {
		return commentService.getAllComments();
	}

	@GetMapping("/comments/{postId}")
	public List<Comment> getAllCommentsByPostId(@PathVariable int postId) {
		return commentService.getAllCommentsByPostId(postId);
	}

	@PostMapping("/comments")
	public Comment postComment(@RequestBody Comment comment) {
		return commentService.postComment(comment);
	}
}
