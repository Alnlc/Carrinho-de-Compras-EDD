package estruturas;

import interfaces.IFila;
import model.Produto;

/**
 * Implementação de Fila (Queue) usando Array/Vetor.
 * Operações: Enqueue (inserir), Dequeue (remover), Peek (ver).
 * Regra: FIFO (First In, First Out).
 * Implementação básica com shift (lenta para grandes volumes, mas funciona).
 */
public class FilaEstatica implements IFila {
    private Produto[] arrayProdutos;
    private int quantidadeAtual;

    public FilaEstatica(int capacidadeMaxima) {
        this.arrayProdutos = new Produto[capacidadeMaxima];
        this.quantidadeAtual = 0;
    }

    @Override
    public void enqueue(Produto produto) {
        if (quantidadeAtual < arrayProdutos.length) {
            // Adiciona no final
            arrayProdutos[quantidadeAtual] = produto;
            quantidadeAtual++;
            System.out.println("[Fila] Produto '" + produto.getId() + "' adicionado no final.");
        } else {
            System.out.println("[Erro] Fila cheia! Não é possível adicionar mais.");
        }
    }

    @Override
    public Produto dequeue() {
        if (isEmpty()) {
            System.out.println("[Erro] Fila vazia! Nada para remover.");
            return null;
        }

        // O primeiro a entrar é o primeiro a sair (FIFO)
        Produto produtoRemovido = arrayProdutos[0];

        // Shift: Move todos os elementos para a esquerda
        for (int i = 0; i < quantidadeAtual - 1; i++) {
            arrayProdutos[i] = arrayProdutos[i + 1];
        }

        // Limpa a última posição e diminui o contador
        arrayProdutos[quantidadeAtual - 1] = null;
        quantidadeAtual--;

        System.out.println("[Fila] Produto '" + produtoRemovido.getId() + "' removido do início (FIFO).");
        return produtoRemovido;
    }

    @Override
    public Produto peek() {
        if (isEmpty()) {
            return null;
        }
        return arrayProdutos[0];
    }

    @Override
    public boolean isEmpty() {
        return quantidadeAtual == 0;
    }

    @Override
    public void listarConteudo() {
        System.out.println("\n--- CONTEÚDO DA FILA (FIFO) ---");
        if (isEmpty()) {
            System.out.println("Fila vazia.");
            return;
        }
        for (int i = 0; i < quantidadeAtual; i++) {
            System.out.println("Posição [" + i + "]: " + arrayProdutos[i]);
        }
    }
}