package interfaces;

import model.Produto;

/**
 * Contrato para implementações de Pilha (LIFO - Last In, First Out).
 */
public interface IPilha {
    void push(Produto produto); // Adiciona no topo
    Produto pop(); // Remove do topo
    Produto peek(); // Vê o topo sem remover
    boolean isEmpty(); // Verifica se está vazia
    void listarConteudo();
}