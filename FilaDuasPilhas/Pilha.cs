using System;

class Pilha{
    private int top;
    private int[] lista;
    public Pilha(int tamanho){
        top = -1;
        lista = new int[tamanho];
    }
    public void Push(int value){
        this.top++;
        Console.WriteLine($"{value} inserido em {top}");
        this.lista[top] = value;
    }

    public object Pop(){
        object ultimoTop = lista[top];
        top--;
        return ultimoTop;
    }
    
    public void PrintPilha(){
        if(top != - 1){
            for(int i = 0; i <= top; i++){
                Console.Write($"{this.lista[i]}, ");
            }
            Console.WriteLine();
        }
        
    }

    }