package interfaces;

import exceptions.ElementoInexistenteException;
import exceptions.NaoHaElementosException;
import exceptions.IndiceInexistenteException;
import exceptions.NaoHaEspacosVaziosException;

public interface TLista {

    public void addNoFinal(int elemento) throws NaoHaEspacosVaziosException;

    public  void addNoInicio(int elemento) throws NaoHaEspacosVaziosException;

    public void addEmUmIndiceEspecifico(int elemento, int indice) throws NaoHaEspacosVaziosException, IndiceInexistenteException, NaoHaElementosException;

    public int removeFinal() throws NaoHaElementosException;

    public int removerInicio() throws NaoHaElementosException;

    public int removerDoIndice(int indice) throws IndiceInexistenteException, NaoHaElementosException;

    public int removerElemento(int elemento) throws ElementoInexistenteException, NaoHaElementosException, IndiceInexistenteException;

    public boolean verificarSeElementoExiste(int elemento);

    public int verificarIndeceDoElemento(int elemento) throws ElementoInexistenteException;

    public int verificarElementoNoIndice(int indice) throws IndiceInexistenteException, NaoHaElementosException;

    public boolean isVazia();

    public boolean isCheia();

    public  int tamanho() throws NaoHaElementosException;

    public void imprimir();

}
