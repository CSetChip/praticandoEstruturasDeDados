package listas;

import exceptions.ElementoInexistenteException;
import exceptions.IndiceInexistenteException;
import exceptions.NaoHaElementosException;
import exceptions.NaoHaEspacosVaziosException;
import interfaces.TLista;

public class TListaSequencial implements TLista {

    private int[] array;
    private int quantidade;

    public TListaSequencial(int MAX){
        array = new int[MAX];
        quantidade = 0;
    }

    @Override
    public void addNoFinal(int elemento) throws NaoHaEspacosVaziosException {
        testarseHaEspacosLivres();
        array[quantidade++] = elemento;
    }

    @Override
    public void addNoInicio(int elemento) throws NaoHaEspacosVaziosException {
        testarseHaEspacosLivres();

        for(int i = quantidade; i > 0; i--){
            array[i] = array[i-1];
        }

        array[0] = elemento;
        quantidade++;
    }

    @Override
    public void addEmUmIndiceEspecifico(int elemento, int indice) throws NaoHaEspacosVaziosException {

        if (quantidade == 0){
            addNoInicio(elemento);
        } else if (indice == quantidade){
            addNoFinal(elemento);
        } else{
            for(int i = quantidade; i > indice; i--){
                array[i] = array[i-1];
            }

            array[indice] = elemento;
            quantidade++;
        }
    }

    @Override
    public int removeFinal() throws NaoHaElementosException {
        testarseHaElementosNaLista();

        int lixo = array[quantidade - 1];
        quantidade--;

        return lixo;
    }

    @Override
    public int removerInicio() throws NaoHaElementosException {
        testarseHaElementosNaLista();

        int lixo = array[0];

        for(int i = 0; i < quantidade; i++){
            if(i < quantidade - 1) {
                array[i] = array[i + 1];
            }else {
                array[i] = array[quantidade - 1];
            }
        }

        quantidade--;

        return lixo;
    }

    @Override
    public int removerDoIndice(int indice) throws IndiceInexistenteException, NaoHaElementosException {
        testarseHaElementosNaLista();
        if(indice < 0 || indice >= tamanho()) throw new IndiceInexistenteException();

        int lixo = array[indice];

        for(int i = indice; i < quantidade; i++){
            if(i < quantidade - 1) {
                array[i] = array[i + 1];
            }else {
                array[i] = array[quantidade - 1];
            }
        }

        quantidade--;

        return lixo;
    }

    @Override
    public int removerElemento(int elemento) throws ElementoInexistenteException, NaoHaElementosException {

        testarseHaElementosNaLista();
        int indice = verificarIndeceDoElemento(elemento);


        try {
            removerDoIndice(indice);
        } catch (IndiceInexistenteException e) {
            throw new RuntimeException(e);
        }

        return indice;
    }

    @Override
    public boolean verificarSeElementoExiste(int elemento) {

        for(int i = 0; i < quantidade; i++){
            if (array[i] == elemento) return true;
        }
        return false;
    }

    @Override
    public int verificarIndeceDoElemento(int elemento) throws ElementoInexistenteException {
        for(int i = 0; i < quantidade; i++){
            if (array[i] == elemento){
                return i;
            }
        }

        throw new ElementoInexistenteException();
    }

    @Override
    public int verificarElementoNoIndice(int indice) throws IndiceInexistenteException {
        if(indice < 0 || indice >= tamanho()) throw new IndiceInexistenteException();
        return array[indice];
    }

    @Override
    public boolean isVazia() {
        return quantidade == 0;
    }

    @Override
    public boolean isCheia() {
        return quantidade == array.length;
    }

    @Override
    public int tamanho() {
        return quantidade;
    }

    @Override
    public void imprimir() {
        for (int i =0; i < quantidade; i++) {
            System.out.println(array[i]);
        }
    }

    private void testarseHaEspacosLivres() throws NaoHaEspacosVaziosException {
        if(isCheia()) throw new NaoHaEspacosVaziosException();
    }
    private void testarseHaElementosNaLista() throws NaoHaElementosException {
        if(isVazia()) throw new NaoHaElementosException();
    }

}
