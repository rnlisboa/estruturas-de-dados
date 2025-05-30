package FilaArray;

public class FilaArray {
    private int capacity;
    private Object[] lista;
    private int head;
    private int tail;
    private int size;

    public FilaArray(int c){
        this.capacity = c;
        this.lista = new Object[c];
    }

    public void incrementSizeList() {
        int newCapacity = capacity * 2;
        Object[] novaLista = new Object[newCapacity];
        int inicio = head;

        for (int finalIndex = 0; finalIndex < size; finalIndex++) {
            novaLista[finalIndex] = lista[inicio];
            inicio = (inicio + 1) % lista.length;
        }

        tail = size;
        head = 0;
        capacity = newCapacity;
        lista = novaLista;
    }

    public void enqueue(Object v) {
        if (isFull()) {
            incrementSizeList();
        }
        lista[tail] = v;
        tail = (tail + 1) % lista.length;
        size++;
    }

    public Object dequeue() throws EFilaVazia {
        if (isEmpty()) throw new EFilaVazia("Fila vazia.");
        Object n = lista[head];
        head++;
        return n;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public Object first() {
        return lista[head];
    }

    public int size() {
        return size;
    }

    public void printList() {
        for (int i = 0; i <= lista.length - 1; i++) {
            System.out.print(lista[i] + ", ");
        }
        System.out.println();
    }
}


