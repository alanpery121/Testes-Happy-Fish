package model;

public class Pedido {

    private String nomeCliente;
    private String tipoPeixe;
    private String qtdKg;

    public Pedido(String nomeCliente, String tipoPeixe, String qtdKg){
        this.nomeCliente = nomeCliente;
        this.tipoPeixe = tipoPeixe;
        this.qtdKg = qtdKg;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getTipoPeixe() {
        return tipoPeixe;
    }

    public String getQtdKg() {
        return qtdKg;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setTipoPeixe(String tipoPeixe) {
        this.tipoPeixe = tipoPeixe;
    }

    public void setQtdKg(String qtdKg) {
        this.qtdKg = qtdKg;
    }
}
