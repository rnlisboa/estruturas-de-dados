using System;

//operação enqueue: incrementa tail, head permanece
//operação dequeue: incrementa head, tail permanece
//operação clean:   limpa fila
//head inicia em 0

class Program{
    public static void Main(){
        Queue fila = new Queue();

        fila.Enqueue(10);
        fila.Enqueue(20);
        fila.Enqueue(30);
        fila.Enqueue(40);
        Console.WriteLine(fila);
        fila.Dequeue();
        Console.WriteLine(fila);
        Console.WriteLine(fila);
        fila.Enqueue(10);
        fila.Enqueue(20);
        fila.Enqueue(30);
        fila.Enqueue(40);
        Console.WriteLine(fila);
        fila.Dequeue();
        Console.WriteLine(fila);
    }

    class Queue{
        private int head;
        private int tail;
        private int size = 2;
        private int[] fila = new int[2];

        public void IncreaseSize(){
            size*=4;
            
            fila = novafila;
        }
        
        public void Enqueue(int value){
            if(tail == size)
                IncreaseSize();
            fila[tail] = value;
            tail++;
        }

        public int First(){
            return fila[head];
        }

        public void Dequeue(){
            if (head < tail){
                fila[head] = 0;
                head++;
            }
        }

        public void Clear(){
            for(int i = 0; i < tail - 1; i++){
                fila[i] = 0;
            }

            head = 0;
            tail = 0;
        }

        public override string ToString(){
            string elementos = "";
            for (int i = 0; i <= tail - 1; i++) {
                elementos += fila[i] + " ";
            }
            return elementos;
    }

    }


}