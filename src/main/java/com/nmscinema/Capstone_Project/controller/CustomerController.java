package com.nmscinema.Capstone_Project.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import com.nmscinema.Capstone_Project.model.Movie;

@Controller
public class CustomerController {
	@GetMapping("/view-movies")
	public String getAllMovies(Model model) {
		String url = "http://localhost:9092/movie/sendAllMovies";
		@SuppressWarnings("unchecked")
		List<Movie> list = new RestTemplate().getForObject(url, List.class);
		model.addAttribute("movies", list);
		return "view-movies";
	}

	@GetMapping("/buy-ticket")
	public String buyTicket(Model model) {
		String url = "http://localhost:9092/movie/sendAllMovies";
		@SuppressWarnings("unchecked")
		List<Movie> list = new RestTemplate().getForObject(url, List.class);
		model.addAttribute("movies", list);
		return "buy-ticket";
	}

	@PostMapping("/save-purchases")
	public RedirectView savePurchase(@RequestParam String customerName, @RequestParam String movieName,
			@RequestParam Integer ticketNumber, @RequestParam String customerEmail) {

		String url = "http://localhost:9092/purchase/save?customerName=" + customerName + "&movieName=" + movieName
				+ "&ticketNumber=" + ticketNumber + "&customerEmail=" + customerEmail + "";

		boolean check = new RestTemplate().getForObject(url, Boolean.class);

		if (check) {
			return new RedirectView("/welcome.html");
		} else {
			return new RedirectView("/error.html");
		}
	}
}
