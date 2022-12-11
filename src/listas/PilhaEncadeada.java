package listas;

import exceptions.NaoHaElementosException;
import exceptions.NaoHaEspacosVaziosException;
import interfaces.TPilha;
import model.TNo;

public class PilhaEncadeada implements TPilha {

    private TNo topo;

    @Override
    public void push(int k){
        TNo novo = new TNo(k);

        novo.setProx(topo);
        topo = novo;

    }

    @Override
    public int pop() throws NaoHaElementosException {
        if(isVazia()) throw new NaoHaElementosException();

        TNo lixo = topo;
        topo = topo.getProx();

        return lixo.getDado();
    }

    @Override
    public int top() throws NaoHaElementosException {
        if(isVazia()) throw new NaoHaElementosException();
        return topo.getDado();
    }

    @Override
    public boolean isVazia() {
        return topo == null;
    }

    @Override
    public boolean isCheia() {
        return false;
    }

    @Override
    public int tamanho() {

        int tamanho = 0;

        TNo aux = topo;

        while(aux != null){
            tamanho++;
            aux = aux.getProx();
        }

        return tamanho;
    }

    @Override
    public void imprimir() {
        TNo aux = topo;

        while (aux != null){
            System.out.println(aux.getDado());
            aux = aux.getProx();
        }

    }
}
