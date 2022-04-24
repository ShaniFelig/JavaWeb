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

	public List<Comment> getCommentsByPostId(int postId) {
		return commentRepository.findByPostId(postId);

	}

	public Comment postComment(Comment comment) {
		return commentRepository.save(comment);
	}
}
