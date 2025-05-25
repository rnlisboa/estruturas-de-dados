package Arvores;

import java.util.ArrayList;
import java.util.Iterator;

import Interfaces.IArvBinPesquisa;
import Node.No;

public class ArvBinPesquisa implements IArvBinPesquisa {
    public No root;
    private int size;

    @Override
    public No pesquisar(No node, Object key) {
        
        if(node == null) {
            return new No("NO_SUCH_KEY");
        }

        if(node.element().equals(key)) {
            return node;
        }

        if ((int) key > (int) node.element()) {
            return pesquisar(node.rightChild(), key);
        } else {
            return pesquisar(node.leftChild(), key);
        }
    }

    @Override
    public No incluir(Object key) {
        No novoNo = new No(key);

        if (this.getRaiz() == null) {
            this.root = novoNo;
            this.size++;
            return novoNo;
        }

        No current = this.getRaiz();

        while (current.element() != null) {
            if ((int) key > (int) current.element()) {
                if (current.hasRightChild()) {
                    current = current.rightChild();
                } else {
                    current.setRightChild(novoNo);
                    novoNo.setParent(current);
                    this.size++;
                    return novoNo;
                }
            } else if ((int) key < (int) current.element()) {
                if (current.hasLeftChild()) {
                    current = current.leftChild();
                    this.size++;
                } else {
                    current.setLeftChild(novoNo);
                    novoNo.setParent(current);
                    this.size++;
                    return novoNo;
                }
            }
        }

        return novoNo;
    }

    @Override
    public No remover(Object key) {
        No toRemove = pesquisar(getRaiz(), key);
        No toRemoveParent = toRemove.parent();

        // para nó folha
        if (isExternal(toRemove)) {
            if (toRemove.equals(this.getRaiz())) {
                this.root = null;
                return toRemove;
            }
            if (toRemoveParent.hasLeftChild() && toRemoveParent.leftChild().element() == key)
                toRemoveParent.setLeftChild(null);
            else
                toRemoveParent.setRightChild(null);
            return toRemove;
        }

        // nó com um filho
        if(toRemove.leftChild() == null || toRemove.rightChild() == null) {
            if (toRemove.hasRightChild()) {
                if (isExternal(toRemove.rightChild())) {
                    toRemove.setElement(toRemove.rightChild().element());
                    toRemove.setRightChild(null);
                    return toRemove;
                }
            } else {
                toRemove.setElement(toRemove.leftChild().element());
                toRemove.setLeftChild(toRemove.leftChild().leftChild());
                return toRemove;
            }
        }

        No sucessor = findMinRightSubtree(toRemove.rightChild());

        toRemove.setElement(sucessor.element());
        if(sucessor.parent().element() != toRemove.element()) {
            sucessor.parent().setLeftChild(null);
        } else {
            sucessor.parent().setRightChild(null);
        }
        return sucessor;
    }

    public No getSucessor(No no) {
        if(isExternal(no)) {
            return null;
        } else if(no.leftChild() == null || no.rightChild() == null) {
            if(no.hasRightChild()) {
                return no.rightChild();
            } 
            
            if(no.hasLeftChild()){
                return no.leftChild();
            }
        } else {
            return this.findMinRightSubtree(no);
        }

        return null;
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
        if (no != null) {
            System.out.println(no.element());
            preOrdem(no.leftChild());
            preOrdem(no.rightChild());
        }
    }

    @Override
    public void posOrdem(No no) {
        if (no != null) {
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

    private int emOrdemMatriz(Object[][] matriz, No no, int i) {
        if (no.hasLeftChild()) {
            i = emOrdemMatriz(matriz, no.leftChild(), i);
        }
        i++;
        matriz[profundidade(no)][i] = no;
        if (no.hasRightChild()) {
            i = emOrdemMatriz(matriz, no.rightChild(), i);
        }

        return i;
    }

    @Override
    public void mostrar() {
        if (this.getRaiz() == null)
            return;

        int qtdLinhas = altura(root) + 1;
        int qtdColunas = (int) Math.pow(2, qtdLinhas);
        No[][] matriz = new No[qtdLinhas][qtdColunas];
        this.emOrdemMatriz(matriz, root, 0);
        for (int i = 0; i < qtdLinhas; i++) {
            for (int j = 0; j < qtdColunas; j++) {
                if (matriz[i][j] == null)
                    System.out.print("         ");
                else
                    System.out.print(matriz[i][j].element() + "(fb: " + matriz[i][j].getFb() + ")");
            }
            System.out.println();
        }
    }

    public void mostrarRN() {
        final String RESET = "\u001B[0m";
        final String VERMELHO = "\u001B[31m";


        if (this.getRaiz() == null)
            return;

        int qtdLinhas = altura(root) + 1;
        int qtdColunas = (int) Math.pow(2, qtdLinhas);
        No[][] matriz = new No[qtdLinhas][qtdColunas];
        this.emOrdemMatriz(matriz, root, 0);
        for (int i = 0; i < qtdLinhas; i++) {
            for (int j = 0; j < qtdColunas; j++) {
                if (matriz[i][j] == null) {
                System.out.print("         ");
            } else {
                String cor = matriz[i][j].getCor();
                String texto = matriz[i][j].element() + "[" + cor + "]";
                if ("RUBRO".equals(cor)) {
                    System.out.print(VERMELHO + texto + RESET);
                } else {
                    System.out.print(texto);
                }
            }
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
        return node.leftChild() != null || node.rightChild() != null;
    }

    public boolean isExternal(No node) {
        return !this.isInternal(node);
    }

}