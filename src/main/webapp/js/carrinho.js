let carrinho = JSON.parse(localStorage.getItem("carrinho") || "[]");

async function addCarrinho(id, nome) {
	const findLivro = carrinho.find(item => item.id == id);
	if (!findLivro) {
		carrinho.push({ id, quantidade: 1, nome });
	} else {
		alert("Item já adicionado ao carrinho! \nA modificação da quantidade está disponível no carrinho.")
	}
	await localStorage.setItem("carrinho", JSON.stringify(carrinho));

}

async function mudarQuantidade(id, quantidade) {
	const findLivro = carrinho.find(item => item.id == id);
	if (findLivro) {
		findLivro.quantidade = quantidade;
		const newCarrinho = carrinho.map(item => {
			if (item.id != id) {
				return item;
<<<<<<< Updated upstream
			} else if(quantidade!=0){
				return findLivro;
			}
		}).filter(item=>!!item);
=======
			} else if (quantidade != 0) {
				return findLivro;
			}
		}).filter(item => !!item);
		carrinho = [...newCarrinho];
>>>>>>> Stashed changes
		await localStorage.setItem("carrinho", JSON.stringify(newcarrinho));
		carrinho = [...newcarrinho]
	}
};

async function adicionar(id) {
	const { quantidade } = carrinho.find(item => item.id == id);
	if (quantidade) {
		await mudarQuantidade(id, quantidade + 1);
	}
};
async function diminuir(id) {
	const { quantidade } = carrinho.find(item => item.id == id);
	if (quantidade) {
		await mudarQuantidade(id, quantidade - 1);
	}
};







