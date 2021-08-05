<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="pt-BR">
<body>
	<h2>Livros</h2>
	
<h3>Lista de livros:</h3>
	<ul>
	<c:forEach var="livro" items="${livros}">
	
			<li><c:out value="${livro.nome}"/><a href="/projetoweb/livros/${livro.id }"> Editar</a>
			
				<form action="/projetoweb/livros" method="POST">
					<input type="hidden" name="_method" value="DELETE"><input
						type="hidden" name="id" value="${livro.id}" /> <input
						value="Excluir" type="submit" />
						</form>
				</li>

		</c:forEach>
		
	</ul>
	
</body>
</html>
