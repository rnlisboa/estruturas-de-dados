package Item;

public class Item{
    private Object key;
    private Object value;

    public Item(Object key, Object value){
        this.key = key;
        this.value = value;
    }

    public Object key() {
        return this.key;
    }

    public Object value() {
        return this.value;
    }
    
}
