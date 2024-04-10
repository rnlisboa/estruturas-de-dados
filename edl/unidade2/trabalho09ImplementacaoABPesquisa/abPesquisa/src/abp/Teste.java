package abp;

import Node.No;

public class Teste {
    public static void main(String[] args) {
        ArvBinPesquisa abp = new ArvBinPesquisa();
        No newRaiz = new No(10);
        abp.setRaiz(newRaiz);
        abp.incluir(5);
        abp.incluir(15);
        abp.incluir(2);
        abp.incluir(8);
        abp.incluir(22);
        abp.incluir(26);
        abp.incluir(21);
        abp.incluir(13);
        abp.incluir(12);
        abp.incluir(14);
        abp.remover(10);
        
        abp.mostrar();
    }
}
