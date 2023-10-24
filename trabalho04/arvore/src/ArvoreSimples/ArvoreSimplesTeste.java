package ArvoreSimples;

import java.util.Iterator;

import No.No;

public class ArvoreSimplesTeste {
    public static void main(String[] args) {
        ArvoreSimples vSimples = new ArvoreSimples(10);
        No raiz = vSimples.root();
        vSimples.addChild(raiz, 15);
        vSimples.addChild(raiz, 16);
        vSimples.addChild(raiz, 17);
        Iterator<No> childrensRaiz = vSimples.root().children();
        
        while(childrensRaiz.hasNext()){
            No filho = childrensRaiz.next();
            System.out.println(filho.element());
        }
    }
}
