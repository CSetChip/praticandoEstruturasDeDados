package listas;

import exceptions.ElementoInexistenteException;
import exceptions.IndiceInexistenteException;
import exceptions.NaoHaElementosException;
import exceptions.NaoHaEspacosVaziosException;
import interfaces.TLista;
import model.TNo;

public class TListaEncadeada implements TLista {

    private TNo inicio;

    @Override
    public void addNoFinal(int elemento) throws NaoHaEspacosVaziosException {
        TNo novo = new TNo(elemento);

        if(isVazia()){
            inicio = novo;
        }else{

            TNo aux = inicio;

            while(aux.getProx() != null) {
                aux = aux.getProx();
            }

            aux.setProx(novo);

        }
    }

    @Override
    public void addNoInicio(int elemento) throws NaoHaEspacosVaziosException {
        TNo novo = new TNo(elemento);

        novo.setProx(inicio);
        inicio = novo;
    }

    @Override
    public void addEmUmIndiceEspecifico(int elemento, int indice) throws NaoHaEspacosVaziosException, IndiceInexistenteException, NaoHaElementosException {
        verificarElementoNoIndice(indice);

        if(indice == 0){
            addNoInicio(elemento);
        }else if(indice == tamanho() + 1){
            addNoFinal(elemento);
        }else{

            TNo novo = new TNo(elemento);
            TNo aux = inicio;

            int cont = 0;

            while (aux != null){

                if(cont == indice - 1){

                    TNo noDeslocado = aux.getProx();
                    aux.setProx(novo);
                    aux.getProx().setProx(noDeslocado);
                    break;
                }
                aux = aux.getProx();
                cont++;

            }
        }
    }

    @Override
    public int removeFinal() throws NaoHaElementosException {
        testarseHaElementosNaLista();

        TNo aux = inicio;
        int lixo;

        while (aux.getProx().getProx() != null){
            aux = aux.getProx();
        }

        lixo = aux.getProx().getDado();
        aux.setProx(null);

        return lixo;
    }

    @Override
    public int removerInicio() throws NaoHaElementosException {
        testarseHaElementosNaLista();

        int lixo = inicio.getDado();
        inicio = inicio.getProx();

        return lixo;
    }

    @Override
    public int removerDoIndice(int indice) throws IndiceInexistenteException, NaoHaElementosException {
        int tamanho = tamanho();
        
        if(indice < 0 || indice >= tamanho) throw new IndiceInexistenteException();

        int lixo = 0;

        if (indice == 0){
            removerInicio();
        }else if(indice == tamanho){
            removeFinal();
        }else{
            
            TNo aux = inicio;
            int cont = 0;
            
            while (cont < indice - 1){
                aux = aux.getProx();
                cont ++;
            }

            lixo = aux.getProx().getDado();
            aux.setProx(aux.getProx().getProx());
            
        }

        return lixo;
    }

    @Override
    public int removerElemento(int elemento) throws ElementoInexistenteException, NaoHaElementosException, IndiceInexistenteException {
        testarseHaElementosNaLista();

        int indice = verificarIndeceDoElemento(elemento);

        return removerDoIndice(indice);

    }

    @Override
    public boolean verificarSeElementoExiste(int elemento) {

        TNo aux = inicio;

        while (aux.getProx() != null){

            if(aux.getDado() == elemento || aux.getProx().getDado() == elemento){
                return true;
            }

            aux = aux.getProx();
        }
        return false;
    }

    @Override
    public int verificarIndeceDoElemento(int elemento) throws ElementoInexistenteException {
        testarSeElementosExisteNaLista(elemento);

        TNo aux = inicio;
        int cont = 0;
        while (aux.getProx() != null){

            if(aux.getDado() == elemento){
                break;
            }else if (aux.getProx().getDado() == elemento){
                cont++;
                break;
            }

            cont++;
            aux = aux.getProx();

        }

        return cont;
    }

    @Override
    public int verificarElementoNoIndice(int indice) throws IndiceInexistenteException, NaoHaElementosException {
        if(indice < 0 || indice >= tamanho()) throw new IndiceInexistenteException();


        int cont = 0;
        TNo aux = inicio;

        while(aux.getProx() != null) {
            if(cont == indice){
                return aux.getDado();
            }
            aux = aux.getProx();
            cont++;
        }

        return 0;
    }

    @Override
    public boolean isVazia() {
        return inicio == null;
    }

    @Override
    public boolean isCheia() {
        return false;
    }

    @Override
    public int tamanho() throws NaoHaElementosException {
        testarseHaElementosNaLista();

        int tamanho = 0;

        TNo aux = inicio;

        while(aux != null){
            tamanho++;
            aux = aux.getProx();
        }

        return tamanho;
    }

    @Override
    public void imprimir() {

        TNo aux = inicio;

        while(aux != null){

            System.out.println(aux.getDado());
            aux = aux.getProx();

        }

    }

    private void testarseHaElementosNaLista() throws NaoHaElementosException {
        if(isVazia()) throw new NaoHaElementosException();
    }

    private void testarSeElementosExisteNaLista(int elemento) throws ElementoInexistenteException {
        if(!verificarSeElementoExiste(elemento)) throw new ElementoInexistenteException();
    }

}
