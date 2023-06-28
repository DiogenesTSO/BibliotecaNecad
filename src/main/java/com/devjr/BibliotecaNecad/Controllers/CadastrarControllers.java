package com.devjr.BibliotecaNecad.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.devjr.BibliotecaNecad.Entities.Livros;
import com.devjr.BibliotecaNecad.Repositories.LivrosRepository;

@Controller
public class CadastrarControllers {
	
	@Autowired
	private LivrosRepository livrosRepository;
	
	@GetMapping("/CadastrarLivros")
	public String cadastroLivro(Model model) {
		Livros livros = new Livros();
		model.addAttribute("livros", livros);
		return "CadastrarLivros";
	}
	
	@PostMapping("/livros")
	public String cadastrarlivros(Livros livros) {
		livrosRepository.save(livros);
		return "redirect:/CadastrarLivros";
	} 
		
	
		}
		
	