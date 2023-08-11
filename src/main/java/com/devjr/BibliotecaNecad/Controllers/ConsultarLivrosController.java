package com.devjr.BibliotecaNecad.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devjr.BibliotecaNecad.Entities.Livros;
import com.devjr.BibliotecaNecad.Repositories.LivrosRepository;

@Controller
public class ConsultarLivrosController {

	@Autowired
	private LivrosRepository livrosRepository;
	
	//Método responsável para efetuar as consultas de um livro para a área restrita ADMINISTRADOR
	@GetMapping("/consultar")
	public String listarLivros(Model model, @RequestParam(value = "consulta", required = false) String consulta,
											@RequestParam(value = "tipoConsulta", required = false) String tipoConsulta) {
		
		List<Livros> livros;
		
		if (consulta != null && !consulta.isEmpty() && tipoConsulta !=null && !tipoConsulta.isEmpty()) {
			if (tipoConsulta.equalsIgnoreCase("titulo")) {
			livros = livrosRepository.findByTituloContainingIgnoreCase(consulta);
		} else if (tipoConsulta.equalsIgnoreCase("autor")) {
			livros = livrosRepository.findByAutorContainingIgnoreCase(consulta);
		} else if (tipoConsulta.equalsIgnoreCase("categoria")) {
			livros = livrosRepository.findByCategoriaContainingIgnoreCase(consulta);
		} else {
			livros = livrosRepository.findAll();
		}
		} else {
				livros = livrosRepository.findAll();
			}
		
		model.addAttribute("livros", livros);
		return "ConsultarLivros";
		
		}

			//Método responsável para efetuar a consulta na área restrita logada por um ALUNO.
		@GetMapping("/consultarLivroAlun")
		public String listarLivrosAlunos(Model model, @RequestParam(value = "consulta", required = false) String consulta,
											@RequestParam(value = "tipoConsulta", required = false) String tipoConsulta) {
		
		List<Livros> livros;
		
		if (consulta != null && !consulta.isEmpty() && tipoConsulta !=null && !tipoConsulta.isEmpty()) {
			if (tipoConsulta.equalsIgnoreCase("titulo")) {
			livros = livrosRepository.findByTituloContainingIgnoreCase(consulta);
		} else if (tipoConsulta.equalsIgnoreCase("autor")) {
			livros = livrosRepository.findByAutorContainingIgnoreCase(consulta);
		} else if (tipoConsulta.equalsIgnoreCase("categoria")) {
			livros = livrosRepository.findByCategoriaContainingIgnoreCase(consulta);
		} else {
			livros = livrosRepository.findAll();
		}
		} else {
				livros = livrosRepository.findAll();
			}
		
		model.addAttribute("livros", livros);
		return "ConsultarLivros-aluno";
		
		}
	
	@GetMapping("/Consultar")
	public String consultar(Model model) {
		List<Livros> livros = livrosRepository.findAll();
		model.addAttribute("livros", livros);
		return "ConsultarLivros";
	}

	@GetMapping("/Consultar-Aluno")
	public String consultarAluno(Model model) {
		List<Livros> livros = livrosRepository.findAll();
		model.addAttribute("livros", livros);
		return "ConsultarLivros-aluno";
	}
	
}
