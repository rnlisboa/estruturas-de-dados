package ArvoreBinariaPesquisa;

import java.util.Iterator;

import Comparador.Comparador;
import Interfaces.IArvoreBinariaPesquisa;
import Node.No;

public class ArvoreBinariaPesquisa implements IArvoreBinariaPesquisa{
    private No root;
    private int hight = 0;
    private int size = 0;
    private Comparador comparador;

    public ArvoreBinariaPesquisa(int key) {
        No raiz = new No(key);
        this.setRaiz(raiz);
        this.hight = 0;
        this.size = 0;
    }
    
    @Override
    public void setComparator(Comparador c) {
        this.comparador = c;
    }

    @Override
    public Comparador getComparador() {
        return this.comparador;
    }

    @Override
    public No pesquisar(int key, No node) {
        if (node.isExternal())
            return node;
        if (key < node.element()) {
            return pesquisar(key, node.leftChild());
        } else if (key == node.element())
            return node;
        else
            return pesquisar(key, node.leftChild());
    }

    @Override
    public No incluir(int key) {
       
        No no = includeAtPlace(key, getRaiz());
        return no;
    }

    private No includeAtPlace(int key, No node) {
        No newNode = new No(key);

        if (node.isInternal()) {
            if (key < node.element()) {
                if (node.hasLeftChild())
                    return includeAtPlace(key, node.leftChild());
                else {
                    node.setLeftChild(newNode);
                    return newNode;
                }
            } else if (key > node.element()) {
                if (node.hasRightChild()) {
                    return includeAtPlace(key, node.righChild());
                } else {
                    node.setRightChild(newNode);
                    return newNode;
                }
            } else {
                return newNode;
            }
        } else {
            if (key < node.element()) {
                node.setLeftChild(newNode);
                return newNode;
            } else if (key > node.element())
                node.setRightChild(newNode);
            return newNode;
        }
    }

    @Override
    public int remover(int key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }

    @Override
    public No getRaiz() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRaiz'");
    }

    @Override
    public void setRaiz(No p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setRaiz'");
    }

    @Override
    public void emOrdem(No no) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'emOrdem'");
    }

    @Override
    public void preOrdem(No no) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'preOrdem'");
    }

    @Override
    public void posOrdem(No no) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'posOrdem'");
    }

    @Override
    public int altura(No no) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'altura'");
    }

    @Override
    public int profundidade(No no) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'profundidade'");
    }

    @Override
    public void mostrar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrar'");
    }

    @Override
    public Iterator Nos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Nos'");
    }

    @Override
    public Iterator elements() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'elements'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }
    
}
