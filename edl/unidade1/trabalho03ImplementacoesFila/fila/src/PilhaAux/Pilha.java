package PilhaAux;

public class Pilha {
    private int tamanho;
    private Object[] arr;
    private int top;
    private int size;

    public Pilha(int t){
        this.tamanho = t;
        this.arr = new Object[t];
        this.top = -1;
    }

    private void increase(){
        if(this.top == this.arr.length - 1){
            int t = 2*this.tamanho;
            Object[] n = new Object[t];
            for(int i = 0; i <= this.top; i++){
                n[i] = this.arr[i];
            }
            this.tamanho = t;
            this.arr = n;
        }

    }

    public Object push(Object o){
        increase();
        this.top++;
        this.arr[this.top] = o;
        this.size++;
        return o;
    }

    public Object pop(){
        Object remv = this.arr[this.top];
        this.top--;
        this.size--;
        return remv;
    }

    public Object top(){
        return this.arr[top];
    }

    public int size(){
        return this.size;
    }


    public void print(){
        System.out.println();
        System.out.print("{");
        for(int i = 0; i < this.size; i++){
            System.out.print(this.arr[i] + ", ");
        }
        System.out.print("}");
        System.out.println();
    }
}
