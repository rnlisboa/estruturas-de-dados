package sequencia.Array;

public class Array implements IArray {
    private int capacity = 2;
    private int arraySize;
    private Object[] lista = new Object[2];

    public void increaseList(){
        int newCapacity = capacity*2;
        Object[] newList = new Object[newCapacity];
        for(int i = 0; i < arraySize; i++){
            newList[i] = lista[i];
        }

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
        System.out.println(size == lista.length);
        if(size == lista.length - 1) increaseList();

        for (int i = arraySize; i >= r; i--) {
            lista[i + 1] = lista[i];
        }
        arraySize++;
        lista[r] = o;
    }

    @Override
    public Object removeAtRank(int r) {
        Object lastInRank = lista[r];
        for (int i = lista.length - 1; i >= r; i--) {
            lista[i] = lista[i - 1];
        }
        return lastInRank;
    }

    public int size() {
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
