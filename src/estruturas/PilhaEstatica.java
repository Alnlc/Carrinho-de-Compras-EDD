package estruturas;

import interfaces.IPilha;
import model.Produto;

/**
 * Implementação de Pilha usando Array/Vetor.
 * Operações: Push (inserir), Pop (remover), Peek (ver).
 * Regra: LIFO (Last In, First Out).
 */
public class PilhaEstatica implements IPilha {
    private Produto[] arrayProdutos;
    private int topo; // Ponteiro para a posição do último elemento inserido

    public PilhaEstatica(int capacidadeMaxima) {
        this.arrayProdutos = new Produto[capacidadeMaxima];
        this.topo = -1; // -1 indica que a pilha está vazia
    }

    @Override
    public void push(Produto produto) {
        if (topo < arrayProdutos.length - 1) {
            topo++;
            arrayProdutos[topo] = produto;
            System.out.println("[Pilha] Produto '" + produto.getId() + "' adicionado no topo.");
        } else {
            System.out.println("[Erro] Pilha cheia! Não é possível adicionar mais.");
        }
    }

    @Override
    public Produto pop() {
        if (isEmpty()) {
            System.out.println("[Erro] Pilha vazia! Nada para remover.");
            return null;
        }
        Produto produtoRemovido = arrayProdutos[topo];
        arrayProdutos[topo] = null; // Limpa a referência
        topo--;
        System.out.println("[Pilha] Produto '" + produtoRemovido.getId() + "' removido do topo (LIFO).");
        return produtoRemovido;
    }

    @Override
    public Produto peek() {
        if (isEmpty()) {
            System.out.println("[Aviso] Pilha vazia.");
            return null;
        }
        return arrayProdutos[topo];
    }

    @Override
    public boolean isEmpty() {
        return topo == -1;
    }

    @Override
    public void listarConteudo() {
        System.out.println("\n--- CONTEÚDO DA PILHA (LIFO) ---");
        if (isEmpty()) {
            System.out.println("Pilha vazia.");
            return;
        }
        for (int i = topo; i >= 0; i--) {
            System.out.println("Posição [" + i + "]: " + arrayProdutos[i]);
        }
    }
}