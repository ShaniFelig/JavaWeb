package app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.models.Post;

//Controller class java VS database
@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

}
