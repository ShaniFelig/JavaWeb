package app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.models.HashTag;

//Controller class java VS database
@Repository
public interface HashTagRepository extends CrudRepository<HashTag, Integer> {

}
