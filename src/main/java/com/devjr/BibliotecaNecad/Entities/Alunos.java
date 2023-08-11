		package com.devjr.BibliotecaNecad.Entities;

		import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
		import jakarta.persistence.Table;

		@Entity
		@Table(name = "tb_alunos")
		public class Alunos {

			@Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private Long id;
			
			private String matricula;
			private String nome;
			private String email;
			private String cpf;
			private String curso;
			
			
			public Long getId() {
				return id;
			}
			public void setId(Long id) {
				this.id = id;
			}
			public String getMatricula() {
				return matricula;
			}
			public void setMatricula(String matricula) {
				this.matricula = matricula;
			}
			public String getNome() {
				return nome;
			}
			public void setNome(String nome) {
				this.nome = nome;
			}
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			public String getCpf() {
				return cpf;
			}
			public void setCpf(String cpf) {
				this.cpf = cpf;
			}
			public String getCurso() {
				return curso;
			}
			public void setCurso(String curso) {
				this.curso = curso;
			}

			
		}
