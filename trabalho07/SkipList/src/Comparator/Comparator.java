package Comparator;

public class Comparator {
    private Object a;
    private Object b;
    
    public Comparator(Object a, Object b){
        this.a = a;
        this.b = b;
    }

    public int comparer(){
        return (int)a - (int)b;
    }
}
