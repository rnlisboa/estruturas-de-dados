package TabelaHash;

public class Item {
    private Object key;
    private Object element;

    public Item(Object key, Object element){
        this.key = key;
        this.element = element;
    }

    public Object getKey() {
        return key;
    }

    public Object getElement() {
        return element;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public void setElement(Object element) {
        this.element = element;
    }

}
