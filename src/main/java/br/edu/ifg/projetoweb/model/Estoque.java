package br.edu.ifg.projetoweb.model;

public class Estoque {
	int id;
	int quantidade;
	int livros_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getLivros_id() {
		return livros_id;
	}

	public void setLivros_id(int livros_id) {
		this.livros_id = livros_id;
	}

}
