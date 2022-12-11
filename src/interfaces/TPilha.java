package interfaces;

import exceptions.NaoHaElementosException;
import exceptions.NaoHaEspacosVaziosException;

public interface TPilha {

    public void push(int k) throws NaoHaEspacosVaziosException;

    public int pop() throws NaoHaElementosException;

    public int top() throws  NaoHaElementosException;

    public boolean isVazia();

    public boolean isCheia();

    public int tamanho();

    public void imprimir();
}
