			package com.devjr.BibliotecaNecad.Entities;

			import jakarta.persistence.Column;
			import jakarta.persistence.Entity;
			import jakarta.persistence.GeneratedValue;
			import jakarta.persistence.GenerationType;
			import jakarta.persistence.Id;
			import jakarta.persistence.Table;

			@Entity
			@Table(name = "tb_livros")
			public class Livros {

				@Id
				@GeneratedValue(strategy = GenerationType.IDENTITY)
				@Column(name = "id")
				private Long id;
				@Column(name = "titulo")
				private String titulo;
				@Column(name = "autor")
				private String autor;
				@Column(name = "categoria")
				private String categoria;
				@Column(name = "ano")
				private Integer ano; 
				@Column(name = "exemplares")
				private Integer exemplares;

			public Livros() {
			}

			public Long getId() {
				return id;
			}

			public void setId(Long id) {
				this.id = id;
			}

			public String getTitulo() {
				return titulo;
			}

			public void setTitulo(String titulo) {
				this.titulo = titulo;
			}

			public String getAutor() {
				return autor;
			}

			public void setAutor(String autor) {
				this.autor = autor;
			}

			public String getCategoria() {
				return categoria;
			}

			public void setCategoria(String categoria) {
				this.categoria = categoria;
			}

			public Integer getAno() {
				return ano;
			}

			public void setAno(Integer ano) {
				this.ano = ano;
			}

			public Integer getExemplares() {
				return exemplares;
			}

			public void setExemplares(Integer exemplares) {
				this.exemplares = exemplares;
			}


			}
