using System;


class Program{
    static void Main(string[] args){
        PilhaLL pilha = new PilhaLL();

        for(int i = 0; i <= 100; i+=10)
            pilha.Push(i);
        
        ImprimeLista(pilha);

        pilha.Pop();
        ImprimeLista(pilha);
        Console.WriteLine(pilha.GetTop());
    }

    public static void ImprimeLista(PilhaLL ll){
        No atual = ll.GetHead();
        while(atual != null){
            Console.Write($"{atual.GetValue()}, ");
            atual = atual.GetProx();
        }
        Console.WriteLine();
    }

    public class PilhaLL{
        private No head;
        private No tail;

        public void Push(int v){
            No newNo = new No();
            newNo.SetValue(v);
            newNo.SetProx(this.head);
            this.head = newNo;
        }

        public void Pop(){
            No lastHead = this.head;
            this.head = lastHead.GetProx();
        }

        public int Peek(){
            return 0;
        }

        public No GetHead(){
            return this.head;
        }

        public int GetTop(){
            return this.head.GetValue();
        }
    }

    public class No {
        private int value;
        private No prox;

        public void SetValue(int v){
            value = v;
        }

        public int GetValue(){
            return value;
        }

        public void SetProx(No? v){
            prox = v;
        }

        public No? GetProx(){
            return prox;
        }

    }
}

