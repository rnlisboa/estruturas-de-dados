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
    public void insert(Item item) {
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

   

    @Override
    public void removeMin() {
        Node min = this.min();
        Node proxMin = min.getNext();
        Node prevMin = min.getPrev();
        proxMin.setPrev(prevMin);
        prevMin.setNext(min.getNext());
        this.size--;
    }

    @Override
    public Node min() {
        Node min = this.head.getNext();
        Node atual = this.head.getNext();
        while(!atual.getNext().equals(this.tail)){
            this.comp = new Comparador(atual.getNext().getValue().key(), min.getValue().key());
            int comparado = this.comp.comparer();
            if(comparado < 0) min = atual;
            atual = atual.getNext();
        }
        return min;
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
        System.out.println();
    }


}
