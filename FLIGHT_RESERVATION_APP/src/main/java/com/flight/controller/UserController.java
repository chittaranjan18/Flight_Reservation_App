package com.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight.entities.User;
import com.flight.repositories.UserRepository;

@Controller
public class UserController {
    
	@Autowired
	private UserRepository userRepo;
	@RequestMapping("/log")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/reg")
	public String Registration() {
		return "Registration";
	}
	
	@RequestMapping("/regSave")
	public String save(User user) {
		userRepo.save(user);
		return "login";
	}
	@RequestMapping("/verifyLogin")
	public String verifyLogin(@RequestParam("emailId") String emailId,@RequestParam("password")String password,ModelMap modelMap) {
		User user = userRepo.findByEmail(emailId);
		if(user!=null) {
			if(user.getEmail().equals(emailId)&&user.getPassword().equals(password)) {
				return "findFlights";
			}
			else {
				modelMap.addAttribute("error","Invalid user or password");
				return "login";
			}
		}else {
			modelMap.addAttribute("error","Invalid user or password");
			return "login";
		}
		
	}
}
