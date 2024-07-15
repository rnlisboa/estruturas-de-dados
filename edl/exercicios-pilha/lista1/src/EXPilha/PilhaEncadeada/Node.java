package EXPilha.PilhaEncadeada;

public class Node {
    private Object value;
    private Node prox;

    public Node(Object v, Node prox){
        this.value = v;
        this.prox = prox;
    }

    public Object getValue(){
        return this.value;
    }

    public Node getProx(){
        return this.prox;
    }

    public void setValue(Object value){
        this.value = value;
    }

    public void setProx(Node prox){
        this.prox = prox;
    }
}
