package com.devjr.BibliotecaNecad.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.devjr.BibliotecaNecad.Entities.Alunos;
import com.devjr.BibliotecaNecad.Repositories.AlunosRepository;

@Controller
public class AlunoController {
	
	@Autowired
	private AlunosRepository alunosRepository;
	
	@GetMapping("/CadastrarAlunos")
	public String cadastroAluno(Model model) {
		Alunos alunos = new Alunos();
		model.addAttribute("alunos", alunos);
		return "CadastrarAlunos";
	}
	
	@PostMapping("/alunos") 
		public String cadastrarAlunos(Alunos alunos) {
			alunosRepository.save(alunos);
			return "redirect:/CadastrarAlunos";
		}
}
