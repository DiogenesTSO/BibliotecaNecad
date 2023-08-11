package com.devjr.BibliotecaNecad.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devjr.BibliotecaNecad.Entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    Usuario findByUsername(String username);
}
