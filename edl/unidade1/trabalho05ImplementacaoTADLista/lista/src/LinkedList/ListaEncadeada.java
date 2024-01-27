package LinkedList;

import Exceptions.EListaVazia;
import Exceptions.ENotFoundInList;
import Node.Node;
import Interfaces.IListaEncadeada;

public class ListaEncadeada implements IListaEncadeada {
    Node inicio = new Node();
    Node fim = new Node();

    public ListaEncadeada() {
        inicio.setNext(fim);
        fim.setPrev(inicio);
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
    public void insertBefore(Object n, Object o) {
        Node foundedNode = findNode(n);
        if (foundedNode== null)
            throw new ENotFoundInList("Não encontrado");
        Node prevFoundedNode = foundedNode.getPrev();
        Node newNode = new Node();
        newNode.setValue(o);
        newNode.setNext(foundedNode);
        newNode.setPrev(prevFoundedNode);
        prevFoundedNode.setNext(newNode);
        foundedNode.setPrev(newNode);
    }

    @Override
    public void insertAfter(Object n, Object o) {
        Node foundedNode = findNode(n);
        if (foundedNode== null)
            throw new ENotFoundInList("Não encontrado");
        Node proxFoundedNode = foundedNode.getNext();
        if (proxFoundedNode== null)
            throw new ENotFoundInList("Não encontrado");
        Node newNode = new Node();
        newNode.setValue(o);
        newNode.setNext(proxFoundedNode);
        newNode.setPrev(foundedNode);
        proxFoundedNode.setPrev(newNode);
        foundedNode.setNext(newNode);
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
            System.out.println(prevFim.getValue());
            node.setNext(fim);
            node.setPrev(prevFim);
            prevFim.setNext(node);
            fim.setPrev(node);
        }
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

    @Override
    public Object remove(Object n) {
        if(isEmpty()) throw new EListaVazia("Lista vazia");
        Node foundedNode = findNode(n);
        if (foundedNode== null)
            throw new ENotFoundInList("Não encontrado");
        Node prevToFoundedNode = foundedNode.getPrev();
        Node nextToFoundedNode = foundedNode.getNext();
        prevToFoundedNode.setNext(nextToFoundedNode);
        nextToFoundedNode.setPrev(prevToFoundedNode);
        return foundedNode.getValue();
    }

    @Override
    public boolean isEmpty(){
        return inicio.equals(fim);
    }

    @Override
    public boolean isFirst(Object o){
        return inicio.getNext().getValue().equals(o);
    }

    @Override
    public boolean isLast(Object o){
        return fim.getPrev().getValue().equals(o);
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
}
