package NodePF;

public class Node {
    private Object value;
    private Node prox;
    public Node(Object v){
        this.value = v;
    }
    public Object getValue() {
        return value;
    }
    public void setValue(Object value) {
        this.value = value;
    }
    public Node getProx() {
        return prox;
    }
    public void setProx(Node prox) {
        this.prox = prox;
    }

    
}
