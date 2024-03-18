package PilhaDuasFilas;

import FilaAux.Fila;

public class PilhaDuasFilas {
    Fila f1, f2;

    public PilhaDuasFilas(int c){
        this.f1 = new Fila(c);
        this.f2 = new Fila(c);
    }

    public Object push(Object o){
        f1.enqueue(o);
        return o;
    } 

    public Object pop(){
        Object removedF1 = new Object();
        for(int i = f1.size(); i > 0; i--){
            removedF1 = f1.dequeue();
            f2.enqueue(removedF1);
        } 

        System.out.println(f1.isEmpty());


        Object top = removedF1;
        for(int i = f2.size(); i > 0; i--){
            Object removedF2 = f2.dequeue();
            f1.ed();
            f1.enqueue(removedF2);
        }

        f1.dequeue();
        return top;
    }

    public Object top(){
        Object removedF1 = new Object();
        for(int i = f1.size(); i > 0; i--){
            removedF1 = f1.dequeue();
            f2.enqueue(removedF1);
        } 

        Object top = removedF1;
        System.out.println(f1.isEmpty());
        for(int i = f2.size(); i > 0; i--){
            Object removedF2 = f2.dequeue();
            f1.enqueue(removedF2);
        }
        return top;
    }

    public int size(){
        return this.f1.size();
    }

    public void print(){
        f1.printList();
    }
}
