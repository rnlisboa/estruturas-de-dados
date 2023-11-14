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
            add(filho);
        }
        
        Iterator<No> childrensRaiz2 = vSimples.root().children();
        while(childrensRaiz2.hasNext()){
            No filho = childrensRaiz2.next();
            if(vSimples.isInternal(filho)){
                Iterator<No> filhosDoFilho = filho.children();
                while(filhosDoFilho.hasNext()){
                    No filhoProxNo = filhosDoFilho.next();
                    add(filhoProxNo);
                }
            }
        }
        //vSimples.preOrdem(raiz);

        
    }

    public static void add(No pai){
        Object elementoPai = pai.element();
        for(int i = 1; i <= 3; i++){
            String filho = "filho " + i + " de " + elementoPai;
           
            No novoNo = new No(pai, filho);
            pai.addChild(novoNo);
        }
    }
}