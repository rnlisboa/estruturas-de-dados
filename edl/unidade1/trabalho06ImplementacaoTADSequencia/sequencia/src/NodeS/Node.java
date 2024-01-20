package NodeS;

public class Node {
    private Object value;
    private Node next;
    private Node prev;

    public void setValue(Object v){
        value = v;
    }

    public void setNext(Node node){
        next = node;
    }

    public void setPrev(Node node){
        prev = node;
    }

    public Object getValue(){
        return value;
    }

    public Node getNext(){
        return next;
    }

    public Node getPrev(){
        return prev;
    }
}
