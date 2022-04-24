package app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.models.Like;
import app.models.LikeRequest;
import app.models.Post;
import app.models.User;
import app.repositories.LikeRepository;
import app.repositories.PostRepository;
import app.repositories.UserRepository;

@Service
public class LikeService {

	@Autowired
	private LikeRepository likeRepository;
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private UserRepository userRepository;

	public Like addOrUpdateLike(Like like) {

		// like exists -> update
		Like currentLike = likeRepository.findByUserIdAndPostId(like.getUserId(), like.getPostId());
		if (currentLike != null) {
			currentLike.setActive(like.getIsActive());
			if (currentLike.getIsActive() == false) {
				likeRepository.delete(currentLike);
				return null;
			} else {
				return likeRepository.save(currentLike);
			}
		}

		else {
			return likeRepository.save(like);
		}
	}

	public List<Like> getAllLikes() {
		List<Like> likes = new ArrayList<>();
		likeRepository.findAll().forEach(likes::add);
		return likes;
	}

	public List<Like> getLikesbyPostId(int postId) {
		List<Like> allLikes = getAllLikes();
		return allLikes.stream().filter(l -> l.getPostId() == postId).toList();
	}

	public Like newLike(LikeRequest likeRequest) {
		Post post = postRepository.findById(likeRequest.getPostId()).get();
		User user = userRepository.findById(likeRequest.getUserId()).get();

		Like newLike = new Like(likeRequest.getIsActive(), post, user);

		return likeRepository.save(newLike);
	}

	public void deleteUserLikes(int userId) {
		List<Like> allLikes = getAllLikes();
		List<Like> userLikes = allLikes.stream().filter(l -> l.getUserId() == userId).toList();
		likeRepository.deleteAll(userLikes);
	}

}
