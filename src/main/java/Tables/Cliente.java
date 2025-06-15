package Tables;

public class Cliente {
    private Integer ID_Cliente;
    private String Nome;
    private String Rua;
    private String Estado;
    private String CEP;
    private String CPF;

    public Cliente(Integer ID_Cliente, String Nome, String Rua, String Estado, String CEP, String CPF){
        this.ID_Cliente = ID_Cliente;
        this.Nome = Nome;
        this.Rua = Rua;
        this.Estado = Estado;
        this.CEP = CEP;
        this.CPF = CPF;
    };

    //Getters

    public Integer getID_Cliente() {
        return ID_Cliente;
    }

    public String getNome() {
        return Nome;
    }

    public String getRua() {
        return Rua;
    }

    public String getEstado() {
        return Estado;
    }

    public String getCEP() {
        return CEP;
    }
    public String getCPF() {
        return CPF;
    }

    //Setters

    public void setID_Cliente(Integer ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    @Override
    public String toString(){
        return "Cliente{" +
                "Nome=" + Nome + '\'' +
                ", Rua=" + Rua +
                ", Estado=" + Estado +
                ", CEP=" + CEP +
                ", CPF=" + CPF +
                '}';
    }
}
