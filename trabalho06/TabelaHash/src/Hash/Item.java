package Hash;

public class Item {
    private Object key;
    private Object value;
    
    public Item(Object k, Object v){
        this.key = k;
        this.value = v;
    }

    public void setKey(Object k){
        this.key = k;;
    }
    
    public void setValue(Object v){
        this.value = v;
    }

    public Object getKey(){
        return this.key;
    }
    
    public Object getValue(){
        return this.value;
    }
}
