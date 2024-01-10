package HeapArray;

import Node.No;

public class Teste {
    public static void main(String[] args) {
        HeapArray hp = new HeapArray(new No(4));
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
        hp.insert(8);
        hp.insert(2);
        //hp.print();
        
        System.out.println(hp.removeMin().element());
        hp.print();
    }
}
