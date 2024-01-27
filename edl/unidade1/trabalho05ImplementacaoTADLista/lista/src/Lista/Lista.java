package Lista;

import Exceptions.EListaVazia;
import Exceptions.ENotFoundInList;
import Interfaces.ILista;

public class Lista implements ILista {
    private int capacity = 2;
    private int arraySize;
    private Object[] lista = new Object[2];
    
    public void increaseList(){
        int newCapacity = capacity*2;
        Object[] newList = new Object[newCapacity];
        for(int i = 0; i < arraySize; i++){
            newList[i] = lista[i];
        }
        capacity = newCapacity;
        lista = newList;
    }

    @Override
    public Object first() {
        if(arraySize == 0) throw new EListaVazia("Lista vazia");
        return lista[0];
    }
    
    @Override
    public Object last() {
        if(arraySize == 0) throw new EListaVazia("Lista vazia");
        return lista[arraySize-1];
    }
    
    @Override
    public Object before(Object p) {
        int indexp = indexOf(p);
        if(indexp == -1) throw new ENotFoundInList("Elemento não consta na lista");
        if(indexp == 0) return "Sem anterior";
        Object elemento = lista[indexp - 1];
        return elemento;
    }
    
    @Override
    public Object after(Object p) {
        int indexp = indexOf(p);
        if(indexp == -1) throw new ENotFoundInList("Elemento não consta na lista");
        if(indexp == arraySize - 1) return "Sem posterior";
        Object elemento = lista[indexp + 1];
        return elemento;
    }
    
    @Override
    public void replaceElement(Object n, Object o) {
        int index = indexOf(n);
        if(index == -1) throw new ENotFoundInList("Elemento não consta na lista");
        
        for(int i = 0; i < arraySize; i++){
            if(lista[i] == n){
                lista[i] = o;
                break;
            }
        }
    }
    
    @Override
    public void swapElements(Object n, Object q) {
        int index = indexOf(n);
        if(index == -1) throw new ENotFoundInList("Elemento não consta na lista");
        int indexA = indexOf(q);
        if(indexA == -1) throw new ENotFoundInList("Elemento não consta na lista");
        
        lista[index] = q;
        lista[indexA] = n;
    }
    
    @Override
    public void insertBefore(Object n, Object o) {
        int size = size();
        if(size == lista.length - 1) increaseList();
        int index = arraySize - 1;
        Object atual = lista[index];
        while(atual != n){
            lista[index + 1] = lista[index];
            atual = lista[index--];
        }
        index++;
        lista[index] = o;
        arraySize++;
    }
    
    @Override
    public void insertAfter(Object n, Object o) {
        int size = size();
        if(size == lista.length - 1) increaseList();
        int index = arraySize - 1;
        while(index != -1){
            if(lista[index-1] == n) break;
            lista[index + 1] = lista[index];
            index--;
        }
        index++;
        lista[index] = o;
        arraySize++;
    }
    
    @Override
    public void insertFirst(Object o) {
        for(int i = arraySize - 1; i >=0 ; i--){
            lista[i + 1] = lista[i];
        }
        lista[0] = o;
        arraySize++;
    }
    
    @Override
    public void insertLast(Object o) {
        int size = size();
        if(size == lista.length - 1) increaseList();
        lista[arraySize] = o;
        arraySize++;
    }

    public int indexOf(Object n){
        for(int i = 0; i < arraySize; i++){
            if(lista[i] == n) return i;
        }
        return -1;
    }
    
    @Override
    public Object remove(Object n) {
        int index = indexOf(n);
        if(index == -1) throw new ENotFoundInList("Elemento não consta na lista");
        for(int i = 0; i < arraySize; i++){
            if(i >= index){
                lista[i] = lista[i + 1];
            }
        }
        arraySize--;
        return n;
    }

    public int size(){
        return arraySize;
    }

    public void printList() {
        System.out.print("{");
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                if (i == arraySize - 1)
                    System.out.print(lista[i]);
                else
                    System.out.print(lista[i] + ", ");
            }

        }
        System.out.print("}");
        System.out.println();
    }
}
