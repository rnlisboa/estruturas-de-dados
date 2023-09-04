using System;
// Projete uma classe que contenha duas pilhas, 
// uma “vermelha” e outra “preta” e suas operações são adaptações “coloridas” 
// das operações habituais sobre pilhas. Por exemplo, esta classe deve prover 
// uma operação de push vermelha e uma operação de push preta. Usando um ÚNICO 
// ARRAY cuja a capacidade é limitada por um tamanho N que é sempre maior do que 
// os tamanhos somados das duas pilhas. A pilha “vermelha” pode começar no início do 
// array e a pilha “preta” pode começar no final do array. Sempre que o array (que contém as duas pilhas) 
// estiver cheio utilizar a estratégia de duplicação do tamanho do array.

// OBS.: Submeter individualmente um arquivo PDF com a solução. O seu código deve estar identado, 
// colorido (cores das principais IDES) e monoespaçado.
class Program{
    public static void Main(){
        
        PilhaRubroNegra prb = new PilhaRubroNegra();
        
        while(true){
            Console.Write("Método: ");
            int ic = int.Parse(Console.ReadLine()); 
            Console.Write("Valor: ");
            int v = int.Parse(Console.ReadLine());
            if (ic == 1){
                prb.PushRed(v);
            }

            if(ic == 2){
                prb.PushBlack(v);
            }
            prb.PrintRedBlackStack();
            if(ic == 0) break;
            
        }
        
    }

    class PilhaRubroNegra {
        private int capacity = 2;
        private int[] list = new int[2];
        BlackStack pp = new BlackStack();
        RedStack pv = new RedStack();

        public void IncreaseSizeList(){
            int newCapacity = this.capacity*=2;
            int[] newList = new int[newCapacity];
            
            
            int topRed = pv.GetTop();
            for (int i = 0; i <= topRed; i++){
                newList[i] = list[i];
            }

            int topBlack = pp.GetTop();
            int lastBlack = this.capacity;
            for(int i = this.capacity - 1; i >= topBlack; i--){
                newList[lastBlack] = list[i];
                lastBlack--;
            }

            this.capacity = newCapacity;
            list = newList;
        }
        
        public void PushRed(int v){
            if(pp.GetSize() + pv.GetSize() == this.capacity){
                //IncreaseSizeList();
                Console.WriteLine("Sem espaço");
            }
            else{
                pv.IncrementTop();
                pv.IncrementSize();
                int top = pv.GetTop();
                list[top] = v;
            }
            
        }

        public void PushBlack(int v){
            if(pp.GetSize() + pv.GetSize() == this.capacity){
                //IncreaseSizeList();
                Console.WriteLine("Sem espaço");
            } else {
                pp.IncrementTop();
                pp.IncrementSize();
                int top = pp.GetTop();
            
                list[this.capacity - top - 1] = v;
            }
        }

        public void PrintRedBlackStack(){
            for(int i = 0; i < capacity; i++)
                Console.Write($"{list[i]}, ");
            Console.WriteLine();
        }

    }

    class RedStack : BaseStack {

    }

    class BlackStack : BaseStack {

    }

}

class BaseStack {
    protected int top = -1;
    protected int size = 0;

    public int GetTop(){
        return top;
    }

    public void IncrementTop(){
        this.top++;
    }

    public int GetSize(){
        return size;
    }

    public void IncrementSize(){
        this.size++;
    }
}