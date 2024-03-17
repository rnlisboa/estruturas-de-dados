package PilhaEncadeada;

import Exceptions.EPilhaVazia;
import NodePF.Node;

public class Pilha  {
    private Node top;
    private int size;
    public Pilha() {
        this.size = 0;
    }
	public Object top() {
		return top.getValue();
	}
	public void setTop(Node top) {
		this.top = top;
	}
	public int getSize() {
		return size;
	}
	
    public void push(Object o) {
        Node atualTop = this.top;
        Node n = new Node(o);
        n.setProx(atualTop);
        this.top = n;
        this.size++;
    }

    public void pop(){
        if(isEmpty()) throw new EPilhaVazia("Pilha vazia");
        this.top = this.top.getProx();
    }

    public boolean isEmpty(){
        return this.top == null;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "{}";
        StringBuilder builder = new StringBuilder("{");
        Node current = top;

        while (current != null) {
            builder.append(" ").append(current.getValue()).append(" ");
            current = current.getProx();
        }

        builder.append("}");
        return builder.toString();
    }
}
