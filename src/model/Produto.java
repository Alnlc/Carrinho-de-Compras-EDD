package model;

/**
 * Representa o dado que será armazenado nas estruturas.
 */
public class Produto {
    private int id;
    private String nome;
    private double preco;

    public Produto(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() { return id; }

    @Override
    public String toString() {
        return String.format("ID: %d | %s | R$ %.2f", id, nome, preco);
    }

    public int getNome() {
        return 0;
    }

    public int compareTo(Produto dado) {
        return 0;
    }
}
