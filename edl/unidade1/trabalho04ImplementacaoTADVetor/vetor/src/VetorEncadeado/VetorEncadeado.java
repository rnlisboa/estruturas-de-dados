package VetorEncadeado;

import Node.Node;
import interfaces.IVetor;

public class VetorEncadeado implements IVetor {
    private Node inicio = new Node();
    private Node fim = new Node();

    public void setInitialState() {
        inicio.setNext(fim);
        fim.setPrev(inicio);
    }

    public void insertAtRank(int r, Object o) {
        Node node = new Node();
        node.setValue(o);
        if (inicio.getNext() == fim) {
            inicio.setNext(node);
            fim.setPrev(node);
            node.setPrev(inicio);
            node.setNext(fim);
        } else {
            Node actualAtRank = elementAtRank(r);
            node.setPrev(actualAtRank.getPrev());
            node.setNext(actualAtRank);
            actualAtRank.getPrev().setNext(node);
            actualAtRank.setPrev(node);
        }
    }

    public Node elementAtRank(int r){
        Node atual = inicio.getNext();
        int index = 0;
        while(atual != fim){
            if(index == r){ 
                return atual;               
            }
            atual = atual.getNext();
            index++;
        }
        return null;
    }

    public Object replaceAtRank(int r, Object o) {
        Node actualAtRank = elementAtRank(r);
        actualAtRank.setValue(o);
        return actualAtRank;
    }

    public Object removeAtRank(int r) {
        Node actualAtRank = elementAtRank(r);
        actualAtRank.getNext().setPrev(actualAtRank.getPrev());
        actualAtRank.getPrev().setNext(actualAtRank.getNext());
        return actualAtRank;
    }

    public int size() {
        int size = 0;
        Node atual = inicio.getNext();
        while(atual != fim){
            size++;
        }
        return size;
    }

    public void insertBefore(Node actualAtRank, Object o) {
        Node node = new Node();
        node.setValue(o);
        node.setNext(actualAtRank);
        node.setPrev(actualAtRank.getPrev());
        actualAtRank.getPrev().setNext(node);
        actualAtRank.setPrev(node);
    }

    public void insertAfter(Node actualAtRank, Object o) {
        Node node = new Node();
        node.setValue(o);
        node.setNext(actualAtRank.getNext());
        node.setPrev(actualAtRank);
        actualAtRank.getNext().setPrev(node);
        actualAtRank.setNext(node);
    }

    public void insertFirst(Object o) {
        Node node = new Node();
        node.setValue(o);
        Node nextInicio = inicio.getNext();
        node.setNext(nextInicio);
        inicio.setNext(node);
        node.setPrev(inicio);
        nextInicio.setPrev(node);
    }

    public void insertLast(Object o) {
        Node node = new Node();
        node.setValue(o);
        if (inicio.getNext() == fim) {
            inicio.setNext(node);
            node.setPrev(inicio);
            node.setNext(fim);
            fim.setPrev(node);
        }else{
            Node prevFim = fim.getPrev();
            System.out.println(prevFim.getValue());
            node.setNext(fim);
            node.setPrev(prevFim);
            prevFim.setNext(node);
            fim.setPrev(node);
        }
        
    }

    public void print() {
        Node atual = inicio.getNext();

        System.out.print("{");
        while (atual != fim) {
            if (atual.getNext() == fim)
                System.out.print(atual.getValue());
            else
                System.out.print(atual.getValue() + ", ");
            atual = atual.getNext();
        }
        System.out.print("}");
        System.out.println();
    }
}
