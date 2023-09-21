using System;
using FilaDuasPilhas;


namespace FilaDuasPilhas {
class Program {
    
    public static void Main(string[] args){
        Fila fila = new Fila(10);
        fila.Enqueue(10);
        fila.Enqueue(20);
        fila.Enqueue(30);
        fila.Enqueue(40);

        fila.PrintFila();
    }

}

}

