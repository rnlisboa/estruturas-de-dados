package abp;

import Node.No;

public class Teste {
    public static void main(String[] args) {
        ArvoreBinariaPesquisa abp = new ArvoreBinariaPesquisa();
        No newRaiz = new No(10);
        abp.setRaiz(newRaiz);
        abp.incluir(5);
        abp.incluir(15);
        abp.incluir(2);
        abp.incluir(8);
        abp.incluir(22);
        abp.incluir(25);
        abp.incluir(26);
        abp.incluir(35);
        abp.incluir(21);
        abp.incluir(7);
        abp.incluir(3);
        abp.mostrar();

        //abp.preOrdem(raiz);
    }
}
