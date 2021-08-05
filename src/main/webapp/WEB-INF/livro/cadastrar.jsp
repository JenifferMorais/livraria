<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="pt-BR">
<body>
	<h2>Livros</h2>
	<form action="/projetoweb/livros/cadastrar" method="POST">

		<fieldset>
			<legend> Dados do livro </legend>
			Nome : <input type="text" name="nome" required autofocus> <br>
			Autor: <input type="text" name="autor"> <br> Valor: <input
				type="text" name="valor"> <br> Descrição: <input
				type="text" name="descricao"> <br> ISBN: <input
				type="text" name="isbn"> <br> Quantidade: <input
				type="text" name="quantidade"> <br>
		</fieldset>
		<br> <input value="Enviar" type="submit" /> <input value="Limpar"
			type="reset" />
			
			</form>
	</body>
</html>