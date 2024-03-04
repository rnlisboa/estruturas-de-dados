package Deque;

import FilaAux.EFilaVazia;

public class Deque implements IDeque {
    private Node head;
    private Node tail;
    private int size;

    public Deque() {
        this.head.setNext(this.tail);
        this.tail.setNext(this.head);
    }

    @Override
    public Object insertFirst(Object o) {
        Node novo = new Node(o);
        if (isEmpty()) {
            this.head.setNext(novo);
            this.tail.setPrev(novo);
        } else {
            Node ancientFirst = this.head.getNext();
            ancientFirst.setPrev(novo);
            novo.setNext(ancientFirst);
            this.head.setNext(novo);
        }

        this.size++;
        return o;
    }
    
    @Override
    public Object insertLast(Object o) {
        Node novo = new Node(o);
        if (isEmpty()) {
            this.head.setNext(novo);
            this.tail.setPrev(novo);
        } else {
            Node ancientLast = this.tail.getPrev();
            ancientLast.setPrev(novo);
            novo.setNext(ancientLast);
            this.tail.setPrev(novo);
        }
        this.size++;
        return o;
    }
    
    @Override
    public Object removeFirst() {
        if(isEmpty()) throw new EFilaVazia("Fila vazia");
        Node first = this.head.getNext();
        Node nextFirst = first.getNext();
        this.head.setNext(nextFirst);
        nextFirst.setPrev(this.head);
        this.size--;
        return first.getValue();
    }
    
    @Override
    public Object removeLast() {
        if(isEmpty()) throw new EFilaVazia("Fila vazia");
        Node last = this.tail.getPrev();
        Node prevLast = last.getPrev();
        this.tail.setPrev(prevLast);
        prevLast.setNext(this.tail);
        this.size--;
        return last.getValue();
    }
    
    @Override
    public Object first() {
        return this.head.getNext().getValue();
    }

    @Override
    public Object last() {
        return this.tail.getPrev().getValue();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.head.getNext().equals(this.tail);
    }

}
