package estruturas;

import estruturas.auxiliar.NoProduto;
import interfaces.ICarrinho;
import model.Produto;

public class CarrinhoListaEncadeada implements ICarrinho {
    private NoProduto cabeca; // Primeiro elemento da lista

    public CarrinhoListaEncadeada() {
        this.cabeca = null;
    }

    @Override
    public void adicionar(Produto produto) {
        NoProduto novoNo = new NoProduto(produto);

        if (cabeca == null) {
            cabeca = novoNo;
        } else {
            // Percorre a lista até achar o último nó (onde proximo é null)
            NoProduto atual = cabeca;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            // Faz o último nó apontar para o novo
            atual.proximo = novoNo;
        }
        System.out.println("[Lista Encadeada] Novo nó vinculado ao final da lista.");
    }

    @Override
    public void remover(int idProduto) {
        if (cabeca == null) {
            System.out.println("Lista vazia.");
            return;
        }

        // Caso 1: Remover a cabeça (primeiro elemento)
        if (cabeca.dado.getId() == idProduto) {
            cabeca = cabeca.proximo; // O segundo vira o primeiro
            System.out.println("[Lista Encadeada] Nó removido do início (Head atualizada).");
            return;
        }

        // Caso 2: Remover do meio ou fim
        NoProduto atual = cabeca;
        NoProduto anterior = null;

        while (atual != null && atual.dado.getId() != idProduto) {
            anterior = atual;
            atual = atual.proximo;
        }

        if (atual != null) {
            // O anterior pula o atual e aponta para o próximo do atual
            anterior.proximo = atual.proximo;
            System.out.println("[Lista Encadeada] Nó desvinculado. Ponteiros ajustados.");
        } else {
            System.out.println("[Aviso] Produto não encontrado.");
        }
    }

    @Override
    public void listarConteudo() {
        System.out.println("\n--- CARRINHO (MEMÓRIA: LISTA ENCADEADA DINÂMICA) ---");
        if (cabeca == null) {
            System.out.println("Vazio.");
            return;
        }

        NoProduto atual = cabeca;
        int contador = 0;
        // Navegação via ponteiros
        while (atual != null) {
            System.out.println("Nó (" + contador + ") -> " + atual.dado);
            atual = atual.proximo; // Avança o ponteiro
            contador++;
        }
        System.out.println("(null)"); // Indica visualmente o fim da lista
    }
}