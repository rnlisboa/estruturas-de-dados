using System;

class Fila {
    private int capacity = 2;
    private object[] lista = new object[2];
    private int head;
    private int tail;
    private int size;

    public void IncrementSizeList() {
        int newCapacity = capacity * 2;
        object[] novaLista = new object[newCapacity];
        int inicio = head;

        for (int final = 0; final < size; final++) {
            novaLista[final] = lista[inicio];
            inicio = (inicio + 1) % lista.Length;
        }

        tail = size;
        head = 0;
        capacity = newCapacity;
        lista = novaLista;
    }

    public void Enqueue(object v){
        if(IsFull()){
            IncrementSizeList();
        }
        lista[tail] = v;
        tail = (tail + 1) % lista.Length;
        size++;
    }

    public object Dequeue(){
        if(IsEmpty()) throw new EFilaVazia("Fila vazia.");
        object n = lista[head];
        head++;
        return n;
    }

    public bool IsEmpty(){
        return head == tail;
    }

    public bool IsFull(){
        bool isFull = false;
        if(size == capacity) isFull=true;
        return isFull;
    }

    public object First(){
        return lista[head];
    }

    public int Size(){
        return size;
    }

    public void PrintList(){
        for(int i=0; i <= lista.Length - 1; i++){
            Console.Write($"{lista[i]}, ");
        }
        Console.WriteLine();
    }
}


class EFilaVazia : Exception {
 
  public EFilaVazia(string message) : base(message) {
   
  }
  public EFilaVazia(string message, Exception innerException) : base(message, innerException) { }
}