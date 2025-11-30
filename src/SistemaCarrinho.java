package src; // Adicionado pacote src para alinhar com a estrutura de pastas

import java.util.Scanner;
import java.util.Random; // Para testes de ordenação
import interfaces.ICarrinho;
import interfaces.IFila;
import interfaces.IPilha;
import model.Produto;
import estruturas.CarrinhoListaEstatica;
import estruturas.CarrinhoListaEncadeada;
import estruturas.PilhaEstatica;
import estruturas.FilaEstatica;
import estruturas.ArvoreBinariaBusca;
import estruturas.TabelaHash;
import algoritmos.Algoritmos;


public class SistemaCarrinho {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE ESTRUTURA DE DADOS: PROJETO PRÁTICO ===");

        boolean rodando = true;
        while (rodando) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Estruturas Lineares (Projeto Carrinho)");
            System.out.println("2. Estruturas Não Lineares e Algoritmos");
            System.out.println("3. Sair");
            System.out.print("Opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    menuEstruturasLineares();
                    break;
                case 2:
                    menuOutrasEstruturas();
                    break;
                case 3:
                    rodando = false;
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }

    // --- MENU 1: ESTRUTURAS LINEARES (CARRINHO) ---
    private static void menuEstruturasLineares() {
        ICarrinho carrinho; // Interface genérica

        System.out.println("\n--- PROJETO CARRINHO (LISTAS LINEARES) ---");
        System.out.println("Selecione a arquitetura de memória:");
        System.out.println("1. Lista Estática (Array/Vetor)");
        System.out.println("2. Lista Encadeada (Dinâmica/Ponteiros)");
        System.out.print("Opção: ");

        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpa buffer

        // Define o carrinho
        if (escolha == 1) {
            carrinho = new CarrinhoListaEstatica(5); // Capacidade limitada para testar o "cheio"
            System.out.println(">>> Memória alocada: Array Contíguo <<<");
        } else if (escolha == 2) {
            carrinho = new CarrinhoListaEncadeada();
            System.out.println(">>> Memória alocada: Nós Dispersos <<<");
        } else {
            System.out.println("Opção inválida. Voltando ao menu principal.");
            return;
        }

        boolean rodandoCarrinho = true;
        while (rodandoCarrinho) {
            System.out.println("\n--- GERENCIADOR DE PRODUTOS ---");
            System.out.println("1. Adicionar");
            System.out.println("2. Remover");
            System.out.println("3. Listar Tudo");
            System.out.println("4. Voltar ao Menu Principal");
            System.out.print("Ação: ");

            int acao = scanner.nextInt();
            scanner.nextLine();

            switch (acao) {
                case 1:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    carrinho.adicionar(new Produto(id, nome, preco));
                    break;
                case 2:
                    System.out.print("ID para remover: ");
                    int idRemover = scanner.nextInt();
                    carrinho.remover(idRemover);
                    break;
                case 3:
                    carrinho.listarConteudo();
                    break;
                case 4:
                    rodandoCarrinho = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    // --- MENU 2: OUTRAS ESTRUTURAS E ALGORITMOS ---
    private static void menuOutrasEstruturas() {
        boolean rodandoOutras = true;
        while (rodandoOutras) {
            System.out.println("\n--- ESTRUTURAS NÃO LINEARES E ALGORITMOS ---");
            System.out.println("1. Pilha (LIFO)");
            System.out.println("2. Fila (FIFO)");
            System.out.println("3. Árvore Binária de Busca (BST)");
            System.out.println("4. Tabela Hash");
            System.out.println("5. Métodos de Busca e Ordenação");
            System.out.println("6. Voltar ao Menu Principal");
            System.out.print("Escolha a estrutura/algoritmo para testar: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    testarPilha();
                    break;
                case 2:
                    testarFila();
                    break;
                case 3:
                    testarBST();
                    break;
                case 4:
                    testarHash();
                    break;
                case 5:
                    testarAlgoritmos();
                    break;
                case 6:
                    rodandoOutras = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    // --- MÉTODOS DE TESTE ---

    private static void testarPilha() {
        IPilha pilha = new PilhaEstatica(3);
        System.out.println("\n--- TESTANDO PILHA LIFO ---");
        pilha.push(new Produto(101, "Mouse", 50.00));
        pilha.push(new Produto(102, "Teclado", 150.00));
        System.out.println("Topo (Peek): " + pilha.peek());

        pilha.listarConteudo();

        pilha.pop(); // Remove 102
        pilha.pop(); // Remove 101

        pilha.pop(); // Tenta remover da vazia
    }

    private static void testarFila() {
        IFila fila = new FilaEstatica(3);
        System.out.println("\n--- TESTANDO FILA FIFO ---");
        fila.enqueue(new Produto(201, "Cliente A", 10.00));
        fila.enqueue(new Produto(202, "Cliente B", 20.00));
        System.out.println("Frente (Peek): " + fila.peek());

        fila.listarConteudo();

        fila.dequeue(); // Remove 201
        fila.enqueue(new Produto(203, "Cliente C", 30.00)); // Adiciona 203

        fila.listarConteudo();

        fila.dequeue(); // Remove 202
        fila.dequeue(); // Remove 203
    }

    private static void testarBST() {
        ArvoreBinariaBusca bst = new ArvoreBinariaBusca();
        System.out.println("\n--- TESTANDO ÁRVORE BINÁRIA DE BUSCA (BST) ---");

        // Exemplo de inserção (para formar uma árvore balanceada)
        bst.inserir(new Produto(50, "Cadeira", 100.00));
        bst.inserir(new Produto(30, "Mesa", 200.00));
        bst.inserir(new Produto(70, "Monitor", 300.00));
        bst.inserir(new Produto(20, "Webcam", 50.00));
        bst.inserir(new Produto(40, "Headset", 150.00));
        bst.inserir(new Produto(60, "Impressora", 400.00));
        bst.inserir(new Produto(80, "Scanner", 250.00));

        // Listagem (In-Order deve ser ordenada pelo ID)
        bst.listarEmOrdem();

        // Busca
        Produto p = bst.buscar(40);
        System.out.println("Resultado da Busca (ID 40): " + (p != null ? p : "Não Encontrado."));
        p = bst.buscar(99);
        System.out.println("Resultado da Busca (ID 99): " + (p != null ? p : "Não Encontrado."));

        // Remoção (Nó com 2 filhos - 70)
        bst.remover(70);
        bst.listarEmOrdem();
    }

    private static void testarHash() {
        TabelaHash hash = new TabelaHash(5); // 5 buckets
        System.out.println("\n--- TESTANDO TABELA HASH ---");

        // Inserção com colisão (IDs 1 e 6 caem no bucket [1%5 = 1])
        hash.inserir(new Produto(1, "Item A", 10.00));
        hash.inserir(new Produto(6, "Item B (Colisão)", 20.00));
        hash.inserir(new Produto(2, "Item C", 30.00));
        hash.inserir(new Produto(7, "Item D (Colisão)", 40.00));
        hash.inserir(new Produto(10, "Item E", 50.00)); // ID 10 -> bucket [0]

        hash.listarConteudo();

        // Busca
        Produto p = hash.buscar(6);
        System.out.println("Resultado da Busca (ID 6): " + (p != null ? p : "Não Encontrado."));

        // Remoção
        hash.remover(6);
        hash.remover(99); // Não existe

        hash.listarConteudo();
    }

    private static void testarAlgoritmos() {
        System.out.println("\n--- TESTANDO ALGORITMOS DE BUSCA E ORDENAÇÃO ---");

        // Cria um array desordenado de Produtos (usando apenas o ID no nome para simplificar a visualização)
        int capacidade = 10;
        Produto[] arrayProdutos = new Produto[capacidade];
        Random rand = new Random();

        // Popula com IDs aleatórios para garantir desordem
        for (int i = 0; i < capacidade; i++) {
            // IDs entre 10 e 99
            int id = rand.nextInt(90) + 10;
            arrayProdutos[i] = new Produto(id, "P" + id, 10.0 * i);
        }

        Produto[] arrayBubble = arrayProdutos.clone(); // Cópia para Bubble Sort
        Produto[] arrayInsertion = arrayProdutos.clone(); // Cópia para Insertion Sort

        // --- Ordenação ---
        System.out.println("\n--- ORDENAÇÃO ---");

        System.out.print("Array Original (IDs): ");
        Algoritmos.imprimirArray(arrayProdutos, capacidade);

        // Teste Bubble Sort
        long inicioBubble = System.nanoTime();
        Algoritmos.bubbleSort(arrayBubble, capacidade);
        long fimBubble = System.nanoTime();
        System.out.print("Bubble Sort (IDs):    ");
        Algoritmos.imprimirArray(arrayBubble, capacidade);
        System.out.println("Tempo Bubble: " + (fimBubble - inicioBubble) + " ns");

        // Teste Insertion Sort
        long inicioInsertion = System.nanoTime();
        Algoritmos.insertionSort(arrayInsertion, capacidade);
        long fimInsertion = System.nanoTime();
        System.out.print("Insertion Sort (IDs): ");
        Algoritmos.imprimirArray(arrayInsertion, capacidade);
        System.out.println("Tempo Insertion: " + (fimInsertion - inicioInsertion) + " ns");

        // --- Busca ---
        System.out.println("\n--- BUSCA ---");
        int idBusca = arrayBubble[rand.nextInt(capacidade)].getId(); // Pega um ID que existe
        int idInexistente = 999;

        // Busca Sequencial (pode ser feita em qualquer array)
        int indiceSeq = Algoritmos.buscaSequencial(arrayProdutos, idBusca, capacidade);
        System.out.println("Busca Sequencial do ID " + idBusca + ": " + (indiceSeq != -1 ? "Encontrado no índice " + indiceSeq : "Não Encontrado."));

        // Busca Binária (precisa ser feita no array ordenado, ex: arrayBubble)
        int indiceBin = Algoritmos.buscaBinaria(arrayBubble, idBusca, capacidade);
        System.out.println("Busca Binária do ID " + idBusca + ": " + (indiceBin != -1 ? "Encontrado no índice " + indiceBin : "Não Encontrado."));

        // Teste de busca inexistente
        indiceBin = Algoritmos.buscaBinaria(arrayBubble, idInexistente, capacidade);
        System.out.println("Busca Binária do ID " + idInexistente + ": " + (indiceBin != -1 ? "Encontrado no índice " + indiceBin : "Não Encontrado."));
    }
}