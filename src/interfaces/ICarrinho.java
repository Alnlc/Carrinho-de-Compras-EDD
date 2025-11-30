package interfaces;

import model.Produto;

/**
 * Contrato que obriga qualquer implementação de carrinho
 * a ter os métodos fundamentais de manipulação de dados.
 */
public interface ICarrinho {
    void adicionar(Produto produto);
    void remover(int idProduto);
    void listarConteudo();
}