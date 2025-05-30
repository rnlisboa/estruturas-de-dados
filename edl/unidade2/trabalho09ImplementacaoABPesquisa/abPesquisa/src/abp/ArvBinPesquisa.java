package abp;

import java.util.ArrayList;
import java.util.Iterator;

import Interfaces.IArvBinPesquisa;
import Node.No;

public class ArvBinPesquisa implements IArvBinPesquisa {
    public No root;
    private int size;

    @Override
    public No pesquisar(No node, Object key) {
        if (isExternal(node))
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
        No novoNo = new No(key);
        No atual = getRaiz();
        //se a arvore estiver vazia
        if(atual == null){
            this.setRaiz(novoNo);
        }
        while (atual != null) {
            if (isInternal(atual)) {
                if ((int) key < (int) atual.element()) {
                    if (atual.hasLeftChild()) {
                        atual = atual.leftChild();
                    } else {
                        atual.setLeftChild(novoNo);
                        novoNo.setParent(atual);
                        this.size++;
                        return novoNo;
                    }
                } else if ((int) key > (int) atual.element()) {
                    if (atual.hasRightChild()) {
                        atual = atual.rightChild();
                    } else {
                        atual.setRightChild(novoNo);
                        novoNo.setParent(atual);
                        this.size++;
                        return novoNo;
                    }
                } else {
                    return novoNo;
                }
            } else {
                if ((int) key < (int) atual.element()) {
                    atual.setLeftChild(novoNo);
                    novoNo.setParent(atual);
                    this.size++;
                    return novoNo;
                } else if ((int) key > (int) atual.element()) {
                    atual.setRightChild(novoNo);
                    novoNo.setParent(atual);
                    this.size++;
                    return novoNo;
                } else {
                    return novoNo;
                }
            }
        }
        return novoNo;
    }

    @Override
    public Object remover(Object key) {
        No toRemove = pesquisar(getRaiz(), key);
        No toRemoveParent = toRemove.parent();
        Object toRemoveElement = toRemove.element();

        // para nó folha
        if (isExternal(toRemove)) {
            if(toRemove.equals(this.getRaiz())) {
                this.root = null;
                return toRemoveElement;
            }
            if (toRemoveParent.hasLeftChild() && toRemoveParent.leftChild().element() == key)
                toRemoveParent.setLeftChild(null);
            else
                toRemoveParent.setRightChild(null);
            return toRemoveElement;
        }

        // nó com um filho
        if (toRemove.hasRightChild()) {
            if (isExternal(toRemove.rightChild())) {
                toRemove.setElement(toRemove.rightChild().element());
                toRemove.setRightChild(null);
                return toRemoveElement;
            }
        } else {
            toRemove.setElement(toRemove.leftChild().element());
            toRemove.setLeftChild(toRemove.leftChild().leftChild());
            return toRemoveElement;
        }

        // encontrar o menor filho da subarvore à direita (sucessor)
        No sucessor = findMinRightSubtree(toRemove.rightChild());
        toRemove.setElement(sucessor.element());
        No parentSucessor = sucessor.parent();
        //sucessor eh filho imediato direito
        if(parentSucessor.rightChild().equals(sucessor)){
            parentSucessor.setRightChild(sucessor.rightChild());
            sucessor.rightChild().setParent(parentSucessor);
        } else {
            parentSucessor.setLeftChild(null);
        }
        
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
        this.size++;
    }

    @Override
    public void emOrdem(No no) {
        if (no == null)
            return;

        if (isInternal(no))
            emOrdem(no.leftChild());

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

        if (isInternal(no)) {
            emOrdem(no.rightChild());
        }
    }

    @Override
    public void preOrdem(No no) {
       if(no != null){
        System.out.println(no.element());
        preOrdem(no.leftChild());
        preOrdem(no.rightChild());
       }
    }

    @Override
    public void posOrdem(No no) {
        if(no != null){
            preOrdem(no.leftChild());
            preOrdem(no.rightChild());
            System.out.println(no.element());
           }
    }

    @Override
    public int altura(No no) {
        if (no == null)
            return -1;
        int alturaDireita = altura(no.rightChild());
        int alturaEsquerda = altura(no.leftChild());

        return 1 + Math.max(alturaDireita, alturaEsquerda);
    }

    @Override
    public int profundidade(No no) {
        if (no.equals(getRaiz()))
            return 0;
        return 1 + profundidade(no.parent());
    }

    private int emOrdemMatriz(Object[][] matriz, No no, int i){
        if(no.hasLeftChild()){
            i = emOrdemMatriz(matriz, no.leftChild(), i);
        }
        i++;
        matriz[profundidade(no)][i] = no.element();
        if(no.hasRightChild()){
            i = emOrdemMatriz(matriz, no.rightChild(), i);
        }

        return i;
    }

    @Override
    public void mostrar(){
        int qtdLinhas = altura(root) + 1;
        int qtdColunas = (int)Math.pow(2, qtdLinhas);
        Object[][] matriz = new Object[qtdLinhas][qtdColunas];
        this.emOrdemMatriz(matriz, root, 0);
        for (int i = 0; i < qtdLinhas; i++) {
            for (int j = 0; j < qtdColunas; j++) {
                if (matriz[i][j] == null)
                    System.out.print(" ");
                else
                    System.out.print(matriz[i][j]);
            }
            System.out.println();
        } 
    }

    @Override
    public Iterator<No> Nos() {
        ArrayList<No> arrayNode = new ArrayList<No>();
        createNosList(root, arrayNode);
        return arrayNode.iterator();
    }

    private void createNosList(No node, ArrayList<No> arrayNode) {
        if (isInternal(node))
            createNosList(node.leftChild(), arrayNode);
        arrayNode.add(node);
        if (isInternal(node)) {
            createNosList(node.rightChild(), arrayNode);
        }
    }

    private void createElementsList(No node, ArrayList<Object> arrayElement) {
        if (isInternal(node))
            createElementsList(node.leftChild(), arrayElement);
        arrayElement.add(node);
        if (isInternal(node)) {
            createElementsList(node.rightChild(), arrayElement);
        }
    }

    @Override
    public Iterator<Object> elements() {
        ArrayList<Object> arrayElement = new ArrayList<Object>();
        createElementsList(root, arrayElement);
        return arrayElement.iterator();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean isInternal(No node) {
        boolean hasLeftChild = node.hasLeftChild();
        boolean hasRightChild = node.hasRightChild();
        boolean isInternal = hasLeftChild || hasRightChild;
        return isInternal;
    }

    public boolean isExternal(No node) {
        boolean hasLeftChild = node.hasLeftChild();
        boolean hasRightChild = node.hasRightChild();
        boolean isInternal = !hasLeftChild && !hasRightChild;
        return isInternal;
    }

}