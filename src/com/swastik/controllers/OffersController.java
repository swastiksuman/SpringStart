package com.swastik.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.swastik.dao.Offer;
import com.swastik.services.OffersService;

@Controller
public class OffersController {
	
	
	private OffersService offersService;
	
	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}

	@RequestMapping("/offers")
	public String showOffers(Model model) {
		
		offersService.throwTestException();
		List<Offer> offers = offersService.getCurrent();
		
		model.addAttribute("offers", offers);
		
		return "offers";
	}
	
	@RequestMapping("/createoffer")
	public String createOffer(Model model) {
		
		model.addAttribute("offer", new Offer());
		return "createoffer";
	}
	
/*	@ExceptionHandler(DataAccessException.class)
	public String handleDBException(DataAccessException exception){
		return "error";
		
	}
*/	
	@RequestMapping(value="/docreate", method=RequestMethod.POST)
	public String doCreate(Model model, @Valid Offer offer, BindingResult result) {
		if(result.hasErrors()){
			System.out.println("Form doesn't validate");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error: errors){
				System.out.println(error.getDefaultMessage());
			}
			return "createoffer";
		}else{
			offersService.create(offer);
			System.out.println("Form Validated");
		}
		return "offercreated";
	}
	
}
