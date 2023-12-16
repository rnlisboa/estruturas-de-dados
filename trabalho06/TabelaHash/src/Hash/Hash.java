package Hash;

public class Hash {
    private int capacidade = 10;
    private Object[] array = new Object[10];
    private int size;


    public Object hash(Object v){
        return (int)v % 10;
    }

    public void insere(Object v){
        this.array[(int) hash(v)] = v;
        this.size++;
    }

    public Object busca(Object x){
        Object k;
        k = hash(x);
        if (this.array[(int)k] == x)
            return k;
        return -1;
    }

    public void print(){
        for(int i = 0; i < capacidade - 1; i++){
            System.out.println(array[i]);
        }
    }
}
