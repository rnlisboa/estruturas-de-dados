package Hash;

public class Teste {
    public static void main(String[] args) {
        Hash tHash = new Hash();
        tHash.insere(10);
        tHash.insere(15);
        // tHash.insere(25);
         tHash.insere(48);
        tHash.print();
        System.out.println(tHash.busca(48));
    }
}
