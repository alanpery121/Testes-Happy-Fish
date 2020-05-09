package model;

public class Venda {

    private String nomeFuncionario;
    private int comissao;

    public Venda(String nomeFuncionario, int comissao){
        this.nomeFuncionario = nomeFuncionario;
        this.comissao = comissao;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public int getComissao() {
        return comissao;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public void setComissao(int comissao) {
        this.comissao = comissao;
    }
}
