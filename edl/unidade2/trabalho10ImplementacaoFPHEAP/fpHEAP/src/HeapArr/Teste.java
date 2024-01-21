package HeapArr;

import NodeFP.Node;
import Item.Item;

public class Teste {
    public static void main(String[] args) {
        HeapArray hp = new HeapArray(new Node(new Item(4,4)));
        hp.insert(5);
        hp.insert(6);
        hp.insert(15);
        hp.insert(9);
        hp.insert(7);
        hp.insert(20);
        hp.insert(16);
        hp.insert(25);
        hp.insert(14);
        hp.insert(12);
        hp.insert(11);
        hp.insert(13);
        hp.print();
        
        System.out.println(hp.removeMin().getValue().value());
        hp.print();
    }
}
