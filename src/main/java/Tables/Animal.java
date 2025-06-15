package Tables;

public class Animal {
    private Integer ID_Animal;
    private String Nome;
    private Integer ID_cliente;
    private Integer ID_Especie;

    // Constructor
    public Animal(Integer ID_Animal, String Nome, Integer ID_cliente, Integer ID_Especie) {
        this.ID_Animal = ID_Animal;
        this.Nome = Nome;
        this.ID_cliente = ID_cliente;
        this.ID_Especie = ID_Especie;

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



    @Override
    public String toString() {
        return "Animal{" +
                "Nome='" + Nome + '\'' +
                ", ID_cliente=" + ID_cliente +
                ", ID_Especie=" + ID_Especie +
                '}';
    }

}
