package ArvoreBinariaPesquisa;

import java.util.ArrayList;
import java.util.Iterator;

import Comparador.Comparador;
import Interfaces.IArvoreBinariaPesquisa;
import Node.No;

public class ArvoreBinariaPesquisa implements IArvoreBinariaPesquisa {
    private No root;
    private int size;
    No node;
    private Comparador comparador;

    public ArvoreBinariaPesquisa() {

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

        // nó com um filho
        if (toRemove.hasRightChild()) {
            if (toRemove.rightChild().isExternal()) {
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
        if (sucessor.hasRightChild() && !sucessor.hasLeftChild()) {
            toRemove.setRightChild(sucessor.rightChild());
            return toRemoveElement;
        }
        No rightChildSucessor = sucessor.rightChild();
        No parentSucessor = sucessor.parent();
        parentSucessor.setLeftChild(rightChildSucessor);

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
        if (no == null) {
            return;
        }

        if (no.isInternal())
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

        if (no.isInternal()) {
            emOrdem(no.rightChild());
        }
    }

    @Override
    public void preOrdem(No no) {
        if (no != null) {
            System.out.println(no.element());
            no.setChilds();
            Iterator<No> childs = no.childs();
            while (childs.hasNext()) {
                No child = childs.next();
                preOrdem(child);
            }
        } else
            System.out.println("null");

    }

    @Override
    public void posOrdem(No no) {
        if (no != null) {
            no.setChilds();
            Iterator<No> childs = no.childs();
            while (childs.hasNext()) {
                No child = childs.next();
                preOrdem(child);
            }
            System.out.println(no.element());
        } else
            System.out.println("null");

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
    
    @Override
    public void mostrar() {
        int h = altura(root);
        int nLinhas = h + 1;
        double nColunas = 2 * Math.pow(2, h) + 1;

        Object[][] tabela = new Object[nLinhas][(int) nColunas];
        preencheTabela(root, tabela, (int) nColunas);

        for (int i = 0; i < nLinhas; i++) {
            for (int j = 0; j < (int) nColunas; j++) {
                if (tabela[i][j] == null)
                    System.out.print(" ");
                else
                    System.out.print(" " + tabela[i][j] + " ");

            }
            System.out.println();
        }
    }

    private void preencheTabela(No no, Object[][] tabela, int nColunas) {
        if (no != null) {
            int coluna = coluna(no, nColunas, tabela);
            tabela[profundidade(no)][coluna] = no.element();
            no.setChilds();
            Iterator<No> childs = no.childs();
            while (childs.hasNext()) {
                No child = childs.next();
                preencheTabela(child, tabela, nColunas);
            }
        }
    }

    private int coluna(No no, int nColunas, Object[][] tabela) {
        int coluna = 0;
        if (no.equals(root)) {
            coluna = (nColunas / 2) + 1;
            no.setPos(coluna);
            return coluna;
        }

        if (no.parent().hasLeftChild() && no.element().equals(no.parent().leftChild().element())) {
            int colunaParent = no.parent().pos();
            coluna = colunaParent - 1;
            no.setPos(coluna);
            return coluna;
        }

        if (no.parent().hasRightChild() && no.element().equals(no.parent().rightChild().element())) {
            int colunaParent = no.parent().pos();
            coluna = colunaParent + 2;
            if (tabela[profundidade(no)][coluna] != null)
                coluna = coluna + 1;
            no.setPos(coluna);
            return coluna;
        }
        return coluna;
    }

    @Override
    public Iterator<No> Nos() {
        ArrayList<No> arrayNode = new ArrayList<No>();
        createNosList(root, arrayNode);
        return arrayNode.iterator();
    }

    private void createNosList(No node, ArrayList<No> arrayNode) {
        if (node.isInternal())
            createNosList(node.leftChild(), arrayNode);
        arrayNode.add(node);
        if (node.isInternal()) {
            createNosList(node.rightChild(), arrayNode);
        }
    }

    private void createElementsList(No node, ArrayList<Object> arrayElement) {
        if (node.isInternal())
            createElementsList(node.leftChild(), arrayElement);
        arrayElement.add(node);
        if (node.isInternal()) {
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
        return this.size == 0;
    }

}