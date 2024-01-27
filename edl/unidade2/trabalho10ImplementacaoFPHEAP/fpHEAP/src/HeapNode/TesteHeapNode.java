package HeapNode;

import Item.Item;

public class TesteHeapNode {
    public static void main(String[] args) {
        HeapNode hNode = new HeapNode(new Item(4, "C"));
        hNode.insert(new Item(5, "A"));
        hNode.insert(new Item(6, "Z"));
        hNode.insert(new Item(15, "K"));
        hNode.insert(new Item(9, "F"));
        hNode.insert(new Item(7, "Q"));
        hNode.insert(new Item(20, "B"));
        hNode.insert(new Item(16, "X"));
        hNode.insert(new Item(25, "J"));
        hNode.insert(new Item(14, "E"));
        hNode.mostrar();
        System.out.println("Removido: " + hNode.removeMin().key());

        hNode.mostrar();
        System.out.println("Ultimo nó agora é " + hNode.getLastNode().element().key());
        System.out.println(hNode.root().element().key());
        System.out.println("Removido: " + hNode.removeMin().key());

        hNode.mostrar();
        //System.out.println(hNode.getLastNode().element().key());
    }
}
