package app.repositories;

import org.springframework.data.repository.CrudRepository;

import app.models.Like;

public interface LikeRepository extends CrudRepository<Like, Integer> {

	public Like findByUserIdAndPostId(int userId, int postId);

}
