package app.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class GeneralController {

	/*
	 * @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}") public
	 * void deleteUser(@PathVariable int id) { userService.deleteUser(id); }
	 */

	/*
	 * 
	 * addComment - sending content, userId, postId, user?. Generate postId in
	 * table. Return comment object GetAllHashTags - Return array of existing
	 * HashTags. If no HashTags return empty array. createLike - sending
	 * userId,postId, isActive becomes true. Returns like object createPost - sends
	 * and returns post object getPosts - returns array of Posts (all posts in the
	 * website) getPostById - id in url. Returns the post updatePostById - uses a
	 * put request. id is sent in url. Returns the updated post manageLike - updates
	 * the isActive of the like. Sends userId and postId. Returns the updated like
	 * filterPost - sends an array of Posts that match the filter requirements
	 * 
	 * 
	 * Manuallly add HashTags to database.
	 */
}
