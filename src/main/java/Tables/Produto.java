package Tables;

import java.math.BigDecimal;

public class Produto {
    private Integer ID_Produto;
    private String nome;
    private BigDecimal preco;
    private Integer quantidade;

    // Construtor
    public Produto(Integer ID_Produto, String nome, BigDecimal preco, Integer quantidade) {
        this.ID_Produto = ID_Produto;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Getters
    public Integer getID_Produto() {
        return ID_Produto;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    // Setters
    public void setID_Produto(Integer ID_Produto) {
        this.ID_Produto = ID_Produto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }
}
