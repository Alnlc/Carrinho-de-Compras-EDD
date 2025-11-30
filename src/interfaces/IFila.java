package interfaces;

import model.Produto;

/**
 * Contrato para implementações de Fila (FIFO - First In, First Out).
 */
public interface IFila {
    void enqueue(Produto produto); // Adiciona no final
    Produto dequeue(); // Remove do início
    Produto peek(); // Vê o início sem remover
    boolean isEmpty(); // Verifica se está vazia
    void listarConteudo();
}