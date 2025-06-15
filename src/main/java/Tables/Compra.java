package Tables;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Compra {
    private Integer ID_Compra;
    private LocalDate Data_Compra;
    private BigDecimal valor;
    private Integer ID_Cliente;

    // Construtor
    public Compra(Integer ID_Compra, LocalDate Data_Compra, BigDecimal valor, Integer ID_Cliente) {
        this.ID_Compra = ID_Compra;
        this.Data_Compra = Data_Compra;
        this.valor = valor;
        this.ID_Cliente = ID_Cliente;
    }

    // Getters
    public Integer getID_Compra() {
        return ID_Compra;
    }

    public LocalDate getData_Compra() {
        return Data_Compra;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Integer getID_Cliente() {
        return ID_Cliente;
    }

    // Setters
    public void setID_Compra(Integer ID_Compra) {
        this.ID_Compra = ID_Compra;
    }

    public void setData_Compra(LocalDate Data_Compra) {
        this.Data_Compra = Data_Compra;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setID_Cliente(Integer ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "ID_Compra=" + ID_Compra +
                ", Data_Compra=" + Data_Compra +
                ", valor=" + valor +
                ", ID_Cliente=" + ID_Cliente +
                '}';
    }
}
