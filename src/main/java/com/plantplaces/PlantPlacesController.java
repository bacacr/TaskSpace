package com.plantplaces;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 * Added request to map to new endpoint
 */
@Controller
public class PlantPlacesController {
	
	
	@RequestMapping("/start")
	public String start() {
		
		return "start";
	}
		
	@RequestMapping("/")
	public String index() {
			
		return "index";
	}
}
