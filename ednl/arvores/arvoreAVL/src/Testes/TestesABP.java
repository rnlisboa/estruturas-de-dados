package Testes;

import Arvores.ArvoreAVL;
import Node.No;

public class TestesABP {
    public static void main(String[] args) {
        ArvoreAVL abp = new ArvoreAVL();
        int[] listaEsquerda = {1,2,3,4,5,6,7,8,9,10};
        int[] listaDireita = {10,9,8,7,6,5,4,3,2,1};
        int[] rotacaoEsquerdaSimples = {32,31,35,33,36,38};
        int[] rotacaoDireitaSimples = {50,20,70,10,30,5};
        int[] rotacaoEsquerdaDupla = {50,20,80,70,90,60};
        int[] rotacaoDireitaDupla = {50,20,90,10,40,30};
        int[] elements = {5, 15, 22, 2, 8, 25};
    
        for (int i : rotacaoEsquerdaDupla) {
            abp.incluirAVL(i);
        }
        abp.mostrar();

    }
}
