package br.edu.ifg.projetoweb.model;

public class ItemVenda {
	int livro_id;
	int venda_id;
	int quantidade;
	double valor_unitario;

	public int getLivro_id() {
		return livro_id;
	}

	public void setLivro_id(int livro_id) {
		this.livro_id = livro_id;
	}

	public int getVenda_id() {
		return venda_id;
	}

	public void setVenda_id(int venda_id) {
		this.venda_id = venda_id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor_unitario() {
		return valor_unitario;
	}

	public void setValor_unitario(double valor_unitario) {
		this.valor_unitario = valor_unitario;
	}

}
