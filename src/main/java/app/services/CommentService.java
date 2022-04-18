package app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.models.Comment;
import app.repositories.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;

	public List<Comment> getAllComments() {
		List<Comment> comments = new ArrayList<>();
		commentRepository.findAll().forEach(comments::add);
		return comments;
	}

	public List<Comment> getAllCommentsByPostId(int postId) {
		List<Comment> comments = getAllComments();
		return comments.stream().filter(c -> c.getPostId() == postId).toList();

	}

	public Comment postComment(Comment comment) {
		return commentRepository.save(comment);
	}
}
