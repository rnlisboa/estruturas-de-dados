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
        
        prb.PushVermelha(10);
        prb.PushVermelha(20);
        prb.PushVermelha(30);
        prb.PushVermelha(40);


        prb.PushPreta(40);
        prb.PushPreta(30);
        prb.PushPreta(20);
        prb.PushPreta(10);
        prb.PushPreta(40);
        Console.WriteLine(prb);
    }

    class PilhaRubroNegra {
        private int capacity = 20;
        private int[] lista = new int[20];
        PilhaPreta pp = new PilhaPreta();
        PilhaVermelha pv = new PilhaVermelha();

        public void IncreaseSizeList(){
            int newCapacity = this.capacity*=2;
            int[] newList = new int[capacity];
            int[] auxList = lista;
            bool sameSize = pp.GetSize() == pv.GetSize();
            if(sameSize){
                int topVermelha = pv.GetTop();
                for (int i = 0; i <= topVermelha; i++){
                    newList[i] = lista[i];
                }

                int topPreta = pp.GetTop();
                for (int i = capacity - 1; i >= capacity - topPreta - 1; i--){
                    newList[i] = lista[i];
                }
            }
        }
        
        public void PushVermelha(int v){
            IncreaseSizeList();
            pv.IncrementTop();
            pv.IncrementSize();
            int top = pv.GetTop();
            int size = pv.GetSize();
            lista[top] = v;
        }

        public void PushPreta(int v){
            IncreaseSizeList();
            pp.IncrementTop();
            pp.IncrementSize();
            int top = pp.GetTop();
            int size = pp.GetSize();
            lista[this.capacity - top - 1] = v;
        }

        public override string ToString(){
            string elementos = "";
            int topVermelha = pv.GetTop();
            for (int i = 0; i <= topVermelha; i++)
                elementos += lista[i] + " ";
            int topPreta = pp.GetTop();
            for (int i = capacity - 1; i >= capacity - topPreta - 1; i--)
                elementos += lista[i] + " ";
            return elementos;
        }
    }

    class PilhaVermelha {
        private int top = -1;
        private int size = 0;

        public int GetTop() {
            return top;
        }

        public void IncrementTop() {
            this.top++;
        }

        public int GetSize() {
            return size;
        }

        public void IncrementSize() {
            this.size++;
        }

}

class PilhaPreta {
    private int top = -1;
    private int size = 0;
   

    public int GetTop() {
        return top;
    }

    public void IncrementTop() {
        this.top++;
    }

    public int GetSize() {
        return size;
    }

    public void IncrementSize() {
        this.size++;
    }

}


    
}
