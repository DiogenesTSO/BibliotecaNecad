package com.devjr.BibliotecaNecad.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devjr.BibliotecaNecad.Entities.Alunos;
import com.devjr.BibliotecaNecad.Repositories.AlunosRepository;

@RestController
@RequestMapping("/alunos")
public class ConsultarAlunosController {

		@Autowired
		private AlunosRepository alunosRepository;
		
		@GetMapping("/{matricula}")
		public ResponseEntity<String> buscarAlunoPorMatricula(@PathVariable("matricula") String matricula){
			Alunos alunos = alunosRepository.findByMatricula(matricula);
			
			if (alunos == null) {
				return ResponseEntity.notFound().build();
			} else {
				return ResponseEntity.ok(alunos.getNome());
			}
		}
}
