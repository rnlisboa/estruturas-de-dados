package ArvoreBinariaPesquisa;

import Node.No;

public class TesteABP {
    public static void main(String[] args) {
        ArvoreBinariaPesquisa abp = new ArvoreBinariaPesquisa();
        No newRaiz = new No(15);
        abp.setRaiz(newRaiz);
        abp.incluir(6);
        abp.incluir(45);
        abp.incluir(2);
        abp.incluir(9);
        abp.incluir(7);
        abp.incluir(10);
        abp.incluir(8);
        abp.incluir(1);
        abp.incluir(11);
        abp.incluir(25);
        No raiz = abp.getRaiz();
        //System.out.println(abp.profundidade(abp.node));
        abp.emOrdem(raiz);
        System.out.println();
        abp.remover(9);
        abp.emOrdem(raiz);
        
    }
}
