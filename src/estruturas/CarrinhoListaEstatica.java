package estruturas;

import interfaces.ICarrinho;
import model.Produto;

public class CarrinhoListaEstatica implements ICarrinho {
    private Produto[] arrayProdutos;
    private int quantidadeAtual;

    public CarrinhoListaEstatica(int capacidadeMaxima) {
        this.arrayProdutos = new Produto[capacidadeMaxima];
        this.quantidadeAtual = 0;
    }

    @Override
    public void adicionar(Produto produto) {
        if (quantidadeAtual < arrayProdutos.length) {
            arrayProdutos[quantidadeAtual] = produto;
            quantidadeAtual++;
            System.out.println("[Vetor] Produto alocado no índice " + (quantidadeAtual - 1));
        } else {
            System.out.println("[Erro] Lista Estática cheia! Não é possível adicionar.");
        }
    }

    @Override
    public void remover(int idProduto) {
        int indiceEncontrado = -1;

        // Busca sequencial pelo índice
        for (int i = 0; i < quantidadeAtual; i++) {
            if (arrayProdutos[i].getId() == idProduto) {
                indiceEncontrado = i;
                break;
            }
        }

        if (indiceEncontrado != -1) {
            // Realiza o "Shift" (deslocamento à esquerda) para cobrir o buraco
            for (int i = indiceEncontrado; i < quantidadeAtual - 1; i++) {
                arrayProdutos[i] = arrayProdutos[i + 1];
            }
            arrayProdutos[quantidadeAtual - 1] = null; // Limpa a referência duplicada no fim
            quantidadeAtual--;
            System.out.println("[Vetor] Item removido e array reorganizado.");
        } else {
            System.out.println("[Aviso] Produto não encontrado.");
        }
    }

    @Override
    public void listarConteudo() {
        System.out.println("\n--- CARRINHO (MEMÓRIA: LISTA ESTÁTICA/ARRAY) ---");
        if (quantidadeAtual == 0) {
            System.out.println("Vazio.");
            return;
        }
        for (int i = 0; i < quantidadeAtual; i++) {
            System.out.println("Índice [" + i + "]: " + arrayProdutos[i]);
        }
    }
}