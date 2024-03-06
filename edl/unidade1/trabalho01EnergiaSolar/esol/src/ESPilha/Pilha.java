package ESPilha;

public class Pilha implements IPilha {
    private Object[] p;
    private int capacity;
    private int size;
    private int t;

    public Pilha(int c){
        this.capacity = c;
        this.p = new Object[c];
        this.t = -1;
    }

    public void increase(){
        if(this.size == this.t+1){
            int nc = 2*this.capacity;
            Object[] np = new Object[nc];
            for(int i=0; i<= this.t; i++){
                np[i] = p[i];
            }
            this.capacity = nc;
            this.p = np;
        }
    }

    public void decrease(){
        int nc = this.capacity / 2;
        Object[] np = new Object[nc];
        for(int i =0; i <= this.t; i++){
            np[i] = p[i];
        }
        this.capacity = nc;
        this.p = np;
    }
    @Override
    public Object top() {
        if(isEmpty()) throw new EPilhaVazia("Pilha vazia");
        return this.p[this.t];
    }

    @Override
    public Object pop() {
        if(isEmpty()) throw new EPilhaVazia("Pilha vazia");
        if(isFourth()) decrease();
        Object o = this.p[this.t];
        t--;
        size--;
        return o;
    }

    @Override
    public Object push(Object o) {
        increase();
        t++;
        this.p[t] = o;
        size++;
        return o;
    }

    @Override
    public int size() {
        return this.t + 1;
    }

    @Override
    public boolean isEmpty() {
        return this.t == -1;
    }
    
    private boolean isFourth(){
        boolean f = size() == this.capacity * 0.25;
        return f;
    }

}
