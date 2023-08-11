package com.devjr.BibliotecaNecad.Controllers;



import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devjr.BibliotecaNecad.Entities.Alunos;
import com.devjr.BibliotecaNecad.Entities.Emprestar;
import com.devjr.BibliotecaNecad.Entities.Livros;
import com.devjr.BibliotecaNecad.Repositories.AlunosRepository;
import com.devjr.BibliotecaNecad.Repositories.EmprestimoRepository;
import com.devjr.BibliotecaNecad.Repositories.LivrosRepository;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
	
	@Autowired
	private EmprestimoRepository emprestimoRepository;
	@Autowired
	private LivrosRepository livrosRepository;
	@Autowired
	private AlunosRepository alunosRepository;
	
	@PostMapping
	public ResponseEntity<String> registrarEmprestimo(@RequestBody Emprestar emprestar ){
		
		Alunos alunos = alunosRepository.findByMatricula(emprestar.getMatricula());
		
		if (alunos != null) {
			emprestar.setNome(alunos.getNome());
			emprestar.setEmail(alunos.getEmail());
			emprestar.setCurso(alunos.getCurso());
			emprestar.setDataEmprestimo(new Date());
			
			List<String> titulosLivros = emprestar.getLivros();
			List<Livros> livrosList = livrosRepository.findByTituloIn(titulosLivros);

			if(livrosList.size() != titulosLivros.size()){
				return ResponseEntity.badRequest().body("Livro não encontrado");
			}

			for (Livros livro : livrosList){
				if (livro.getExemplares() > 0){
						emprestimoRepository.save(emprestar);

						livro.setExemplares(livro.getExemplares() - 1);
						livrosRepository.save(livro);
					} else {
						return ResponseEntity.badRequest().body("Livro indisponível: " +livro.getTitulo());
					}
				}
				
						return ResponseEntity.ok("Empréstimo realizado com sucesso!");
			} else {
				return ResponseEntity.badRequest().body("Aluno não encontrado.");
			}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> devolverLivro(@PathVariable Long id){
		Optional<Emprestar> emprestimoOptional = emprestimoRepository.findById(id);

		if (emprestimoOptional.isPresent()){
			Emprestar emprestimo = emprestimoOptional.get();
			List<String> titulosLivros = emprestimo.getLivros();

			List<Livros> livrosEmprestado = livrosRepository.findByTituloIn(titulosLivros);

			for (Livros livro : livrosEmprestado){
				livro.setExemplares(livro.getExemplares() + 1);
			}
				livrosRepository.saveAll(livrosEmprestado);
				emprestimoRepository.deleteById(id);
		
			return ResponseEntity.ok("Livro devolvido com sucesso!");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	/*
			@GetMapping("/consultarMatricula")
		public String consultarPorMatricula(Model model, @RequestParam(value = "matriculaAluno", required = false) String matriculaAluno,
													 	 @RequestParam(value = "filtro", required = false) String filtro){
			
			List<Emprestar> emprestar;
			if (matriculaAluno != null && !matriculaAluno.isEmpty() && filtro !=null && !filtro.isEmpty()){
				if (filtro.equalsIgnoreCase("matricula")){
					emprestar = emprestimoRepository.findByMatriculaContainingIgnoreCase(matriculaAluno);
				} else {
					emprestar = emprestimoRepository.findAll();
				}
			} else {
				emprestar = emprestimoRepository.findAll();
			}
			model.addAttribute("emprestar", emprestar);
				return "";
		}

	*/

}




