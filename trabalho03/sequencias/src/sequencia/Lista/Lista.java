package sequencia.Lista;

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
        return lista[0];
    }
    
    @Override
    public Object last() {
        return lista[arraySize];
    }
    
    @Override
    public Object before(Object p) {
        Object elemento = 0;
        Object i = lista[0];
        int index = 0;
        while(i != p){
            elemento = lista[index];
            index++;
        }
        return elemento;
    }
    
    @Override
    public Object after(Object p) {
        Object elemento = 0;
        Object i = lista[0];
        int index = 0;
        while(i != p){
            elemento = lista[index + 1];
            index++;
        }
        return elemento;
    }
    
    @Override
    public void replaceElement(Object n, Object o) {
        int i = 0;
        while(true){
            Object atual = lista[i];
            if(atual == n) lista[i] = o;
            i++;
        }
    }
    
    @Override
    public void swapElements(Object n, Object q) {
        for(int i = 0; i <= arraySize; i++){
            Object atual = lista[i];
            
            if(atual == n){
                System.out.println(atual);
                for(int j = 0; j <= arraySize; j++){
                    Object trocaPor = lista[j];
                    if(trocaPor == q) {
                        System.out.println(trocaPor);
                        lista[i] = q;
                        lista[j] = n;
                        break;
                    }
                }
            }
        }
    }
    
    @Override
    public void insertBefore(Object n, Object o) {
        int size = size();
        if(size == lista.length - 1) increaseList();
        for(int i = 0; i < arraySize; i++){
            if(lista[i] == n){
                for(int j = arraySize - 1; j >= i; j--){
                    lista[j + 1] = lista[j];
                }
                lista[i] = o;
                break;
            }
        }
        arraySize++;
    }
    
    @Override
    public void insertAfter(Object n, Object o) {
        int size = size();
        if(size == lista.length - 1) increaseList();
        for(int i = 0; i < arraySize; i++){
            if(lista[i] == n){
                for(int j = arraySize - 1; j > i; j--){
                    lista[j + 1] = lista[j];
                }
                lista[i + 1] = o;
                break;
            }
        }
        arraySize++;
    }
    
    @Override
    public void insertFirst(Object o) {
        
    }
    
    @Override
    public void insertLast(Object o) {
        int size = size();
        if(size == lista.length - 1) increaseList();
        lista[arraySize] = o;
        arraySize++;
    }
    
    @Override
    public Object remove(Object n) {
        return 0;
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
