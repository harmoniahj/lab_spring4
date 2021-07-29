package com.example.demo;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	Logger logger = LogManager.getLogger(HelloController.class);
	@GetMapping("/hello")
	public String hello(Model model, @RequestParam(value="name", required=false) String name) {
		logger.info("hello 호출 성공");
		model.addAttribute("greeting", "안녕하세요. "+name);
		return "hello";
	}
	
}
