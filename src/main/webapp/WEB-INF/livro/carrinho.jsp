<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<title>Carrinho</title>
</head>
<body>
<table class="carrinhoTable">
<th>
<td>ID</td>
<td>Nome</td>
<td>Quantidade</td>
<td>Ações</td>
</th>



</table>
<script src="/projetoweb/js/carrinho.js"></script>
<script>
const lista = document.querySelector(".carrinhoTable");
if(carrinho.legth){
	carrinho.forEach(item=>{
		let tr = document.createElement("tr");
		tr.innerHTML= `<td>${item.id}</td><td>${item.quantidade}</td><td>
		<button type="button" onclick="adicionar(${item.id})"> adicionar</button>
		<button type="button" onclick="diminuir(${item.id})">diminuir</button></td>`
		lista.append(tr);
	})
}

</script>
</body>
</html>