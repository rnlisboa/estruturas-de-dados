package HashTable;

public class Teste {
    public static void main(String[] args) {
        HashTable hTable = new HashTable();
        hTable.insere(10, "A");
        hTable.insere(15, "B");
        hTable.insere(28, "C");
        hTable.insere(27, "C");
        hTable.insere(29, "D");
        hTable.insere(28, "C");
        hTable.print();

        System.out.println(hTable.busca(29));

        hTable.remove(27);
        hTable.print();
    }
}
