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
        int[] elements = {10, 5, 15, 2, 8, 22,25};

        inserir(abp, elements);

        abp.removerAVL(5);
        abp.mostrar();
    }

    public static void inserir(ArvoreAVL abp, int[] elements) {
        long inicioInsercao = System.nanoTime();
        for (int i : elements) {
            abp.incluirAVL(i);
        }
        long fimInsercao = System.nanoTime();
        long tempoInsercao = fimInsercao - inicioInsercao;

        System.out.println("Tempo de inserção: " + (tempoInsercao / 1_000_000.0) + " ms (" + (tempoInsercao / 1_000_000_000.0) + " s)");
    }

    public static void pesquisar(ArvoreAVL abp, int key) {
        long inicioBusca = System.nanoTime();
        No no = abp.pesquisar(abp.getRaiz(), key);
        long fimBusca = System.nanoTime();
        long tempoBusca = fimBusca - inicioBusca;
        System.out.println(no.parent().element());
        System.out.println("Tempo de busca: " + tempoBusca + " ns (" + (tempoBusca / 1_000_000.0) + " ms / " + (tempoBusca / 1_000_000_000.0) + " s) para o nó " + no.element());
    }
}
