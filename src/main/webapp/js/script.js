// script.js
function adicionarAoCarrinho(nomeProduto, precoProduto) {
    let carrinho = JSON.parse(localStorage.getItem('carrinho')) || [];
    const produto = { nome: nomeProduto, preco: precoProduto };
    
    carrinho.push(produto);
    localStorage.setItem('carrinho', JSON.stringify(carrinho));
    
    alert(nomeProduto + " foi adicionado ao seu carrinho!");
}
