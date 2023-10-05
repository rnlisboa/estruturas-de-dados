package vectorImplements.Vetor;
import Exceptions.EListaVazia;
import interfaces.IVetor;

public class Vetor implements IVetor {
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
    public Object elementAtRank(int r) {
        return lista[r];
    }

    @Override
    public Object replaceAtRank(int r, Object o) {
        Object lastInRank = lista[r];
        lista[r] = o;
        return lastInRank;
    }

    @Override
    public void insertAtRank(int r, Object o) {
        
        int size = size();
        if(size == lista.length - 1) increaseList();
        System.out.println(arraySize);
        for (int i = arraySize; i >= r; i--) {
            lista[i + 1] = lista[i];
        }
        
        lista[r] = o;
        arraySize++;
    }

    @Override
    public Object removeAtRank(int r) {
        int size = size();
        if(size == 0) throw new EListaVazia("Operação inválida. Lista vazia");
        Object lastInRank = lista[r];
        for (int i = r; i <= lista.length - 2; i++) {
            lista[i] = lista[i + 1];
        }
        arraySize--;
        return lastInRank;
    }

    public int size() {
        return arraySize;
    }

    @Override
    public void insertBefore(int r, Object o) {
        int size = size();
        if(size == lista.length - 1) increaseList();
        for (int i = lista.length - 2; i >= r; i--) {
            lista[i + 1] = lista[i];
        }
        lista[r] = o;
        arraySize++;
    }

    @Override
    public void insertAfter(int r, Object o) {
        int size = size();
        if(size == lista.length - 1) increaseList();
        for (int i = lista.length - 2; i > r; i--) {
            lista[i + 1] = lista[i];
        }
        lista[r + 1] = o;
        arraySize++;
    }

    @Override
    public void insertFirst(Object o) {
        int size = size();
        if(size == lista.length - 1) increaseList();
        for(int i = lista.length - 2; i >= 0; i--){
            lista[i + 1] = lista[i];
        }
        arraySize++;
        lista[0] = o;
    }


    @Override
    public void insertLast(Object o) {
        int size = size();
        if(size == lista.length - 1) increaseList();
        lista[arraySize] = o;
        arraySize++;
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
