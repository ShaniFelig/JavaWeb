package app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.models.User;
import app.services.UserService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class UserController {

	@Autowired // Handles the dependency injection of the service
	private UserService userService;

	@PostMapping("/users/signUp")
	public int signUp(@RequestBody User user) {// spring MVC is smart enough to get JSON formatted 'User'
												// that is
		// expected to be in the body of the request as a 'User' object to
		// pass as a parameter to the function
		return userService.addUser(user).getUserId();
	}

	@PostMapping("/users/login")
	public int login(@RequestBody User user) {

		return userService.validLogin(user).getUserId();
	}

	@GetMapping("/users")
	public List<User> getAllUsers() { // return type will be converted to JSON automatically because the class is
										// annotated with @RestController
		return userService.getAllUsers();
	}

	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable int id) {

		return userService.getUserById(id);
	}

	@GetMapping("/users/getUserIdByUserName")
	public int getUserIdByUserName(@RequestParam(name = "userName") String userName) {

		return userService.getUserIdByUserName(userName);
	}

	@PutMapping("/users")
	public void updateUser(@RequestBody User user) {
		// Need to get userId from DB because we a null check won't help in case of int
		// as default value is 0 and can be misleading because 0 is a valid id
		int userId = userService.getUserIdByUserName(user.getUserName());
		user.setUserId(userId);

		userService.updateUser(user);// update user does not need the id because the repo 'save' method that is used
										// knows which user to update based on the id inside the user object
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}
}
