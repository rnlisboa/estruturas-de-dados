package Avl;

import ItemAVl.Item;
import NodeABP.NodeABP;

public class Teste {
    public static void main(String[] args) {
        Avl avl = new Avl(new Item(44, null));
        avl.incluir(new Item(17, null));
        avl.incluir(new Item(78, null));
        avl.incluir(new Item(32, null));
        avl.incluir(new Item(50, null));
        avl.incluir(new Item(88, null));
        avl.incluir(new Item(48, null));
        avl.incluir(new Item(62, null));
        NodeABP novo = avl.incluir(new Item(54, null));
        avl.showIsBalanced(novo);
        NodeABP f = avl.pesquisar(avl.getRaiz(), 17);
        avl.mostrar();

        System.out.println(avl.largerst(4));
    }
}
