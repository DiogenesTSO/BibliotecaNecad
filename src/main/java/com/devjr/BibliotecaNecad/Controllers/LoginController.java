package com.devjr.BibliotecaNecad.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devjr.BibliotecaNecad.Entities.Usuario;
import com.devjr.BibliotecaNecad.Repositories.UsuarioRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String showLoginForm() {
        return "Login";
    }

    @PostMapping("/login")
    public String processLogin (@RequestParam String username, @RequestParam String password, HttpSession session, Model model ) {

        Usuario usuario = usuarioRepository.findByUsername(username);

        if (usuario != null && usuario.getPassword().equals(password)) {
            if (usuario.getPapel().contains("ALUNO")){
                session.setAttribute("usuario", usuario);
                return "Principal-aluno";
            } else if (usuario.getPapel().contains("ADMIN")){
                session.setAttribute("usuario", usuario);
                return "Principal";
            }
        }

        model.addAttribute("mensagem", "Usuário ou senha inválidos!");
        return "Login";
            
    }

    @PostMapping("/cadastrar")
    public String cadastrarUsuario(@RequestParam("username") String username,
                                   @RequestParam("password") String password,
                                   @RequestParam("papel") String papel){

                                    Usuario novoUsuario = new Usuario(username, password);

                                    novoUsuario.setPapel("ALUNO");

                                    usuarioRepository.save(novoUsuario);

                                    return "redirect:/login";
                                   }

    
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }


}
