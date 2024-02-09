package ItemAVl;

import InterfacesAVL.IEntry;

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
    
    public String toString(){
        return this.key().toString();
    }

}