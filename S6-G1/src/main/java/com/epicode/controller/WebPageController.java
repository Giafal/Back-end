package com.epicode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebPageController {
	
	@GetMapping("/home")
	public String getHomepage() {
		return "homepage";
	}
	
	@GetMapping("/about")
	public String getAbout() {
		return "about";
	}
	
	@GetMapping("/rubrica")
	public String getRubrica() {
		return "rubrica";
	}

}
