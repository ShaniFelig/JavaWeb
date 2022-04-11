package app.repositories;

import org.springframework.data.repository.CrudRepository;

import app.models.User;

//Controller class java VS database
public interface UserRepository extends CrudRepository<User, Integer> /*
																		 * spring data jpa interface for basic CRUD
																		 * operations. <Entity class, primary key type>
																		 */ {

	// No connection information necessary because we are working with embedded
	// Apache database
}
