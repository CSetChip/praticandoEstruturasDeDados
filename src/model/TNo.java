package model;

public class TNo {
    private int dado;
    private TNo prox;

    public TNo(int dado){this.dado = dado;}

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public TNo getProx() {
        return prox;
    }

    public void setProx(TNo prox) {
        this.prox = prox;
    }
}
