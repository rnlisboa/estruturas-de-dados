using System;
using pilhaEncadeada;

namespace pilhaEncadeada{
class Program{
    static void Main(string[] args){
        PilhaLL pilha = new PilhaLL();

        for(int i = 0; i <= 100; i+=10)
            pilha.Push(i);
        
        ImprimeLista(pilha);

        pilha.Pop();
        ImprimeLista(pilha);
        Console.WriteLine($"top: {pilha.GetTop()}");
    }

    public static void ImprimeLista(PilhaLL ll){
        No atual = ll.GetHead();
        while(atual != null){
            Console.Write($"{atual.GetValue()}, ");
            atual = atual.GetProx();
        }
        Console.WriteLine();
    }
}
}



