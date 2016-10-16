package com.swastik.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.swastik.dao.User;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("/newaccount")
	public String createAccount(Model model){
		model.addAttribute("user", new User());
		return "newaccount";
	}
	
	@RequestMapping("/accountcreated")
	public String createAccount(){
		return "accountcreated";
	}
}
