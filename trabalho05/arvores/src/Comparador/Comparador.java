package Comparador;

public class Comparador {
    private int a;
    private int b;
    
    public Comparador(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int comparer(){
        return a - b;
    }
}
