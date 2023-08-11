
	document.addEventListener("DOMContentLoaded", function(){
		atualizarContador();
	})

	function selecionarTodos() {
		var checkboxes = document.getElementsByClassName("selecionarItem");
		var checkboxTodos = document.getElementById("selecionarTodos");
		
		for (var i = 0; i < checkboxes.length; i++){
			checkboxes[i].checked = checkboxTodos.checked;
		}
		
		atualizarContador();
	}
	
	function atualizarContador(){
		var checkboxes = document.getElementsByClassName("selecionarItem");
		var totalRegistros = checkboxes.length; 
		var selecionados = 0;
		
		for (var i = 0; i <checkboxes.length; i++){
			if (checkboxes[i].checked){
				selecionados ++;
			}
		}
		
		document.getElementById("totalRegistros").textContent = "Total de Livros: " +totalRegistros;
		document.getElementById("selecionados").textContent = "Livros Selecionados: " +selecionados;
	}
	
	//Consultar Alunos por matricula
		const matriculaInput = document.getElementById('matricula');
		const nomeAlunoInput = document.getElementById('nomeAluno');
	
			matriculaInput.addEventListener('input', function(){
				const matricula = matriculaInput.value;
				
				axios.get('/alunos/' +matricula)
				.then(function(response){
					nomeAlunoInput.value = response.data;
				})
				.catch(function(){
					nomeAlunoInput.value = 'Aluno não encontrado';
				});
			});	
			
	//Emprestar livro
			function registrarEmprestimo(){
				console.log("Função registrarEmprestimo() foi chamada!")
				const livrosSelect = document.querySelectorAll('input[name="livros"]:checked');
				const livros = Array.from(livrosSelect).map(checkbox => {
					const row = checkbox.closest('tr');
					const tituloLivro = row.querySelector('.titulo-livro').textContent;
					return (tituloLivro);
				});
				
				const matricula = document.getElementById('matricula').value;
				const nome = document.getElementById('nomeAluno').value;
				const data = document.getElementById('dataEmprestimo').value;
			
				
				const emprestimo = {
					matricula: matricula,
					nome: nome,
					livros: livros,
					data: data
				};
				
				axios.post('/emprestimos', emprestimo)
					.then(function(response){
						console.log(response.data);
						document.getElementById('mensagem').textContent = 'Livro emprestado com sucesso!';
					})
					.catch(function(error){
						console.log("Erro na requisição POST: ",error);
						document.getElementById('mensagem').textContent = 'Problema ao emprestar livro.';
					});
				}

				// Função para devolver os livros emprestados.
			function devolverLivro(id){

				axios.delete('/emprestimos/' +id)
				.then(function (response){
					console.log(response.data);
					document.getElementById('emprestimo-' +id).remove();
				})
				.catch(function (error){
					console.log(error);
				});
			}

				//Função para deletar um livro cadastrado na tabela Livros.
			function deletarLivro(id){
				if (confirm('Deseja realmente deletar este livro?')){
					axios.delete('/deletar/' +id)
					.then(function(response) {
						console.log(response.data);
						document.getElementById('livros-' +id).remove();
					})
					.catch(function(error) {
						console.log(error);
					});
				}
			}

				