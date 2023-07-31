package com.epicode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.epicode.model.Contatto;
import com.epicode.services.ContattoService;

@Controller
public class WebPageController {
	
	@Autowired ContattoService cs;
	
	@GetMapping("/home")
	public String getHomepage() {
		return "homepage";
	}
	
	@GetMapping("/about")
	public String getAbout() {
		return "about";
	}
	
	@GetMapping("/rubrica")
	public String getRubrica() {
		return "rubrica";
	}
	
	@GetMapping("/rubricadettaglio/{id}")
	public ModelAndView getRubricaById(@PathVariable Long id) {
		Contatto contatto = cs.findById(id);
		ModelAndView model = new ModelAndView("rubricadettaglio");
		model.addObject("nome", contatto.getNome());
		model.addObject("cognome", contatto.getCognome());
		model.addObject("numero", contatto.getNumeroTelefono());
		return model;
	}

}
