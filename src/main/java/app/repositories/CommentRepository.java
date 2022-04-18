package app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.models.Comment;

//Controller class java VS database
@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {

}
