package HashTable;

import Item.Item;

public class HashTable implements IHashTable {
    private int capacidade = 13;
    private Item[] array = new Item[13];
    private int size;

    public void rehash() {
        double fator = this.size / this.capacidade;
        if (fator >= 0.5) {

            // encontrar novo tamanho primo
            // copiar array

        }
    }

    @Override
    public int hash(Object k) {
        return (int) k % this.capacidade;
    }

    @Override
    public void insere(Object k, Object v) {
        Item item = new Item(k, v);
        int foundedPos = doubleHash(hash(k), k);
        this.array[foundedPos] = item;
        this.size++;
    }

    private int linearProbing(int indiceHash) {

        while (this.array[indiceHash] != null) {
            indiceHash = (indiceHash + 1) % this.capacidade;
        }
        return indiceHash;
    }

    private int doubleHash(int indiceHash, Object k) {
        int num = 1;
        while (this.array[indiceHash] != null) {
            indiceHash = (indiceHash + num * hash(k)) % this.capacidade;
            num++;
        }

        return indiceHash;
    }

    @Override
    public Object busca(Object k) {
        int indiceHash = hash(k);
        int p = 0;

        while (p < this.capacidade) {
            Item c = this.array[indiceHash];

            if (c == null) {
                return "NO_SUCH_KEY";
            } else if (c.key().equals(k)) {
                return c.value();
            } else {
                indiceHash = (indiceHash + 1) % this.capacidade;
                p++;
            }
        }

        return "NO_SUCH_KEY";
    }

    @Override
    public Object remove(Object k) {
        int indiceHash = hash(k);
        int p = 0;

        while (p < this.capacidade) {
            Item c = this.array[indiceHash];

            if (c == null) {
                return "NO_SUCH_KEY";
            } else if (c.key().equals(k)) {
                this.array[indiceHash] = new Item(null, null);
                return c.value();
            } else {
                indiceHash = (indiceHash + 1) % this.capacidade;
                p++;
            }
        }

        return "NO_SUCH_KEY";
    }

    public void print() {
        System.out.println();
        System.out.print("{ ");
        for (int i = 0; i < this.capacidade; i++) {
            if (array[i] != null) {
                System.out.print("(" + array[i].key() + "," + array[i].value() + ")" + " ");
            } else {
                System.out.print(array[i] + " ");
            }

        }
        System.out.print("}");
        System.out.println();
    }

}
