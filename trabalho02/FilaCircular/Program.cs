using System;
using FilaCircular;

namespace FilaCircular{
    class Program {
    public static void Main(string[] args){
        Fila fila = new Fila();
        fila.Enqueue(1);
        fila.Enqueue(2);
        fila.Enqueue(3);
        fila.Enqueue(4);
        fila.Enqueue(5);
        fila.Enqueue(6);
        fila.Enqueue(7);
        fila.Enqueue(1);
        fila.Enqueue(2);
        fila.Enqueue(3);
        fila.Enqueue(4);
        fila.Enqueue(5);
        fila.Enqueue(6);
        fila.Enqueue(7);

        fila.Dequeue();
        fila.PrintList();
    }
}
}
