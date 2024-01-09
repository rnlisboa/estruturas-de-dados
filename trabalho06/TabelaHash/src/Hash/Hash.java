package Hash;

public class Hash {
    private int capacidade = 13;
    private Object[] array = new Object[13];
    private int size;

    // encontrar a posição do novo elemento
    public Object hash(Object v) {
        return (int) v % this.capacidade;
    }

    public void insere(Object v) {
        int pos = (int) hash(v);

        int foundedPos = linearProbing(pos);
        this.array[foundedPos] = v;
        this.size++;
    }

    private int linearProbing(int indiceHash) {
        int newPos = indiceHash;
        while (this.array[newPos] != null) {
            newPos = (newPos + 1) % this.capacidade;
        }
        return newPos;
    }

    private int doubleHash(int indiceHash, Object v) {
        // encontar o indice primo mais proximo de indiceHash
        int newPos = indiceHash;
        while (this.array[newPos] != null) {
            boolean isPrime = ehPrimo(newPos++);
            if (isPrime) {
                newPos = (int) v % newPos;
            }
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


    private void remove(Object o){
        int pos = (int)hash(o);
        int newPos = linearProbing(pos);
        this.array[newPos] = null;

    }


    public void print() {
        for (int i = 0; i < this.capacidade; i++) {
            System.out.println(array[i]);
        }
    }
}
