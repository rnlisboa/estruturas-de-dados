using System;


class Fila {

    private int head;
    private int tail;
    private Pilha pilha;

    public Fila(int tamanho){
        pilha = new Pilha(tamanho);
        head = 0;
        tail = 0;
    }
    public void Enqueue(int v){
        tail++;
        pilha.Push(v);
    }

    public void Dequeue(){
        head++;
    }

    public void PrintFila(){
        pilha.PrintPilha();
    }

}
