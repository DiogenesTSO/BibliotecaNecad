package com.devjr.BibliotecaNecad.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devjr.BibliotecaNecad.Entities.Livros;
import com.devjr.BibliotecaNecad.Repositories.LivrosRepository;

@RestController
@RequestMapping("/deletar")
public class DeletarLivrosController {

    @Autowired
    private LivrosRepository livrosRepository;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarLivro(@PathVariable Long id){
        Optional<Livros> livroOptional = livrosRepository.findById(id);

        if (livroOptional.isPresent()) {
            Livros livros = livroOptional.get();
            livrosRepository.delete(livros);
            return ResponseEntity.ok("Livro deletado com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
