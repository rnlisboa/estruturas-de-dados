package Sequencia;

import Exceptions.EListaVazia;
import Exceptions.ENotFoundInList;
import Node.Node;
import Interfaces.ISequencia;

public class Sequencia implements ISequencia{
    private Node inicio = new Node();
    private Node fim = new Node();;
    private int size;

    public Sequencia(){
        inicio.setNext(fim);
        fim.setPrev(inicio);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return inicio.equals(fim);
    }

    @Override
    public Node atRank(int r) {
        Node node; 
        if(r <= size()/2){
            node = inicio.getNext();
            for(int i = 0; i < r; i++){
                node = node.getNext();
            }
        }else{
            node = fim.getPrev();
            for(int i = 0; i< size()-r-1;i++){
                node = node.getPrev();
            }
        }
        return node;
    }

    @Override
    public int rankOf(Node n) {
        Node node = inicio.getNext();
        int r = 0;
        while(node != n && n != fim){
            n = n.getNext();
            r++;
        }
        return r;
    }

    @Override
    public Object first() {
        if(isEmpty()) throw new EListaVazia("Lista vazia");
        Node first = inicio.getNext();
        return first.getValue();
    }

    @Override
    public Object last() {
        Node last = fim.getPrev();
        return last.getValue();
    }

    @Override
    public Object before(Object p) {
        if(isEmpty()) throw new EListaVazia("Lista vazia");
        Node foundedNode = findNode(p);
        if (foundedNode == null)
            throw new ENotFoundInList("Não encontrado");
        Node prevToFoundedNode = foundedNode.getPrev();
        return prevToFoundedNode.getValue();
    }

    @Override
    public Object after(Object p) {
        if(isEmpty()) throw new EListaVazia("Lista vazia");
        Node foundedNode = findNode(p);
        if (foundedNode == null)
            throw new ENotFoundInList("Não encontrado");
        Node nextToFoundedNode = foundedNode.getNext();
        return nextToFoundedNode.getValue();
    }

    @Override
    public void replaceElement(Object n, Object o) {
        Node foundedNodeN = findNode(n);
        if (foundedNodeN== null)
            throw new ENotFoundInList("Não encontrado");
        foundedNodeN.setValue(o);
    }

    @Override
    public void swapElements(Object n, Object q) {
        Node foundedNodeN = findNode(n);
        if (foundedNodeN== null)
            throw new ENotFoundInList("Não encontrado");
        Node foundedNodeQ = findNode(q);
        if (foundedNodeQ== null)
            throw new ENotFoundInList("Não encontrado");
        Object valueOfN = foundedNodeN.getValue();
        Object valueOfQ = foundedNodeN.getValue();

        foundedNodeN.setValue(valueOfQ);
        foundedNodeQ.setValue(valueOfN);
    }

    @Override
    public void insertFirst(Object o) {
        Node node = new Node();
        node.setValue(o);
        Node nextInicio = inicio.getNext();
        node.setNext(nextInicio);
        inicio.setNext(node);
        node.setPrev(inicio);
        nextInicio.setPrev(node);
        size++;
    }

    @Override
    public void insertLast(Object o) {
        Node node = new Node();
        node.setValue(o);
        if (inicio.getNext().equals(fim)) {
            inicio.setNext(node);
            node.setPrev(inicio);
            node.setNext(fim);
            fim.setPrev(node);
        } else {
            Node prevFim = fim.getPrev();
            node.setNext(fim);
            node.setPrev(prevFim);
            prevFim.setNext(node);
            fim.setPrev(node);
        }
        size++;
    }
    
    @Override
    public void insertAfter(Node foundedNode, Object o) {

        Node proxFoundedNode = foundedNode.getNext();
        if (proxFoundedNode== null)
            throw new ENotFoundInList("Proximo nó não encontrado");
        Node newNode = new Node();
        newNode.setValue(o);
        newNode.setNext(proxFoundedNode);
        newNode.setPrev(foundedNode);
        proxFoundedNode.setPrev(newNode);
        foundedNode.setNext(newNode);
        size++;
    }

    @Override
    public void insertBefore(Node foundedNode, Object o) {
        Node prevFoundedNode = foundedNode.getPrev();
        Node newNode = new Node();
        newNode.setValue(o);
        newNode.setNext(foundedNode);
        newNode.setPrev(prevFoundedNode);
        prevFoundedNode.setNext(newNode);
        foundedNode.setPrev(newNode);
        size++;
    }

    @Override
    public Object replaceAtRank(int r, Object o) {
        Node actualAtRank = atRank(r);
        actualAtRank.setValue(o);
        return actualAtRank;
    }

    @Override
    public void insertAtRank(int r, Object o) {
        Node node = new Node();
        node.setValue(o);
        if (inicio.getNext() == fim) {
            inicio.setNext(node);
            fim.setPrev(node);
            node.setPrev(inicio);
            node.setNext(fim);
        } else {
            Node actualAtRank = atRank(r);
            node.setPrev(actualAtRank.getPrev());
            node.setNext(actualAtRank);
            actualAtRank.getPrev().setNext(node);
            actualAtRank.setPrev(node);
        }
        size++;
    }

    @Override
    public Object removeAtRank(int r) {
        Node actualAtRank = atRank(r);
        actualAtRank.getNext().setPrev(actualAtRank.getPrev());
        actualAtRank.getPrev().setNext(actualAtRank.getNext());
        size--;
        return actualAtRank;
    }

    

    @Override
    public Object remove(Node foundedNode) {
        if(isEmpty()) throw new EListaVazia("Lista vazia");
        Node prevToFoundedNode = foundedNode.getPrev();
        Node nextToFoundedNode = foundedNode.getNext();
        prevToFoundedNode.setNext(nextToFoundedNode);
        nextToFoundedNode.setPrev(prevToFoundedNode);
        size--;
        return foundedNode.getValue();
    }
    
    public void printList() {
        Node atual = inicio.getNext();

        System.out.print("{");
        while (!atual.equals(fim)) {
            if (atual.getNext().equals(fim))
                System.out.print(atual.getValue());
            else
                System.out.print(atual.getValue() + ", ");
            atual = atual.getNext();
        }
        System.out.print("}");
        System.out.println();
    }

    @Override
    public Node elementAtRank(int r) {
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
    public Node findNode(Object n) {
        if(isEmpty()) throw new EListaVazia("Lista vazia");
        Node atual = inicio.getNext();
        while (!atual.equals(fim)) {
            
            if (atual.getValue().equals(n)) {
                return atual;
            }
            atual = atual.getNext();
        }
        return null;
    }
}
