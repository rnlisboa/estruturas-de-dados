package TabelaHash;

public class TabelaHash {
    private Item[] array;
    private int size;
    private int capacity;

    public TabelaHash() {
        this.array = new Item[13];
        this.capacity = 13;
        this.size = 0;
    }

    private void increase(){
        if(this.hasToIncrease()){
            int newCapacity = this.getNextPrimeCapacity();
            Item[] newArray = new Item[newCapacity];
            for(int i = 0; i < newCapacity; i++){
                newArray[i] = this.array[i];
            }
            this.array = newArray;
            this.capacity = newCapacity;
        }
    }

    public int hash(int element){
        return element % this.capacity;
    }

    private boolean placeIsAvailable(int index){
        return this.array[index] == null || this.array[index].getKey() instanceof Available;
    }

    public Object insert(Item item){
        increase();
        size++;
        //int index = this.linearProbing((int)item.getKey());
        int index = this.dubleHash((int)item.getKey());
        this.array[index] = item;
        return item;
    }

    public Object findElement(Object key){
        int index = hash((int)key);
        for(int i = index; i < this.capacity; i++){
            if(this.array[i] != null && this.array[i].getKey() == key){
                return this.array[i].getElement();
            }

            index = hash(index + 1);
        }

        return "NO_SUCH_KEY";
    }

    public Object removeElement(Object key){
        int index = hash((int)key);
        for(int i = index; i < this.capacity; i++){
            if(this.array[i] != null && this.array[i].getKey() == key){
                Object element = this.array[i];
                this.array[i] = new Item(new Available(), null);
                return element;
            }

            index = hash(index + 1);
        }

        return "NO_SUCH_KEY";
    }

    public int linearProbing(int key){
        int index = this.hash(key);
        int p = 0;
        while(!placeIsAvailable(index)){
            index = hash((index + 1));
            p++;
            if(p == this.capacity) throw new FullHashTableException();
        };
        
        return index;
    }

    public int dubleHash(int key){
        int index = this.hash(key);
        int p = 0;
        while(!placeIsAvailable(index)){
            index = hash(1 + 7 * hash(index));
            if(p == this.capacity) throw new FullHashTableException();
        }

        return index;
    }

    private int getNextPrimeCapacity(){
        int doubleCapacity = this.capacity * 2;
        while(!isPrime(doubleCapacity)){
            doubleCapacity++;
        }

        return doubleCapacity;
    }

    private boolean isPrime(int number){
        int div = 0;
        for(int i = 1; i <= number; i++){
            if(number % i == 0) div++;
        }

        return div > 2; 
    }

    private int getFill(){
        return (this.size / this.capacity) * 100;
    }

    private boolean hasToIncrease(){
        return this.getFill() > 50;
    }

    public void printHashTable(){
        System.out.println("[ ");
        for(int i = 0; i < this.capacity; i++){
            if(this.array[i] != null && !(this.array[i].getKey() instanceof Available)){
                System.out.println("{ " + this.array[i].getKey() + " : " + this.array[i].getElement() + " }");
            } else {
                System.out.println(" NO ITEM ");
            }
            
        }
        System.out.println(" ]");
    }

}
