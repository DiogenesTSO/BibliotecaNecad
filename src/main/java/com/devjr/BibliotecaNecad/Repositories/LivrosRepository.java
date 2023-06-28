package com.devjr.BibliotecaNecad.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import com.devjr.BibliotecaNecad.Entities.Livros;

public interface LivrosRepository extends JpaRepository<Livros, Long>{
	
	List<Livros> findByTituloContainingIgnoreCase(@Param("titulo") String titulo);
	List<Livros> findByAutorContainingIgnoreCase(String autor);
	List<Livros> findByCategoriaContainingIgnoreCase(String categoria);

}
