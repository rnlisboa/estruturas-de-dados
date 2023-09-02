using System;

class Program{
    public static void Main(){
        ListaLigada ll = new ListaLigada();
        
        for(int i = 0; i <= 100; i+=10){
            ll.InserirFim(i);
        }
        
        ll.RemoverFim();
        ll.RemoverFim();
        ll.RemoverFim();
        ll.RemoverFim();
        ImprimeLista(ll);
    }

    public static void ImprimeLista(ListaLigada ll){
        No? atual = ll.GetHead();
        while(atual != null){
            Console.WriteLine(atual.GetValue());
            atual = atual.GetProx();
    }
    }

    public class ListaLigada{
        private No? head;
        private No? tail;

        public int? GetHeadValue(){
            return head?.GetValue();
        }

        public int? GetTailValue(){
            return tail?.GetValue();
        }
        
        public No? GetHead(){
            return head;
        }

        public No? GetTail(){
            return tail;
        }

        public void InserirInicio(int v){
            No newNode = new No();
            newNode.SetValue(v);
            newNode.SetProx(head);
            head = newNode;
            if(tail == null)
                tail = newNode;
        }

        public void InserirFim(int v){
            No newNode = new No();
            newNode.SetValue(v);
            newNode.SetProx(null);
            tail?.SetProx(newNode);
            tail = newNode;
            if(head == null)
                head = newNode;
        }

        public void Inserir(int v, int i){

        }

        public void RemoverInicio(){
            if(head != null)
                head = head.GetProx();
        }

        public void RemoverFim(){
            No? atual = head;
            while (atual?.GetProx() != tail){
                atual = atual?.GetProx();
            }
            atual?.SetProx(null);
            tail = atual;
        }


    }

    public class No {
        private int value;
        private No? prox;

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