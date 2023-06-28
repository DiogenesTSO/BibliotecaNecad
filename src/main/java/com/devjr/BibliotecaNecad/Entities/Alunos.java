		package com.devjr.BibliotecaNecad.Entities;

		import jakarta.persistence.Entity;
		import jakarta.persistence.Id;
		import jakarta.persistence.Table;

		@Entity
		@Table(name = "tb_alunos")
		public class Alunos {

			@Id
			private Long matricula;

			private String nome;
			private String email;
			private String cpf;
			private String curso;

			public Long getMatricula() {
				return matricula;
			}
			public String getNome() {
				return nome;
			}
			public String getEmail() {
				return email;
			}
			public String getCpf() {
				return cpf;
			}
			public String getCurso() {
				return curso;
			}
			public void setMatricula(Long matricula) {
				this.matricula = matricula;
			}
			public void setNome(String nome) {
				this.nome = nome;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			public void setCpf(String cpf) {
				this.cpf = cpf;
			}
			public void setCurso(String curso) {
				this.curso = curso;
			}
		}
