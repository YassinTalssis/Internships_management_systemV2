package com.example.demo.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/home")
	public String home(Model model) {
		
		model.addAttribute("title", "Home page ");
		return "index";
	}
	@RequestMapping("/admin/etablissement")
	public String user_home(Model model) {
		
		model.addAttribute("title", "Home page ");
		return "/admin/etablissement";
	}
	@GetMapping("/responsible/profile")
	public String respo_profile(Model model) {
		
		model.addAttribute("title", "Home page ");
		return "/responsible/profile";
	}
			
}

