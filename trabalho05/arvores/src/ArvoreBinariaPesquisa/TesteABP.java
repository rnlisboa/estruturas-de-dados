package ArvoreBinariaPesquisa;

import Node.No;

public class TesteABP {
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
        No raiz = abp.getRaiz();
        //System.out.println(abp.profundidade(abp.node));
        //abp.remover(8);
        abp.mostrar();

        //abp.preOrdem(raiz);
    }
}
