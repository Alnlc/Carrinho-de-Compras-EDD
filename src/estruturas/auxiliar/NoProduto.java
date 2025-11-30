package estruturas.auxiliar;

import model.Produto;

/**
 * Representa um "elo" da corrente na Lista Encadeada.
 * Ele segura o DADO (Produto) e a REFERÊNCIA (Próximo).
 */
public class NoProduto {
    public Produto dado;    // O objeto Produto em si
    public NoProduto proximo; // O ponteiro para o próximo nó

    public NoProduto(Produto dado) {
        this.dado = dado;
        this.proximo = null; // Quando nasce, não aponta para ninguém
    }
}