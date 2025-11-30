package estruturas;

import estruturas.auxiliar.NoArvore;
import model.Produto;

/**
 * Implementação da Árvore Binária de Busca (BST).
 * As operações de Inserção, Busca e Remoção são baseadas na ordem do ID do Produto.
 */
public class ArvoreBinariaBusca {
    private NoArvore raiz;

    public ArvoreBinariaBusca() {
        this.raiz = null;
    }

    // --- Inserção ---
    public void inserir(Produto produto) {
        this.raiz = inserirRecursivo(raiz, produto);
        System.out.println("[BST] Produto " + produto.getId() + " inserido na árvore.");
    }

    private NoArvore inserirRecursivo(NoArvore atual, Produto produto) {
        if (atual == null) {
            return new NoArvore(produto);
        }

        if (produto.compareTo(atual.dado) < 0) {
            // Se o ID for menor, vai para a subárvore esquerda
            atual.esquerda = inserirRecursivo(atual.esquerda, produto);
        } else if (produto.compareTo(atual.dado) > 0) {
            // Se o ID for maior, vai para a subárvore direita
            atual.direita = inserirRecursivo(atual.direita, produto);
        } else {
            // IDs iguais (não faz nada ou pode ser tratado como erro/atualização)
            System.out.println("[Aviso BST] ID " + produto.getId() + " já existe. Ignorado.");
            return atual;
        }

        return atual;
    }

    // --- Busca ---
    public Produto buscar(int id) {
        Produto produtoBusca = new Produto(id, "", 0); // Cria um 'dummy' para comparação
        return buscarRecursivo(raiz, produtoBusca);
    }

    private Produto buscarRecursivo(NoArvore atual, Produto produtoBusca) {
        if (atual == null) {
            return null;
        }

        if (produtoBusca.compareTo(atual.dado) == 0) {
            return atual.dado; // Encontrado
        } else if (produtoBusca.compareTo(atual.dado) < 0) {
            return buscarRecursivo(atual.esquerda, produtoBusca); // Busca na esquerda
        } else {
            return buscarRecursivo(atual.direita, produtoBusca); // Busca na direita
        }
    }

    // --- Remoção ---
    public void remover(int id) {
        Produto produtoRemover = new Produto(id, "", 0);
        this.raiz = removerRecursivo(raiz, produtoRemover);
        System.out.println("[BST] Tentativa de remover o Produto ID: " + id);
    }

    private NoArvore removerRecursivo(NoArvore atual, Produto produtoRemover) {
        if (atual == null) {
            System.out.println("[Aviso BST] Produto não encontrado para remoção.");
            return null;
        }

        if (produtoRemover.compareTo(atual.dado) < 0) {
            atual.esquerda = removerRecursivo(atual.esquerda, produtoRemover);
        } else if (produtoRemover.compareTo(atual.dado) > 0) {
            atual.direita = removerRecursivo(atual.direita, produtoRemover);
        } else {
            // Nó com o ID encontrado, realiza a remoção

            // Caso 1: Nó sem filhos ou com 1 filho
            if (atual.esquerda == null) {
                return atual.direita;
            }
            if (atual.direita == null) {
                return atual.esquerda;
            }

            // Caso 2: Nó com 2 filhos
            // Substitui pelo menor valor na subárvore direita (sucessor in-order)
            Produto sucessor = encontrarMenorValor(atual.direita);
            atual.dado = sucessor;
            // Remove o sucessor da subárvore direita
            atual.direita = removerRecursivo(atual.direita, new Produto(sucessor.getId(), "", 0));
        }
        return atual;
    }

    private Produto encontrarMenorValor(NoArvore raiz) {
        if (raiz.esquerda == null) {
            return raiz.dado;
        } else {
            return encontrarMenorValor(raiz.esquerda);
        }
    }

    // --- Travessias (Listagem) ---
    public void listarEmOrdem() {
        System.out.println("\n--- CONTEÚDO DA ÁRVORE (Travessia In-Order) ---");
        if (raiz == null) {
            System.out.println("Árvore vazia.");
            return;
        }
        listarEmOrdemRecursivo(raiz);
    }

    private void listarEmOrdemRecursivo(NoArvore no) {
        if (no != null) {
            listarEmOrdemRecursivo(no.esquerda);
            System.out.println(no.dado);
            listarEmOrdemRecursivo(no.direita);
        }
    }
}