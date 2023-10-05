package listImplements.ListaEncadeada;

import Node.Node;
import interfaces.ILista;

public class ListaEncadeada implements ILista{
    Node inicio = new Node();
    Node fim = new Node();

    public void setInitialState() {
        inicio.setNext(fim);
        fim.setPrev(inicio);
    }

    @Override
    public Object first() {
        Node first = inicio.getNext();
        return first.getValue();
    }

    @Override
    public Object last(){
        Node last = fim.getPrev();
        return last.getValue();
    }

    @Override
    public Object before(Object p) {
        return 0;
    }

    @Override
    public Object after(Object p) {
        return 0;
    }

    @Override
    public void replaceElement(Object n, Object o) {
        
    }

    @Override
    public void swapElements(Object n, Object q) {
      
    }

    @Override
    public void insertBefore(Object n, Object o) {
       
    }

    @Override
    public void insertAfter(Object n, Object o) {
       
    }

    @Override
    public void insertFirst(Object o) {
       
    }

    @Override
    public void insertLast(Object o) {
       
    }

    @Override
    public Object remove(Object n) {
        return 0;
    }
    
}
