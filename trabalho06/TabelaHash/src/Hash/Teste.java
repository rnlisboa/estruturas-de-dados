package Hash;

public class Teste {
    public static void main(String[] args) {
        Hash tHash = new Hash();
        tHash.insere(10, "A");
        tHash.insere(15, "B");
        tHash.insere(28, "C");
        tHash.insere(28, "C");
        tHash.insere(29, "D");
        tHash.insere(28, "C");
        tHash.print();
       
    }
}
