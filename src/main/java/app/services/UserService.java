package app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.models.User;
import app.repositories.UserRepository;

@Service // Singleton Service. Spring will detect in the class path all the classes that
			// have the @Service annotation, create an instance of them and register them.
			// A class that want to use this service should create a private member of this
			// type with the @Autowired annotation. Upon app startup spring will inject the
			// dependency
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	public User getUserById(int id) {
		return userRepository.findById(id).get();
	}

	public int getUserIdByUserName(String userName) {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);

		for (User user : users) {
			if (user.getUserName().equals(userName)) {
				return user.getUserId();
			}
		}

		return -1; // Should throw exception?
	}

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public void updateUser(User user) {
		userRepository.save(user);
	}

	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}

	public User validLogin(User user) {

		String name = user.getUserName();
		String pass = user.getPassword();

		int userId = getUserIdByUserName(name);
		User dbUser = userRepository.findById(userId).get();
		if (dbUser.getUserName().equals(name) && dbUser.getPassword().equals(pass)) {
			return dbUser;
		}
		return null;

	}

}
