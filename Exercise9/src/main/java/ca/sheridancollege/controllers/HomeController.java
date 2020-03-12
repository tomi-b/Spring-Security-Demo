package ca.sheridancollege.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String root() {
		return "th_index.html";
	}

	@GetMapping("/role/owner")
	public String owner() {
		return "users/owner/th_index.html";
	}
	@GetMapping("/role/employee")
	public String admin() {
		return "users/employee/th_index.html";
	}
	@GetMapping("/role/manager")
	public String manager() {
		return "users/manager/th_index.html";
	}

	@GetMapping("/login")
	public String login() {
		return "th_login.html";
	}

	@GetMapping("/access-denied")
	public String accessDenied() {
		return "error/th_access-denied.html";
	}

}
