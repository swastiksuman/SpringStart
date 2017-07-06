package com.swastik.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		
		List<Offer> offers = offersService.getCurrent();
		
		model.addAttribute("offers", offers);
		
		return "offers";
	}
	
	@RequestMapping("/createoffer")
	public String createOffer(Model model) {
		
		model.addAttribute("offer", new Offer());
		return "createoffer";
	}
	
	
	@RequestMapping(value="createajax", method=RequestMethod.GET)
	public @ResponseBody String createOfferAjax(@RequestParam("email")String email) {
		
		return email;
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
	
	@RequestMapping("/searchoffer")
	public String searchOffer(Model model){
		model.addAttribute("offer", new Offer());
		return "searchpage";
	}
	
	@RequestMapping(value="/searchpage", method=RequestMethod.POST)
	public String searchResult(@RequestParam("name")String name, Model model){
		Offer offerResult = offersService.getOffer(name);
		if(offerResult!=null){
			model.addAttribute("offerResult", offerResult);
			return "searchresult";
		}else{
			System.out.println("ERRR");
			return "error";
		}		
	}
}
