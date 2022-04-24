package app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.models.Hashtag;

//Controller class java VS database
@Repository
public interface HashtagRepository extends CrudRepository<Hashtag, Integer> {

	List<Hashtag> findByContentIn(List<String> contentValues); // hibernate convention for finding all rows whose
																// 'content' field value is contained in the given list
}
