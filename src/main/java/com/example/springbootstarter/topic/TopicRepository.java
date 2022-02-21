package com.example.springbootstarter.topic;

import org.springframework.data.repository.CrudRepository;

//Controller class java VS database
public interface TopicRepository extends CrudRepository<Topic, String> /*spring data jpa interface for basic CRUD operations. <Entity class, primary key type>*/ {

	
	//No connection information necessary because we are working with embedded Apache database
}
