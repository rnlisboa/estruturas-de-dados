package FilaPrioridade;

import Item.Item;

public class Teste {
    public static void main(String[] args) {
        FilaPrioridade fp = new FilaPrioridade();
        fp.insert(new Item(10, "A"));
        fp.insert(new Item(30, "B"));
        fp.insert(new Item(2, "C"));
        fp.insert(new Item(25, "D"));
        fp.insert(new Item(16, "E"));
        fp.print();
        System.out.println(fp.min().getValue().key());
        fp.removeMin();
        fp.print();
        System.out.println(fp.min().getValue().key());
    }

}
