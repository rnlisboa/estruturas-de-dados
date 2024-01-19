package FilaPrioridade;

import Comparador.Comparador;
import Interfaces.IFilaPrioridade;
import Item.Item;
import NodeFP.Node;

public class FilaPrioridade implements IFilaPrioridade {
    private Node head = new Node(null);
    private Node tail = new Node(null);;
    private Comparador comp;
    private int size;

    public FilaPrioridade() {
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
        this.size = 0;
    }

    @Override
    public void insert(Object key, Object value) {
        Item item = new Item(key, value);
        Node node = new Node(item);
        if (this.head.getNext().equals(this.tail)) {
            this.head.setNext(node);
            node.setPrev(this.head);
            this.tail.setPrev(node);
            node.setNext(this.tail);
        } else {
            Node prevFim = this.tail.getPrev();
            node.setNext(this.tail);
            node.setPrev(prevFim);
            prevFim.setNext(node);
            this.tail.setPrev(node);
        }

        this.size++;
    }

    private Node setAtributes(Node node, Node next, Node prev) {
        prev.setNext(node);
        node.setPrev(prev);
        next.setPrev(node);
        node.setNext(next);
        return node;
    }

    @Override
    public Item removeMin() {
        Node min = this.head.getNext();
        Node atual = this.head.getNext();
        while (!atual.equals(this.tail)) {
            this.comp = new Comparador(atual, atual.getNext());
            int comparado = this.comp.comparer();
            if (comparado > 0) {
                min = atual;
            } else if (comparado == 0) {
                min = atual;
            } else {
                min = atual.getNext();
            }
            atual = atual.getNext();
        }
        setAtributes(min.getNext(), min.getNext(), min.getPrev());
        this.size--;
        return min.getValue();
    }

    @Override
    public Item min() {
        Node min = this.head.getNext();
        Node atual = this.head.getNext();
        while (!atual.equals(this.tail)) {
            this.comp = new Comparador(atual.getValue().key(), atual.getNext().getValue().key());
            int comparado = this.comp.comparer();
            if (comparado > 0) {
                min = atual;
            } else if (comparado == 0) {
                min = atual;
            } else {
                min = atual.getNext();
            }
            atual = atual.getNext();
        }
        return min.getValue();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    public void print() {
        System.out.print("[ ");
        Node atual = this.head.getNext();
        while (!atual.equals(this.tail)) {
            System.out.print("{ " + atual.getValue().key() + ": " + atual.getValue().value() + " } ");
            atual = atual.getNext();
        }
        System.out.print("]");
    }

}
