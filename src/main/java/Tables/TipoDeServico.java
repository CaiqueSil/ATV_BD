package Tables;

public class TipoDeServico {
    private Integer id_tipo;
    private String tipo_servico;

    // Construtor
    public TipoDeServico(Integer id_tipo, String tipo_servico) {
        this.id_tipo = id_tipo;
        this.tipo_servico = tipo_servico;
    }

    // Getters
    public Integer getId_tipo() {
        return id_tipo;
    }

    public String getTipo_servico() {
        return tipo_servico;
    }

    // Setters
    public void setId_tipo(Integer id_tipo) {
        this.id_tipo = id_tipo;
    }

    public void setTipo_servico(String tipo_servico) {
        this.tipo_servico = tipo_servico;
    }

    @Override
    public String toString() {
        return "TipoDeServico{" +
                "id_tipo=" + id_tipo +
                ", tipo_servico='" + tipo_servico + '\'' +
                '}';
    }
}
