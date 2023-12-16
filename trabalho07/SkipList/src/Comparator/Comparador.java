package Comparator;

public class Comparador {
    private Object a;
    private Object b;
    
    public Comparador(Object a, Object b){
        this.a = a;
        this.b = b;
    }

    public int comparer(){
        return (int)a - (int)b;
    }
}
