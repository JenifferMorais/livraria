<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="pt-BR">
<body>
<h2>Alterar livro:</h2>
<form method = "post" action="/projetoweb/livros/update">

<fieldset>
<legend> Dados do livro: ${livro.nome} </legend>
<input type="hidden" name="id" value="${livro.id}">
Nome :
<input type="text" name="nome" value="${livro.nome}" >
<br>
Autor:
<input type="text" name="autor" value="${livro.autor}">
<br>
Valor:
<input type="text" name="valor" value="${livro.valor}">
<br>
Descrição:
<input type="text" name="descricao" value="${livro.descricao}">
<br>
ISBN:
<input type="text" name="isbn" value="${livro.ISBN}">
<br>
Quantidade:
<input type="text" name="quantidade" value="${livro.quantidade}">
<br>
</fieldset>
<br>
<input type="hidden" name="_method" value="PUT">
<input type="hidden" name="id" value="${livro.id}" /> 
<button class="btn btn-success" type="submit">Atualizar</button>
<input value="Limpar" type="reset"/>
</form>
</body>
</html>