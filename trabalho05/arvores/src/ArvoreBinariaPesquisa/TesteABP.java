package ArvoreBinariaPesquisa;

import Node.No;

public class TesteABP {
    public static void main(String[] args) {
        ArvoreBinariaPesquisa abp = new ArvoreBinariaPesquisa(10);
        abp.incluir(5);
        abp.incluir(15);
        abp.incluir(2);
        abp.incluir(22);
        abp.incluir(8);
        abp.incluir(25);
        abp.incluir(1);   
        abp.incluir(3);
        No raiz = abp.getRaiz();
        abp.emOrdem(raiz);

        System.out.println(abp.remover(5));
        abp.emOrdem(raiz);
    }
}
