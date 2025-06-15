package Tables;

import java.math.BigDecimal;

public class Servico {
    private Integer ID_servico;
    private String Nome;
    private String Descricao;
    private BigDecimal preco;
    private Integer ID_Animal;
    private Integer ID_tipo_servico;
    private Integer ID_Forma_Pagamento;

    // Construtor
    public Servico(Integer ID_servico, String Nome, String Descricao, BigDecimal preco,
                   Integer ID_Animal, Integer ID_tipo_servico, Integer ID_Forma_Pagamento) {
        this.ID_servico = ID_servico;
        this.Nome = Nome;
        this.Descricao = Descricao;
        this.preco = preco;
        this.ID_Animal = ID_Animal;
        this.ID_tipo_servico = ID_tipo_servico;
        this.ID_Forma_Pagamento = ID_Forma_Pagamento;
    }

    // Getters
    public Integer getID_servico() {
        return ID_servico;
    }

    public String getNome() {
        return Nome;
    }

    public String getDescricao() {
        return Descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getID_Animal() {
        return ID_Animal;
    }

    public Integer getID_tipo_servico() {
        return ID_tipo_servico;
    }

    public Integer getID_Forma_Pagamento() {
        return ID_Forma_Pagamento;
    }

    // Setters
    public void setID_servico(Integer ID_servico) {
        this.ID_servico = ID_servico;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setID_Animal(Integer ID_Animal) {
        this.ID_Animal = ID_Animal;
    }

    public void setID_tipo_servico(Integer ID_tipo_servico) {
        this.ID_tipo_servico = ID_tipo_servico;
    }

    public void setID_Forma_Pagamento(Integer ID_Forma_Pagamento) {
        this.ID_Forma_Pagamento = ID_Forma_Pagamento;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "ID_servico=" + ID_servico +
                ", Nome='" + Nome + '\'' +
                ", Descricao='" + Descricao + '\'' +
                ", preco=" + preco +
                ", ID_Animal=" + ID_Animal +
                ", ID_tipo_servico=" + ID_tipo_servico +
                ", ID_Forma_Pagamento=" + ID_Forma_Pagamento +
                '}';
    }
}
