package estruturas.auxiliar;

import model.Produto;

/**
 * Representa um Nó em uma Árvore Binária de Busca (BST).
 */
public class NoArvore {
    public Produto dado;
    public NoArvore esquerda;
    public NoArvore direita;

    public NoArvore(Produto dado) {
        this.dado = dado;
        this.esquerda = null;
        this.direita = null;
    }

    // Método auxiliar para facilitar a impressão na BST
    @Override
    public String toString() {
        return dado.toString();
    }
}