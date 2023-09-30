using System;

class Program{
    public static void Main(){
        FilaLL fila = new FilaLL();
        fila.Enqueue(10);
        fila.Enqueue(20);
        fila.Enqueue(10);
        fila.Enqueue(20);
        fila.Enqueue(10);
        fila.Enqueue(20);

        fila.Dequeue();

        fila.PrintList();

    }

    class FilaLL{
        private No head;
        private No tail;

        private int size;
        
        public void Enqueue(object v){
            No no = new No();
            
            no.SetValue(v);
            if(tail == null){
                head = no;
            } else{
                tail.SetProx(no);
            }
            no.SetProx(null);
            tail = no;
            size++;

        }

        public object Dequeue(){
            object sai = head.GetValue();
            if(IsEmpty()) throw new EFilaVazia("Operação inválida. Fila vazia!")
            head = head.GetProx();

            return sai;
        }

        public void PrintList(){
            No current = head;
            while(current != null){
                Console.WriteLine(current.GetValue());
                current = current.GetProx();
            }
        }

        public int Size(){
            return size;
        }

        public bool IsEmpty(){
            bool isEmpty = head == null;
            return isEmpty;
        }
    }

    class No {
        private object value;
        private No prox;

        public void SetValue(object v){
            value = v;
        }

        public object GetValue(){
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

class EFilaVazia : Exception {
 
  public EFilaVazia(string message) : base(message) {
   
  }
  public EFilaVazia(string message, Exception innerException) : base(message, innerException) { }
}