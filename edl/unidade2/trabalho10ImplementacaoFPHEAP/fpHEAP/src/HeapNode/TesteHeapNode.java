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
        hNode.insert(new Item(12, "H"));
        hNode.insert(new Item(11, "S"));
        hNode.insert(new Item(8, "W"));
        hNode.emOrdem(hNode.root());
        hNode.mostrar();
        System.out.println(hNode.removeMin().element().key());
        
    }
}
