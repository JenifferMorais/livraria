let lista = document.querySelector("#user-list")
let searchInput = document.querySelector("#search-input")
let searchButton = document.querySelector("#search-button")

function searchUsers(e) {
	e.preventDefault()
let xhr = new XMLHttpRequest();

	xhr.onload = function(){
		if(xhr.status === 200){
			
			responseObject = JSON.parse(xhr.responseText);
			let content = '';
			let i = 0;
			for(;i<responseObject.users.length;i++){
			content+=`<tr><td>${responseObject.users[i].id}</td>`;
			content+=`<td>${responseObject.users[i].nome}</td>`;
			content+=`<td>${responseObject.users[i].email}</td>`;
			content+=`<td>${responseObject.users[i].telefone}</td>`;
			content+=`<td><a href="/projetoweb/usuario/${responseObject.users[i].id}">Editar</a></td>`;
			content+=`<td><form action="/projetoweb/usuario" method="POST">`;
			content+=`<input type="hidden" name="_method" value="DELETE">`;
			content+=`<input type="hidden name="id" value="${responseObject.users[i].id}"/>`;
			content+=`<input value="Excluir" type="submit"/></form></td></tr>`;}
			lista.innerHTML = content;
		}
		
	}
	
	xhr.open(`GET`,`/projetoweb/usuario?search=${searchInput.value}`,true)
	xhr.send(null);
	
}

