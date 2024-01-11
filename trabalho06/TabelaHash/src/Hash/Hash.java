package Hash;

public class Hash {
    private int capacidade = 13;
    private Item[] array = new Item[13];
    private int size;

    public void rehash(){
        int nCapacity = 2*this.capacidade + 1;
    }
    // encontrar a posição do novo elemento
    public Object hash(Object k) {
        return (int) k % this.capacidade;
    }

    public void insere(Object k, Object v) {
        Item item = new Item(k, v);
        int foundedPos = linearProbing(k);
        this.array[foundedPos] = item;
        this.size++;
    }

    private int linearProbing(Object k) {
        int pos = (int) hash(k);
        while (this.array[pos] != null) {
            pos = (pos + 1) % this.capacidade;
        }
        return pos;
    }

    private int doubleHash(int indiceHash, Object v) {
        // encontar o indice primo mais proximo de indiceHash
        int newPos = indiceHash;
        while (this.array[newPos] != null) {
       
                newPos = 7 - (indiceHash % 7);
        }

        return newPos;
    }

    public static boolean ehPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }

        return true;
    }

    public Object busca(Object x) {
        Object k;
        k = hash(x);
        if (this.array[(int) k] == x)
            return k;
        return -1;
    }

    private void remove(Object o) {
        int pos = (int) hash(o);
        int newPos = linearProbing(pos);
        this.array[newPos] = null;
    }

    public void print() {
        for (int i = 0; i < this.capacidade; i++) {
            if(array[i] != null){
                System.out.println(array[i].getValue());
            }
            else{
                System.out.println(array[i]);
            }
           
        }
    }
}
