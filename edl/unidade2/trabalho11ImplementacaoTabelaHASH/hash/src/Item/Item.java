package Item;

import Interfaces.IEntry;


public class Item implements IEntry{
    private Object key;
    private Object value;

    public Item(Object key, Object value){
        this.key = key;
        this.value = value;
    }
    @Override
    public Object key() {
        return this.key;
    }

    @Override
    public Object value() {
        return this.value;
    }
    
}

