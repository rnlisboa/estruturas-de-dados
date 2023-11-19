package ArvoreBinariaPesquisa;

import java.util.Iterator;

import Node.No;

public class TesteABP {
    public static void main(String[] args) {
        ArvoreBinariaPesquisa abp = new ArvoreBinariaPesquisa(10);
        abp.incluir(5);
        abp.incluir(15);
        abp.incluir(2);
        abp.incluir(8);
        abp.incluir(15);
        abp.incluir(22);
        abp.incluir(25);
        No raiz = abp.getRaiz();
        abp.emOrdem(raiz);
        System.out.println();
        System.out.println();
        abp.remover(15);
        abp.emOrdem(raiz);
    }
}
