package Arvore;

import java.util.Iterator;

import TNode.Node;

public class ArvoreSimplesTeste {
    public static void main(String[] args) {
        Arvore vSimples = new Arvore(10);
        
        Node raiz = vSimples.root();
        vSimples.addChild(raiz, 15);
        vSimples.addChild(raiz, 16);
        vSimples.addChild(raiz, 17);
        
        Iterator<Node> childrensRaiz = vSimples.root().children();
        while(childrensRaiz.hasNext()){
            Node filho = childrensRaiz.next();
            add(filho);
        }
        
        Iterator<Node> childrensRaiz2 = vSimples.root().children();
        while(childrensRaiz2.hasNext()){
            Node filho = childrensRaiz2.next();
            if(vSimples.isInternal(filho)){
                Iterator<Node> filhosDoFilho = filho.children();
                while(filhosDoFilho.hasNext()){
                    Node filhoProxNode = filhosDoFilho.next();
                    add(filhoProxNode);
                }
            }
        }
        //vSimples.preOrdem(raiz);
        System.out.println(vSimples.height());
        
    }

    public static void add(Node pai){
        Object elementoPai = pai.element();
        for(int i = 1; i <= 3; i++){
            String filho = "filho " + i + " de " + elementoPai;
           
            Node NodevoNode = new Node(pai, filho);
            pai.addChild(NodevoNode);
        }
    }
}
