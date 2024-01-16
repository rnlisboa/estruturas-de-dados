package PilhaRubroNegra;

public class PilhaRubroNegra {
    private int capacity;
    private Object[] arr;
    private int redTop = -1;
    private int redSize = 0;
    private int blackTop = 2;
    private int blackSize = 0;

    public PilhaRubroNegra(int c) {
        this.capacity = c;
        this.arr = new Object[c];
    }

    public void increase() {
        int newCapacity = this.capacity * 2;
        Object[] newList = new Object[newCapacity];
        int redTop = this.redTop;
        for (int i = 0; i <= redTop; i++) {
            newList[i] = arr[i];
        }
        int j = newCapacity - 1;

        for (int i = this.capacity - 1; i >= this.blackTop; i--) {
            newList[j--] = arr[i];
        }
        this.capacity = newCapacity;
        this.blackTop = j + 1;
        this.arr = newList;
    }

    public void pushRed(Object o) {
        if (isListFull())
            increase();
        this.redTop++;
        this.redSize++;
        arr[this.redTop] = o;
    }

    public void pushBlack(Object o) {
        if (isListFull())
            increase();
        this.blackSize++;
        this.blackTop--;
        arr[this.blackTop] = o;
    }

    public boolean isListFull() {
        return this.blackSize + this.redSize == arr.length;
    }

    public int sizeRed() {
        return this.blackSize;
    }

    public int sizeBlack() {
        return this.blackSize;
    }

    public boolean isRedStackEmpty() {
        return this.redTop == -1;
    }

    public boolean isBlackStackEmpty() {
        return this.blackTop == arr.length - 1;
    }

    public void PopRed() {
        if (isRedStackEmpty())
            throw new EPilhaVazia("Operação inválida: pilha vazia");
        this.redTop--;
    }

    public void PopBlack() {
        if (isBlackStackEmpty())
            throw new EPilhaVazia("Operação inválida: pilha vazia");
        this.blackTop++;
    }

    public Object topRed() {
        if (isRedStackEmpty())
            throw new EPilhaVazia("Operação inválida: pilha vazia");
        return this.arr[this.redTop];
    }

    public Object topBlack() {
        if (isBlackStackEmpty())
            throw new EPilhaVazia("Operação inválida: pilha vazia");
        return this.arr[this.blackTop];
    }

    public void printRedBlackStack() {
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print("}");
        System.out.println();
    }

}
