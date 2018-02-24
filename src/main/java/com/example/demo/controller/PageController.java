package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {
	@RequestMapping("/hello")
	public String hello () {
		return "hello";
	}
	
	@RequestMapping("/greeting")
	public String greeting (@RequestParam(value = "name", required = false, defaultValue = "dunia") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
	 
	@RequestMapping(value = {"/greeting", "greeting/{name}"})
	public String greetingPath (@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "apap");
		}
		return "greeting";
	}

	@RequestMapping("/perkalian")
	public String perkalian (@RequestParam(value ="a", required = false, defaultValue = "0")Integer a,
							@RequestParam(value ="b", required = false, defaultValue = "0")Integer b, Model model){
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute(a*b);
		return "perkalian";
	}
}
	

