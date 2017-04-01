package com.ram.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class MainController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homepage() {

		return "index";

	}

}
