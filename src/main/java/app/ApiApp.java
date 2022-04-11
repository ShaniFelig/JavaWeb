package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApp {

	public static void main(String[] args) {
		//Tells spring boot to start the app, create a servlet container, host the app in the servlet container and make it available
		SpringApplication.run(ApiApp.class, args);
	}

}
