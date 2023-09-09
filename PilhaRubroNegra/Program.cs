using System;

class Program{
    public static void Main(){
        
        PilhaRubroNegra prb = new PilhaRubroNegra();
        
        prb.PushRed(10);
        prb.PushBlack(80);
        prb.PushRed(20);
        prb.PushBlack(70);
        prb.PushRed(30);
        prb.PushBlack(60);
        prb.PushBlack(50);
        prb.PushRed(40);
        prb.PushRed(50);

        prb.PrintRedBlackStack();
    }

    class PilhaRubroNegra {
        private int capacity = 2;
        private int[] list = new int[2];
        private int redTop = -1;
        private int redSize=0;
        private int blackTop = 2;
        private int blackSize=0;
        

        public void IncreaseSizeList(){
            int newCapacity = this.capacity*2;
            int[] newList = new int[newCapacity];
            int redTop = this.redTop;
            for (int i = 0; i <= redTop; i++){ 
                newList[i] = list[i]; 
            } 
            int j = newCapacity - 1;
  
            for(int i = this.capacity - 1; i >= this.blackTop; i--){
                newList[j--] = list[i];
            }
            this.capacity = newCapacity;
            this.blackTop = j + 1;
            this.list = newList;
        }
        
        public void PushRed(int v){   
            if(IsListFull()) 
                IncreaseSizeList();
            this.redTop++;
            this.redSize++;
            list[this.redTop] = v;      
        }


        public void PushBlack(int v){       
            if(IsListFull()) 
                IncreaseSizeList(); 
            this.blackSize++;
            this.blackTop--;
            list[this.blackTop] = v;            
        }

        public void PopRed(){
            if(IsRedStackEmpty()) throw new EPilhaVazia("Operação inválida: pilha vazia");
            this.redTop--;
        }

        public void PopBlack(){
            if(IsBlackStackEmpty()) throw new EPilhaVazia("Operação inválida: pilha vazia");
            this.blackTop++;
        }

        public int SizeRed(){
            return this.blackSize;
        } 

        public int SizeBlack(){
            return this.blackSize;
        }

        public bool IsRedStackEmpty(){
            return this.redTop == -1;
        }

        public bool IsBlackStackEmpty(){
            return this.blackTop == list.Length - 1;
        }

        public int TopRed(){
            if(IsRedStackEmpty()) throw new EPilhaVazia("Operação inválida: pilha vazia");
            return this.redTop;
        }

        public int TopBlack(){
            if(IsBlackStackEmpty()) throw new EPilhaVazia("Operação inválida: pilha vazia");
            return this.blackTop;
        }

        public bool IsListFull(){
            return this.blackSize + this.redSize == list.Length;
        }

        public void PrintRedBlackStack(){
            for(int i = 0; i < list.Length; i++)
                Console.Write($"{list[i]}, ");
            Console.WriteLine();
        }
    }
}

class EPilhaVazia : Exception {
 
  public EPilhaVazia(string message) : base(message) {
   
  }
  public EPilhaVazia(string message, Exception innerException) : base(message, innerException) { }
}