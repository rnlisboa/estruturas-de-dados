package Testes;

import Arvores.ArvoreRubroNegra;

public class TesteRN {
    public static void main(String[] args) {
        ArvoreRubroNegra abp = new ArvoreRubroNegra();
        int[] teste1 = {3, 1, 4, 5};
        int[] teste2 = {30, 13, 53, 8, 23, 43, 83, 63, 93, 96};
        int[] elements = {10, 6, 22, 3, 8, 7, 9};

        inserir(abp, teste2);

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