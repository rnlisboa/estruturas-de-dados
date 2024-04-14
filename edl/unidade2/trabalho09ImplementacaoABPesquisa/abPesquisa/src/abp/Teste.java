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
        abp.mostrar();

        ArvBinPesquisa abp2 = new ArvBinPesquisa();
        abp2.setRaiz(new No(10));
        abp2.incluir(5);
        abp2.incluir(15);
        abp2.incluir(2);
        abp2.incluir(8);
        abp2.incluir(22);
        abp2.incluir(27);
        abp2.incluir(35);
        abp2.incluir(4);
        abp2.incluir(1);
        abp2.incluir(9);
        //abp2.mostrar();             
        abp2.mostrar();                         
        System.out.println("###### AUB #######");
        ArvBinPesquisa ab = unir(abp, abp2);
        ab.mostrar();
    }

    public static ArvBinPesquisa unir(ArvBinPesquisa ab1, ArvBinPesquisa ab2) {
        ArvBinPesquisa aub = uneab(ab1, ab2);
        return aub;
    }

    public static ArvBinPesquisa uneab(ArvBinPesquisa ab1, ArvBinPesquisa ab2) {
        if(ab2.isEmpty()) return ab1;
        Object ins = ab2.remover(ab2.getRaiz().element());
        ab1.incluir(ins);
        return uneab(ab1, ab2);
    }
}
