package FilaEncadeada;

public class Teste {
    public static void main(String[] args) {
        Fila f = new Fila();
        f.enqueue(10);
        f.enqueue(20);
        f.enqueue(30);
        f.enqueue(40);
        f.enqueue(50);
        System.out.println(f);
        f.dequeue();
        System.out.println(f);
    }
}
