package listas;

import exceptions.NaoHaElementosException;
import exceptions.NaoHaEspacosVaziosException;
import interfaces.TPilha;

public class PilhaSequencial implements TPilha {

    private int[] pilha;
    private int topo = -1;

    public PilhaSequencial(int MAX){
        pilha = new int[MAX];
    }

    @Override
    public void push(int k) throws NaoHaEspacosVaziosException {
        if(isCheia()) throw new NaoHaEspacosVaziosException();

        pilha[++topo] = k;

    }

    @Override
    public int pop() throws NaoHaElementosException {
        if(isVazia()) throw new NaoHaElementosException();

        int lixo = pilha[topo--];
        return lixo;
    }

    @Override
    public int top() throws NaoHaElementosException {
        if (isVazia()) throw new NaoHaElementosException();
        return pilha[topo];
    }

    @Override
    public boolean isVazia() {
        return topo == -1;
    }

    @Override
    public boolean isCheia() {
        return topo == pilha.length - 1;
    }

    @Override
    public int tamanho() {
        return topo + 1;
    }

    @Override
    public void imprimir() {
        for (int i = topo; 0 <= i; i--){System.out.println(pilha[i]);}
    }
}
