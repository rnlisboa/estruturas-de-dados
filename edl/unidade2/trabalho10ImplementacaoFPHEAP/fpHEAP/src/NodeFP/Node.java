package NodeFP;

import Item.Item;

public class Node {
    private Item value;
    private Node next;
    private Node prev;

    public Node(Item i){
        this.value = i;
    }

    public void setValue(Item v){
        value = v;
    }

    public void setNext(Node node){
        next = node;
    }

    public void setPrev(Node node){
        prev = node;
    }

    public Item getValue(){
        return value;
    }

    public Node getNext(){
        return next;
    }

    public Node getPrev(){
        return prev;
    }
}
