package FilaArray;

public class Teste {
    public static void main(String[] args) {
        FilaArray fila = new FilaArray(2);

        fila.enqueue(1);
        fila.enqueue(2);
        fila.enqueue(3);
        fila.enqueue(4);
        fila.enqueue(5);
        fila.enqueue(6);
        fila.enqueue(7);
        fila.enqueue(1);
        fila.enqueue(2);
        fila.enqueue(3);
        fila.enqueue(4);
        fila.enqueue(5);
        fila.enqueue(6);
        fila.enqueue(7);

        fila.dequeue();
        fila.printList();
    }
}
