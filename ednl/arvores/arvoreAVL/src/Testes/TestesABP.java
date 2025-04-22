package Testes;

import Arvores.ArvoreAVL;

public class TestesABP {
    public static void main(String[] args) {
        ArvoreAVL abp = new ArvoreAVL();
        int controle = 0;

        if (controle == 1) {
            abp.incluirAVL(1);
            abp.incluirAVL(2);
            abp.incluirAVL(3);
            abp.incluirAVL(4);
            abp.incluirAVL(5);
            abp.incluirAVL(6);
        } else {
            // abp.incluirAVL(5);
            // abp.incluirAVL(7);
            // abp.incluirAVL(6);
            // abp.incluirAVL(3);
            // abp.incluirAVL(15);
            // abp.incluirAVL(14);
            // abp.incluirAVL(20);
            // int[] elements = { 32, 35, 31, 33, 36, 38 };
            // int[] elements = { 1, 2, 3, 4, 5, 6 };
            int[] elements = { 50, 20, 70, 10, 30, 5, 2 };
            // int[] elements = { 6, 5, 4, 3, 2, 1 };
            // int[] elements = { 6, 8, 9 };

            for (int i : elements) {
                abp.incluirAVL(i);
                abp.mostrar();
                System.out.println("/////////////////////////////////////////////////////////////////");
            }

            abp.emOrdem(abp.getRaiz());
            // System.out.println("---------------------------------------------------------------------------");

            // abp.rotacaoSimplesEsquerda(abp.getRaiz());

            // abp.mostrar();
        }

    }
}
