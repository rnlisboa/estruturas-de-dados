package Teste;

import Teste.No;

public class testeHeap<t> {
    private t[] arr;
    private int tam = 2;
    private int c=0;
    private int index;
    

    public testeHeap(t value) {
        No<t> root = new No<t>(value);
        this.arr = (t[]) new Object[this.tam];
        arr[this.tam-1] = root.getValue(); 
        index = this.tam - 1;
        this.c = index;
    }
    
    
    public void insert(No<t> valor) {
        if(2*c >= this.arr.length){
            int k = this.tam;
            this.tam *=2;
            t[] novo = (t[]) new Object[this.tam];
            for (int i = 1; i < k; i++) {
                novo[i] = arr[i];
                index = i;
            }
            arr = novo;
        }
        
        if(arr[2*c] == null){
            arr[2*c] = valor.getValue();
            index=2*c;
            upHeap();
        }else{
            arr[2*c + 1] = valor.getValue();
            index = 2*c+1;
            upHeap();
            c++; 
        }
    }
    
    private void upHeap(){
        int k = index;
        int k1 = index-1;
        while (k>1&&k1>1) {
            if((int)arr[k]>(int)arr[k/2]){
                t aux = arr[k/2];
                arr[k/2] = arr[k];
                      arr[k]=aux;
                      k/=2; 
            }else{
                if((int)arr[k1]>(int)arr[k1/2]){
                    t aux = arr[k1/2];
                    arr[k1/2] = arr[k1];
                    arr[k1] = aux;
                    k1/=2;   
                }else{
                    break;
                }
            }
        }
        
        
    }

    
    public void mostrar(){
        for (int i = 1; i < this.arr.length; i++) {
                System.out.print(arr[i] + " "); 
        }
        System.out.println();
    }

    
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    
    public t min() {
        // TODO Auto-generated method stub
        return arr[index];
    }
    
    
    public void removeMin() {
        // TODO Auto-generated method stub
        arr[index] = null;
        if(arr[index-1]==null){
            index/=2;
        }else{
            index--;
        }
    }
    
    
    public int size() {
        // TODO Auto-generated method stub
        return this.tam;
    }

    public int altura(No<t> node){
        int height = 1;
        for (int i = 1; i < arr.length; i*=2) {
           if(arr[i] != null){
               height += 1;
            }
        } 
        return height;
    }  
    
    public int getIndex() {
        return index;
    }
    
    public void setIndex(int index) {
        this.index = index;
    }
}
