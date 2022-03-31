package com.codeplanet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/xyz")
	public String xyz() {
      System.out.println("Hello this is my first request in spring mvc");
      return "home";
	}

}
