package Tables;

public class Animal {
    private Integer ID_Animal;
    private String Nome;
    private Integer ID_cliente;
    private Integer ID_Especie;
    private Integer ID_Raca;

    // Constructor
    public Animal(Integer ID_Animal, String Nome, Integer ID_cliente, Integer ID_Especie, Integer ID_Raca) {
        this.ID_Animal = ID_Animal;
        this.Nome = Nome;
        this.ID_cliente = ID_cliente;
        this.ID_Especie = ID_Especie;
        this.ID_Raca = ID_Raca;
    }

    // Getters
    public String getNome() {
        return Nome;
    }

    public Integer getID_cliente() {
        return ID_cliente;
    }

    public Integer getID_Especie() {
        return ID_Especie;
    }

    public Integer getID_Raca() {
        return ID_Raca;
    }

    // Setters
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setID_cliente(Integer ID_cliente) {
        this.ID_cliente = ID_cliente;
    }

    public void setID_Especie(Integer ID_Especie) {
        this.ID_Especie = ID_Especie;
    }

    public void setID_Raca(Integer ID_Raca) {
        this.ID_Raca = ID_Raca;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "Nome='" + Nome + '\'' +
                ", ID_cliente=" + ID_cliente +
                ", ID_Especie=" + ID_Especie +
                ", ID_Raca=" + ID_Raca +
                '}';
    }

}
