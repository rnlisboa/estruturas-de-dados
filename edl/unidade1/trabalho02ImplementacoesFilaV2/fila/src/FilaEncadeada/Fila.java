package FilaEncadeada;

import FilaAux.EFilaVazia;
import NodePF.Node;

public class Fila {
    private Node inicio, fim;

    public Fila() {
    }

    public Object enqueue(Object o) {
        Node n = new Node(o);
        if (isEmpty()) {
            inicio = n;
            fim = n;
        } else {
            Node f = this.fim;
            fim = n;
            f.setProx(n);
        }
        return o;
    }

    public Object dequeue() {
        if (isEmpty())
            throw new EFilaVazia("Fila vazia");
        Node first = inicio;
        inicio = inicio.getProx();
        return first.getValue();
    }

    public Object first() {
        return this.inicio.getValue();
    }

    public boolean isEmpty() {
        return this.inicio == null;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }

        StringBuilder builder = new StringBuilder("{ ");
        Node current = inicio;

        while (current != null) {
            builder.append(current.getValue()).append(" ");
            current = current.getProx();
        }

        builder.append("}");
        return builder.toString();
    }

}
