package HeapArr;

import Comparador.Comparador;
import Item.Item;
import NodeFP.Node;

public class HeapArray {
    private Node[] array = new Node[200];
    private int z = 1;
    private int lp;
    private int n = 200;
    private Comparador comp;

    public HeapArray(Node no) {
        this.array[z] = no;
        lp = z;
    }

    private void increase() {
        int newN = z * 2;
        Node[] newArray = new Node[newN];
        for (int i = 0; i < z * 2 + 1; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
        n = newN;
    }

    public Object insert(Object e) {
        Node novo = new Node(new Item(e, e));
        if (this.array[2 * z] == null) {
            if (2 * z >= n)
                increase();
            upheap();
            this.array[2 * z] = novo;
            lp = 2 * z;
        } else {
            if (2 * z + 1 >= n)
                increase();
            this.array[2 * z + 1] = novo;
            lp = 2 * z + 1;
            upheap();
            z++;
        }
        return novo;
    }

    private void upheap() {
        int pos = lp;
        Node last = this.array[lp];
        this.comp = new Comparador(last.getValue().key(), this.array[pos / 2].getValue().key());
        int comparado = this.comp.comparer();
        while (pos > 1 && this.array[pos / 2] != null && comparado > 0) {
            this.array[pos] = this.array[pos / 2];
            this.array[pos / 2] = last;
            pos = pos / 2;
            last = this.array[pos];
        }
    }

    private void downHeap() {
        int pos = 1;
        Node atual = array[pos];
        while (atual != null) {
            Node filhoE = this.array[pos * 2];
            Node filhoD = this.array[pos * 2 + 1];
            if (filhoD != null || filhoE != null) {
    
                this.comp = new Comparador(atual.getValue().key(), filhoE.getValue().key());
                int comparado = this.comp.comparer();
                if (comparado > 0) {
                    this.array[pos] = filhoE;
                    this.array[pos * 2] = atual;
                    atual = this.array[pos * 2];
                    pos = pos * 2;
                } 
                this.comp = new Comparador(atual.getValue().key(), filhoD.getValue().key());
                comparado = this.comp.comparer();
                if (comparado > 0) {
                    this.array[pos] = filhoD;
                    this.array[pos * 2 + 1] = atual;
                    atual = this.array[pos * 2 + 1];
                    pos = pos * 2 + 1;
                }
            } else {
                break;
            }
        }
    }

    public Node removeMin() {
        Node no = array[1];
        array[1] = array[lp];
        array[lp] = new Node(new Item(0, 0));
        downHeap();
        return no;
    }

    public void print() {
        for (int i = 1; i < this.z; i++) {
            if (this.array[i] != null)
                System.out.println(this.array[i].getValue().value() + " pai de " + this.array[2 * i].getValue().value() + " e de "
                        + this.array[2 * i + 1].getValue().value());
            else
                System.out.println(this.array[i]);
        }
    }
}
