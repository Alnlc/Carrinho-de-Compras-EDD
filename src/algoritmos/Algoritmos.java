package algoritmos;

import model.Produto;

/**
 * Coleção de métodos estáticos para demonstração de Algoritmos de Busca e Ordenação.
 */
public class Algoritmos {

    // --- Algoritmos de Ordenação ---

    /**
     * Bubble Sort (Troca da Bolha) - Lento (O(n^2)), mas simples.
     */
    public static void bubbleSort(Produto[] array, int tamanho) {
        int n = tamanho;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Compara pelo ID do Produto
                if (array[j].getId() > array[j + 1].getId()) {
                    // Troca array[j+1] e array[j]
                    Produto temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Insertion Sort (Ordenação por Inserção) - Melhor que Bubble (O(n^2) pior caso, O(n) melhor caso).
     */
    public static void insertionSort(Produto[] array, int tamanho) {
        for (int i = 1; i < tamanho; ++i) {
            Produto chave = array[i];
            int j = i - 1;

            // Move os elementos de array[0..i-1] que são maiores que a chave
            // para uma posição à frente de sua posição atual
            while (j >= 0 && array[j].getId() > chave.getId()) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = chave;
        }
    }

    // --- Algoritmos de Busca ---

    /**
     * Busca Binária - Rápida (O(log n)), MAS exige que o array esteja ORDENADO.
     * Retorna o índice do Produto ou -1 se não encontrado.
     */
    public static int buscaBinaria(Produto[] array, int idBusca, int tamanho) {
        int inicio = 0;
        int fim = tamanho - 1;

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;

            if (array[meio].getId() == idBusca) {
                return meio; // Produto encontrado
            }

            // Se o ID da busca for menor, ignora a metade direita
            if (idBusca < array[meio].getId()) {
                fim = meio - 1;
            }
            // Se o ID da busca for maior, ignora a metade esquerda
            else {
                inicio = meio + 1;
            }
        }
        return -1; // Produto não encontrado
    }

    /**
     * Busca Sequencial - Simples (O(n)), não exige ordenação.
     * Retorna o índice do Produto ou -1 se não encontrado.
     */
    public static int buscaSequencial(Produto[] array, int idBusca, int tamanho) {
        for (int i = 0; i < tamanho; i++) {
            if (array[i].getId() == idBusca) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Método auxiliar para imprimir um array
     */
    public static void imprimirArray(Produto[] array, int tamanho) {
        System.out.print("[");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(array[i].getId());
            if (i < tamanho - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}