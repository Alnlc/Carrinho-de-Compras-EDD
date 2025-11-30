package estruturas;

import model.Produto;
import java.util.LinkedList;

/**
 * Implementação da Tabela Hash com método de tratamento de colisão por Encaminhamento Separado (Separate Chaining).
 * A chave hash é o ID do Produto.
 */
public class TabelaHash {
    // Array de listas encadeadas (buckets)
    private LinkedList<Produto>[] tabela;
    private int capacidade;

    @SuppressWarnings("unchecked")
    public TabelaHash(int capacidade) {
        this.capacidade = capacidade;
        // O Java exige o suppress warnings ou uso de List<LinkedList<Produto>>
        this.tabela = new LinkedList[capacidade];
        // Inicializa cada "bucket" (posição do array) com uma Lista Encadeada
        for (int i = 0; i < capacidade; i++) {
            tabela[i] = new LinkedList<>();
        }
        System.out.println("[Tabela Hash] Tabela inicializada com " + capacidade + " buckets.");
    }

    // Função de Hash Simples: Módulo
    private int hashFunction(int id) {
        return id % capacidade;
    }

    // --- Inserção ---
    public void inserir(Produto produto) {
        int indice = hashFunction(produto.getId());
        LinkedList<Produto> bucket = tabela[indice];

        // Verifica se o produto já existe no bucket antes de adicionar
        for (Produto p : bucket) {
            if (p.getId() == produto.getId()) {
                System.out.println("[Aviso Hash] ID " + produto.getId() + " já existe. Ignorado.");
                return;
            }
        }
        bucket.add(produto);
        System.out.println("[Tabela Hash] Produto '" + produto.getId() + "' inserido no bucket [" + indice + "].");
    }

    // --- Busca ---
    public Produto buscar(int id) {
        int indice = hashFunction(id);
        LinkedList<Produto> bucket = tabela[indice];

        for (Produto p : bucket) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null; // Não encontrado
    }

    // --- Remoção ---
    public boolean remover(int id) {
        int indice = hashFunction(id);
        LinkedList<Produto> bucket = tabela[indice];

        boolean removido = bucket.removeIf(p -> p.getId() == id);
        if (removido) {
            System.out.println("[Tabela Hash] Produto ID: " + id + " removido do bucket [" + indice + "].");
        } else {
            System.out.println("[Aviso Hash] Produto ID: " + id + " não encontrado.");
        }
        return removido;
    }

    // --- Listagem ---
    public void listarConteudo() {
        System.out.println("\n--- CONTEÚDO DA TABELA HASH ---");
        boolean vazia = true;
        for (int i = 0; i < capacidade; i++) {
            if (!tabela[i].isEmpty()) {
                System.out.print("Bucket [" + i + "]: ");
                for (Produto p : tabela[i]) {
                    // Agora deve funcionar porque a classe Produto tem o método getNome()
                    System.out.print(p.getId() + " (" + p.getNome() + ") -> ");
                }
                System.out.println("NULL");
                vazia = false;
            }
        }
        if (vazia) {
            System.out.println("Tabela vazia.");
        }
    }
}