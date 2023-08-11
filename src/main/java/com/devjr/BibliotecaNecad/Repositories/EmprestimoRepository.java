package com.devjr.BibliotecaNecad.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devjr.BibliotecaNecad.Entities.Emprestar;

public interface EmprestimoRepository extends JpaRepository<Emprestar, Long> {

    List<Emprestar> findByMatriculaContainingIgnoreCase(String matricula);

}
