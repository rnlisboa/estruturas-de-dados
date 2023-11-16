package ArvoreBinariaPesquisa;

import java.util.ArrayList;
import java.util.Iterator;

import Comparador.Comparador;
import Interfaces.IArvoreBinariaPesquisa;
import Node.No;

public class ArvoreBinariaPesquisa implements IArvoreBinariaPesquisa {
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
                    newNode.setParent(node);
                    this.size++;
                    return newNode;
                }
            } else if (key > node.element()) {
                if (node.hasRightChild()) {
                    return includeAtPlace(key, node.rightChild());
                } else {
                    node.setRightChild(newNode);
                    newNode.setParent(node);
                    this.size++;
                    return newNode;
                }
            } else {
                return newNode;
            }
        } else {
            if (key < node.element()) {
                node.setLeftChild(newNode);
                newNode.setParent(node);
                this.size++;
                return newNode;
            } else if (key > node.element()) {
                node.setRightChild(newNode);
                newNode.setParent(node);
                this.size++;
                return newNode;
            } else {
                return newNode;
            }
        }
    }

    @Override
    public int remover(int key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }

    @Override
    public No getRaiz() {
        return this.root;
    }

    @Override
    public void setRaiz(No p) {
        this.root = p;
    }

    @Override
    public void emOrdem(No no) {
        if (no.isInternal())
            emOrdem(no.leftChild());
        System.out.println(no.element());
        if (no.isInternal()) {
            emOrdem(no.rightChild());
        }
    }

    @Override
    public void preOrdem(No no) {

    }

    @Override
    public void posOrdem(No no) {

    }

    @Override
    public int altura(No no) {
        while (no.isInternal()) {

        }
        return 0;
    }

    @Override
    public int profundidade(No no) {
        if (no.equals(getRaiz()))
            return 0;
        return 1 + profundidade(no.parent());
    }

    @Override
    public void mostrar() {
        System.out.println(scrollToShow(getRaiz()));
    }

    private No scrollToShow(No node) {
        System.out.println(node.element());
        if (node.isInternal()) {
            if (node.hasLeftChild())
                return scrollToShow(node.leftChild());
            else if (node.hasRightChild())
                return scrollToShow(node.rightChild());
            else
                return null;
        } else {
            return null;
        }

    }

    @Override
    public Iterator<No> Nos() {
        ArrayList<No> nos = new ArrayList<>();
        return nos.iterator();
    }

    private void createNosList(No node){
        ArrayList<No> nos = new ArrayList<>();
        if (node.isInternal())
            emOrdem(node.leftChild());
        nos.add(node);
        if (node.isInternal()) {
            emOrdem(node.rightChild());
        }
    }

    @Override
    public Iterator<Object> elements() {
        ArrayList<Object> elements = new ArrayList<>();
        return elements.iterator();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

}
