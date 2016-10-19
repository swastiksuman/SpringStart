package com.swastik.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.swastik.dao.Offer;
import com.swastik.dao.User;
import com.swastik.services.UsersService;

@Controller
public class LoginController {

	private UsersService usersService;
	
	@Autowired
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}

	@RequestMapping("/newaccount")
	public String createAccount(Model model) {
		model.addAttribute("user", new User());
		return "newaccount";
	}

	@RequestMapping("/accountcreated")
	public String createAccount() {
		return "accountcreated";
	}

	@RequestMapping(value = "/accountcreated", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Form doesn't validate");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "newaccount";
		} else {
			user.setAuthority("user");
			user.setEnabled(true);
			usersService.create(user);
			System.out.println("Form Validated");
		}
		return "accountcreated";
	}
}
