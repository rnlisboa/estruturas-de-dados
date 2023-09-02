using System;

class Program{
  
  public static void Main(){
    Pilha pilha = new Pilha();

    pilha.Push(10);
    pilha.Push(20);
    pilha.Push(30);
    pilha.Push(40);
    pilha.Push(50);
    pilha.Push(60);
    Console.WriteLine(pilha);
    pilha.Pop();
    Console.WriteLine(pilha);
    pilha.Push(100);
    Console.WriteLine(pilha);
    Console.WriteLine(pilha.Peek());
  }

  class Pilha{
    public int size = 2;
    public int top = -1;
    private int[] lista = new int[2];

    public void IncreaseSize(){
      size *= 4;
      int[] novaLista = new int[size];
      int index; 
      for(index = 0; index <= top; index++){
        novaLista[index] = lista[index];
      }
      lista = novaLista;
    }

    public void Push(int v){
      bool isFull = IsFull();
      if(!isFull) IncreaseSize();
      
      top++;
      lista[top] = v;
    }

    public void Pop(){
      bool isEmpty = IsEmpty();
      if(!isEmpty) top--;
    }

    public int Peek(){
      bool isEmpty = IsEmpty();
      if(!isEmpty) return lista[top];
      return 0;
    }

    public bool IsFull(){
      if(top == size - 1) return true;
      return false;
    }

    public bool IsEmpty(){
      if(top == -1) return true;
      return false;
    }

    public override string ToString(){
      string elementos = "";
            for (int i = 0; i <= top; i++) {
                elementos += lista[i] + " ";
            }
            return elementos;
    }
    }
}