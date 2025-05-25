package Testes;

import Arvores.ArvoreRubroNegra;

public class TesteRN {
    public static void main(String[] args) {
        ArvoreRubroNegra abp = new ArvoreRubroNegra();
        int[] teste1 = {3, 1, 4, 5};
        int[] teste2 = {30, 13, 53, 8, 23, 43, 83, 63, 93, 96, 7};
        int[] elements = {10, 6, 22, 3, 8, 7, 9};
        int[] listaEsquerda = {1,2,3,4, 5, 6, 7, 8,9,10,11,12};
        int[] listaDireita = {12,11,10,9,8,7,6,5,4,3,2, 1};
        inserir(abp, listaEsquerda);

        abp.mostrarRN();

        abp.remove(10);
        abp.mostrarRN();
    }

    public static void inserir(ArvoreRubroNegra abp, int[] elements) {
        long inicioInsercao = System.nanoTime();
        for (int i : elements) {
            abp.insert(i);
        }
        long fimInsercao = System.nanoTime();
        long tempoInsercao = fimInsercao - inicioInsercao;

        //System.out.println("Tempo de inserção: " + (tempoInsercao / 1_000_000.0) + " ms (" + (tempoInsercao / 1_000_000_000.0) + " s)");
    }
}