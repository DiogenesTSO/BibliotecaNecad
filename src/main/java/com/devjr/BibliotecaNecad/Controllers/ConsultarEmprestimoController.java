package com.devjr.BibliotecaNecad.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.devjr.BibliotecaNecad.Entities.Emprestar;
import com.devjr.BibliotecaNecad.Repositories.EmprestimoRepository;

@Controller
public class ConsultarEmprestimoController {
	
	@Autowired
	private EmprestimoRepository emprestimoRepository;
	
	@GetMapping("/Emprestar")
	public String consultarEmprestimo(Model model) {
		List<Emprestar> emprestimo = emprestimoRepository.findAll();
		model.addAttribute("emprestar", emprestimo);
		return "ConsultarEmprestimos";
	}

}
