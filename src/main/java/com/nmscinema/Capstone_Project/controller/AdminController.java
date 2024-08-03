package com.nmscinema.Capstone_Project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//@RestController
@Controller
@RequestMapping("/admin")
public class AdminController {

	@PostMapping("/add")
	public String addMovie(@RequestParam String name, @RequestParam String genre, @RequestParam String release,
			@RequestParam String time) {

		// String url = "http://localhost:9091/app/checkAdmin?username=" + username +
		// "&password=" + password;
		// String url2 = "http://localhost:9091/app/checkUser?username=" + username +
		// "&password=" + password;

		String url = "http://localhost:9092/movie/add?name=" + name + "&genre=" + genre + "&release=" + release
				+ "&time=" + time + "";

		boolean checkMovieAdd = new RestTemplate().getForObject(url, Boolean.class);

		if (checkMovieAdd) {
			return "redirect:/admin.html";
		} else {
			return "redirect:/error.html";
		}

	}
	
	@PostMapping("/delete")
	public String deleteMovie(@RequestParam Integer mid) {
		String url = "http://localhost:9092/movie/delete?mid="+mid+"";
		
		boolean checkDeletion = new RestTemplate().getForObject(url, Boolean.class);
		
		if (checkDeletion) {
			return "redirect:/admin.html";
		} else {
			return "redirect:/error.html";
		}
		
	}
	
	@PostMapping("/update")
	public String updateMovie(@RequestParam Integer mid, @RequestParam String name, @RequestParam String genre, @RequestParam String release,
			@RequestParam String time) {
		
		String url = "http://localhost:9092/movie/update?name=" + name + "&genre=" + genre + "&release=" + release
				+ "&time=" + time + "&mid="+mid+"";

		boolean checkMovieUpdate = new RestTemplate().getForObject(url, Boolean.class);

		if (checkMovieUpdate) {
			return "redirect:/admin.html";
		} else {
			return "redirect:/error.html";
		}

	}

}
