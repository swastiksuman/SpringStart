package com.swastik.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.swastik.dao.Offer;
import com.swastik.services.OffersService;

@Controller
public class OffersController {
	
	
	private OffersService offersService;
	/*@RequestMapping("/")
	public ModelAndView showHome(HttpSession session){
		session.setAttribute("name", "boris");
		ModelAndView mv = new ModelAndView();
		Map<String, Object> model = mv.getModel();
		model.put("name", "Souj");
		return mv;
	}*/
	
	
	
	@RequestMapping("/")
	public String showHome(Model model){
		List<Offer> offers = offersService.getCurrent();
		model.addAttribute("offers", offers);
		return "home";
	}


	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}
}
	
