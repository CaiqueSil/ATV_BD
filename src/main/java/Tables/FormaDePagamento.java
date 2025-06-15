package Tables;

public class FormaDePagamento {
    private Integer ID_Pagamento;
    private String forma_pagamento;

    // Construtor
    public FormaDePagamento(Integer ID_Pagamento, String forma_pagamento) {
        this.ID_Pagamento = ID_Pagamento;
        this.forma_pagamento = forma_pagamento;
    }

    // Getters
    public Integer getID_Pagamento() {
        return ID_Pagamento;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    // Setters
    public void setID_Pagamento(Integer ID_Pagamento) {
        this.ID_Pagamento = ID_Pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    @Override
    public String toString() {
        return "FormaDePagamento{" +
                "ID_Pagamento=" + ID_Pagamento +
                ", forma_pagamento='" + forma_pagamento + '\'' +
                '}';
    }


}
