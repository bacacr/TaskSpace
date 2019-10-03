package com.taskspace;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Administrator
 * Added request to map to new endpoint
 */
@Controller
public class TaskSpaceController {
	
	
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public String read() {
		
		return "start";
	}
	
	@RequestMapping(value = "/start", method = RequestMethod.GET, params = {"loyalty=blue"})
	public String readBlue() {
		
		return "start";
	}
	
	@RequestMapping(value = "/start", method = RequestMethod.GET, params = {"loyalty=silver"})
	public String readSilver() {
		
		return "start";
	}
	
	@RequestMapping(value = "/start", method = RequestMethod.GET, headers = {"content-type=text/json"})
	public String readJSON() {
		
		return "start";
	}
	
	@PostMapping("/start")
	public String create() {
		
		return "start";
	}
	
	/**
	 * @author Administrator
	 * Handles the "/" endpoint
	 */
	@RequestMapping("/")
	public String index() {
			
		return "index";
	}
}
