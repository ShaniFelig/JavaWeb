package com.example.springbootstarter.topic;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired //Handles the dependency injection of the service
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() { //return type will be converted to JSON automatically becaue the class in annotated with @RestController
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topic topic) {//spring MVC is smart enough to get JSON formatted 'Topic' that is expected to be in the body of the request as a 'Topic' object to pass as a parameter to the function
		topicService.addTopic(topic);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics")
	public void updateTopic(@RequestBody Topic topic) {//spring MVC is smart enough to get JSON formatted 'Topic' that is expected to be in the body of the request as a 'Topic' object to pass as a parameter to the function
		topicService.updateTopic(topic);//update topic does not need the id because the repo 'save' method that is used knows which topic to update based on the id inside the topic object
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		 topicService.deleteTopic(id);
	}
}
