package TabelaHash;

public class TestHashTable {
    public static void main(String[] args) {
        TabelaHash tabelaHash = new TabelaHash();

        tabelaHash.insert(new Item(1, "A"));
        tabelaHash.insert(new Item(2, "B"));
        tabelaHash.insert(new Item(3, "C"));
        tabelaHash.insert(new Item(4, "D"));
        tabelaHash.insert(new Item(5, "E"));
        tabelaHash.insert(new Item(8, "F"));

        tabelaHash.printHashTable();
        
        System.out.println();
        System.out.println(tabelaHash.findElement(8));
        tabelaHash.removeElement(15);
        
        tabelaHash.printHashTable();
    }
}
