package com.devjr.BibliotecaNecad.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControllers {

	@GetMapping("/")
	public String home() {
		return "Principal";
	}
	
		
	@GetMapping("/voltar")
	public String voltarInicio() {
		return "Principal";
	}
	
}
