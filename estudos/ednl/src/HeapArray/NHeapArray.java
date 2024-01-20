package HeapArray;

public class NHeapArray {
    //define o array
    private Object[] arr;
    private int capacidade = 2;
    private int indexLast = 0;
    private int index;

    public NHeapArray(Object v){
        //novo nó
        No raiz = new No(v);
        this.arr = new Object[this.capacidade];
        this.arr[this.capacidade - 1] = raiz.element();
        index = this.capacidade - 1;
        this.indexLast = index;
    }

    public void insert(No n){
        if(2*indexLast >= this.arr.length){
            int capacidadeAtual = this.capacidade;
            this.capacidade *= 2;
            Object[] novoArray = new Object[this.capacidade];
            for(int i = 1; i < capacidadeAtual; i++){
                novoArray[i] = arr[i];
                index = i;
            }
            arr = novoArray;
        }

        if(arr[2*indexLast] == null){
            arr[2*indexLast] = n.element();
            index = 2*indexLast;
        } else {
            arr[2*indexLast + 1] = n.element();
            index = 2*indexLast+1;
            indexLast++;
        }
    }

    public void mostrar(){
        for (int i = 1; i < this.arr.length; i++) {
                System.out.print(arr[i] + " "); 
        }
        System.out.println();
    }

}
