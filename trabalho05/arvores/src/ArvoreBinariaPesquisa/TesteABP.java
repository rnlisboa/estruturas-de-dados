package ArvoreBinariaPesquisa;

import java.util.Iterator;;

import Node.No;

public class TesteABP {
    public static void main(String[] args) {
        ArvoreBinariaPesquisa abp = new ArvoreBinariaPesquisa(15);
        abp.incluir(6);
        abp.incluir(2);
        abp.incluir(9);
        abp.incluir(7);
        abp.incluir(10);
        abp.incluir(8);
        abp.incluir(45);
        abp.incluir(25);
        No raiz = abp.getRaiz();
        //abp.emOrdem(raiz);

    }
}
