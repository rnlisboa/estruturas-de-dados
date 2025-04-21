package Comparador;

public class Comparador {
    private Object a,b;

    public Comparador (Object a, Object b){
        this.a = a;
        this.b = b;
    }

    public Object compare(){
        if((int)this.a >= (int)this.b) return this.a;
        return b;
    }
}