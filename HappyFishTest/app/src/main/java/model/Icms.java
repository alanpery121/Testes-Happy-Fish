package model;

public class Icms {

    private String estado;
    private int aliquota;

    public Icms(String estado, int aliquota){
        this.estado = estado;
        this.aliquota = aliquota;
    }

    public String getEstado() {
        return estado;
    }

    public int getAliquota() {
        return aliquota;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setAliquota(int aliquota) {
        this.aliquota = aliquota;
    }
}
