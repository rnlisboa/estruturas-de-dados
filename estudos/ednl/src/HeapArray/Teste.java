package HeapArray;

public class Teste {
    public static void main(String[] args) {
        NHeapArray hp = new NHeapArray(100);
        hp.insert(new No(90));
        hp.mostrar();
    }
}
