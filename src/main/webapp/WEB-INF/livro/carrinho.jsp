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
	<thead>
<th>ID</th>
<th>Nome</th>
<th>Quantidade</th>
<th>Ações</th>

	</thead>
<tbody>
</tbody>
</table>
<script src="/projetoweb/js/carrinho.js"></script>
<script>
const lista = document.querySelector(".carrinhoTable tbody");
function carregarTabela(){
lista.innerHTML="";
if(carrinho.length){
	
	carrinho.forEach(item=>{
		let tr = document.createElement("tr");
		tr.innerHTML= `<td>\${item.id}</td><td>\${item.nome}</td><td>\${item.quantidade}</td><td>
		<button type="button" onclick="adicionar(\${item.id}); carregarTabela()">adicionar</button>
		<button type="button" onclick="diminuir(\${item.id}); carregarTabela()">diminuir</button></td>`
		lista.append(tr);
	})
}
}
carregarTabela();
</script>
</body>
</html>