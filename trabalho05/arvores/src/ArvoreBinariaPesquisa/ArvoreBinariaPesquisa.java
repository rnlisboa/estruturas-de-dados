package ArvoreBinariaPesquisa;

import java.util.ArrayList;
import java.util.Iterator;

import Comparador.Comparador;
import Interfaces.IArvoreBinariaPesquisa;
import Node.No;

public class ArvoreBinariaPesquisa implements IArvoreBinariaPesquisa {
    private No root;
    private int size;
    private int maxDepth;
    private Comparador comparador;

    public ArvoreBinariaPesquisa(int key) {
        No raiz = new No(key);
        this.setRaiz(raiz);
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
        No toRemoveParent = toRemove.parent();
        Object toRemoveElement = toRemove.element();

        // para nó folha
        if (toRemove.isExternal()) {
            if (toRemoveParent.hasLeftChild() && toRemoveParent.leftChild().element() == key)
                toRemoveParent.setLeftChild(null);
            else
                toRemoveParent.setRightChild(null);
            return toRemoveElement;
        }

        if (toRemove.rightChild().isExternal()) {
            toRemove.setElement(toRemove.rightChild().element());
            toRemove.setRightChild(null);
            return toRemoveElement;
        }

        // encontrar o menor filho da subarvore à direita (sucessor)
        No sucessor = findMinRightSubtree(toRemove.rightChild());
        toRemove.setElement(sucessor.element());
        toRemove.setRightChild(sucessor.rightChild());
        return toRemoveElement;
    }

    private No findMinRightSubtree(No node) {
        // se o filho esquerda for null, então node já é o menor filho da subarvore
        // direita
        while (node.leftChild() != null) {
            node = node.leftChild();
        }
        return node;
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
        if (no.isInternal()) {
            emOrdem(no.leftChild());
        }

        if(profundidade(no) > this.maxDepth) this.maxDepth = profundidade(no);

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
        int altura = this.maxDepth - profundidade(no);
        return altura;
    }

    private int alturaRec(No node){
        if(node.isExternal()) return 0;
        
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
        // passo o raiz
        // mostro filho esquerdo e filho direito
        // vou pro esquerdo e mostro o esquerdo e o direito e depois vou pro direito e
        // faço o mesmo
        // se o esquerdo do raiz for interno,

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

    public int getMaxDepth(No node) {

        return 0;
    }

}