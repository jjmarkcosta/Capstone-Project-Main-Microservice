package com.nmscinema.Capstone_Project.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/app")
public class LoginController {

	@PostMapping("/validate")
	public RedirectView checkLogin(@RequestParam String username, @RequestParam String password) {

		String url = "http://localhost:9091/app/checkAdmin?username=" + username + "&password=" + password;
		String url2 = "http://localhost:9091/app/checkUser?username=" + username + "&password=" + password;

		boolean checkAdmin = new RestTemplate().getForObject(url, Boolean.class);
		boolean checkGeneral = new RestTemplate().getForObject(url2, Boolean.class);

		if (checkAdmin) {
			return new RedirectView("/admin.html");
		} else if(checkGeneral){
			return new RedirectView("/welcome.html");
		}else {
			return new RedirectView("/error.html");
		}

	}
	
	@PostMapping("/create")
	public RedirectView createUser(@RequestParam String username, @RequestParam String password) {
		
		String url = "http://localhost:9091/app/createUser?username=" + username + "&password=" + password;
		
		boolean check = new RestTemplate().getForObject(url, Boolean.class);
		
		if (check) {
			return new RedirectView("/index.html");
		} else {
			return new RedirectView("/error.html");
		}
		
	}

}
