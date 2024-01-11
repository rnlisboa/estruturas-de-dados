package HeapArray;

import Node.No;

public class HeapArray {
    private No[] array = new No[200];
    private int z = 1;
    private int lp;
    private int n = 200;

    public HeapArray(No no) {
        this.array[z] = no;
        lp = z;
    }

    private void increase() {
        int newN = z * 2;
        No[] newArray = new No[newN];
        for (int i = 0; i < z * 2 + 1; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
        n = newN;
    }

    public Object insert(Object e) {
        No novo = new No(e);
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
        No last = this.array[lp];
        while (pos > 1 && this.array[pos / 2] != null && (int) last.element() < (int) this.array[pos / 2].element()) {
            this.array[pos] = this.array[pos / 2];
            this.array[pos / 2] = last;
            pos = pos / 2;
            last = this.array[pos];
        }

    }

    private void downHeap() {
        int pos = 1;
        No atual = array[pos];
        while (atual != null) {
            No filhoE = this.array[pos * 2];
            No filhoD = this.array[pos * 2 + 1];
            if (filhoD != null || filhoE != null) {
                Object atualElm = atual.element();
                if ((int) atualElm > (int) filhoE.element()) {
                    this.array[pos] = filhoE;
                    this.array[pos * 2] = atual;
                    atual = this.array[pos * 2];
                    pos = pos * 2;
                } else if ((int) atualElm > (int) filhoD.element()) {
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

    public No removeMin() {
        No no = array[1];
        array[1] = array[lp];
        array[lp] = new No(0);
        downHeap();
        return no;
    }

    public void print() {
        for (int i = 1; i < this.z; i++) {
            if (this.array[i] != null)
                System.out.println(this.array[i].element() + " pai de " + this.array[2 * i].element() + " e de "
                        + this.array[2 * i + 1].element());
            else
                System.out.println(this.array[i]);
        }
    }
}
