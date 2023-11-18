package ArvoreBinariaPesquisa;

import java.util.ArrayList;
import java.util.Iterator;

import Comparador.Comparador;
import Interfaces.IArvoreBinariaPesquisa;
import Node.No;

public class ArvoreBinariaPesquisa implements IArvoreBinariaPesquisa {
    private No root;
    private int altura;
    private int size;
    private Comparador comparador;

    public ArvoreBinariaPesquisa(int key) {
        No raiz = new No(key);
        this.setRaiz(raiz);
        this.altura = 0;
        this.size = 1;
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
    public No pesquisar(No node, Object key) {
        if (node.isExternal())
            return node;
        if ((int) key < (int) node.element()) {
            return pesquisar(node.leftChild(), key);
        } else if (key == node.element())
            return node;
        else
            return pesquisar(node.rightChild(), key);
    }

    @Override
    public No incluir(Object key) {
        No no = includeAtPlace(key, getRaiz());
        return no;
    }

    private No includeAtPlace(Object key, No node) {
        No newNode = new No(key);

        if (node.isInternal()) {
            if ((int) key < (int) node.element()) {
                if (node.hasLeftChild())
                    return includeAtPlace(key, node.leftChild());
                else {
                    node.setLeftChild(newNode);
                    newNode.setParent(node);
                    this.size++;
                    return newNode;
                }
            } else if ((int) key > (int) node.element()) {
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
            if ((int) key < (int) node.element()) {
                node.setLeftChild(newNode);
                newNode.setParent(node);
                this.size++;
                return newNode;
            } else if ((int) key > (int) node.element()) {
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
    public Object remover(Object key) {
        No toRemove = pesquisar(getRaiz(), key);
        Object toRemoveElement = toRemove.element();

        if(toRemove.isExternal()) {
            toRemove = null;
            return toRemoveElement;
        }

        if(toRemove.rightChild().isExternal()){
            toRemove.setElement(toRemove.rightChild().element());
            toRemove.setRightChild(null);
            return toRemoveElement;
        }

        No rightChild = toRemove.rightChild();
        No node = toRemove;
        while (rightChild.leftChild() != null) {
            node = toRemove.leftChild();
        }
        toRemove.setElement(node.element());
        node = null;
        return toRemoveElement;
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
        if (no == null) {
            return;
        }

        if (no.isInternal()) {
            emOrdem(no.leftChild());
        }

        System.out.print(no.element() + " pai de ");

        if (no.hasLeftChild()) {
            System.out.print(no.leftChild().element() + " ");
        } else {
            System.out.print("null ");
        }

        System.out.print("e ");

        if (no.hasRightChild()) {
            System.out.print(no.rightChild().element());
        } else {
            System.out.print("null");
        }

        System.out.println();

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
        ArrayList<No> arrayNode = new ArrayList();
        createNosList(root, arrayNode);
        return arrayNode.iterator();
    }

    private void createNosList(No node, ArrayList<No> arrayNode) {
        if (node.isInternal())
            emOrdem(node.leftChild());
        arrayNode.add(node);
        if (node.isInternal()) {
            emOrdem(node.rightChild());
        }
    }

    private void createElementsList(No node, ArrayList<Object> arrayElement) {
        if (node.isInternal())
            emOrdem(node.leftChild());
        arrayElement.add(node);
        if (node.isInternal()) {
            emOrdem(node.rightChild());
        }
    }

    @Override
    public Iterator<Object> elements() {
        ArrayList<Object> arrayElement = new ArrayList();
        return arrayElement.iterator();
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