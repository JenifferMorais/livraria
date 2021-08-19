let carrinho = {
  state: JSON.parse(localStorage.getItem("carrinho") || "[]"),
  addCarrinho: async function (id, nome) {
    const findLivro = this.state.find(item => item.id == id);
    if (!findLivro) {
      this.state.push({id, quantidade: 1, nome});
      alert("Produto adicionado!");
    } else {
      alert("Item já adicionado ao carrinho! \nA modificação da quantidade está disponível no carrinho.")
    }
    await localStorage.setItem("carrinho", JSON.stringify(this.state));
  },
  mudarQuantidade: async function (id, quantidade) {
    const findLivro = this.state.find(item => item.id == id);
    if (findLivro) {
      findLivro.quantidade = quantidade;
      const newCarrinho = this.state.map(item => {
        if (item.id != id) {
          return item;
        } else if (quantidade != 0) {
          return findLivro;
        }
      }).filter(item => !!item);
      this.state = [...newCarrinho]
      await localStorage.setItem("carrinho", JSON.stringify(newCarrinho));
    }
  },
  adicionar: async function (id) {
    const {quantidade} = this.state.find(item => item.id == id);
    if (quantidade) {
      await this.mudarQuantidade(id, quantidade + 1);
    }
  },
  diminuir: async function (id) {
    const {quantidade} = this.state.find(item => item.id == id);
    if (quantidade) {
      await this.mudarQuantidade(id, quantidade - 1);
    }
  },
  limpar: function () {
    this.state = []
    localStorage.removeItem("carrinho");
  }
};

let sair = document.querySelector("a.sair");
sair.addEventListener('click', carrinho.limpar, false)



