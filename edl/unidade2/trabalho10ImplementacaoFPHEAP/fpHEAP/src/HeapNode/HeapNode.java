package HeapNode;

import Comparador.Comparador;
import Item.Item;
import NodeHeap.Node;

public class HeapNode {
    private Node root;
    private Node lastNode;
    private Comparador comp;
    private int size;

    public HeapNode(Item item) {
        Node novo = new Node(item);
        this.root = novo;
        this.lastNode = this.root;
        this.size++;
    }

    public Node root() {
        return this.root;
    }

    public Node lastNode() {
        return lastNode;
    }

    public void insert(Item item) {
        Node newNode = new Node(item);
        Node parent = findParentLastNode(this.lastNode);
        if (parent.hasLeftChild() && !parent.hasRightChild()) {
            parent.setRightChild(newNode);
        } else if (!parent.hasLeftChild()) {
            parent.setLeftChild(newNode);
        }

        newNode.setParent(parent);
        this.lastNode = newNode;
        this.size++;

        upHeap(this.lastNode);
    }

    private Node findParentLastNode(Node lastNode) {
        Node atual = lastNode;

        while (atual != root) {
            boolean isLeftChild = atual.equals(atual.parent().leftChild());
            if (isLeftChild) {
                boolean parentRightChildIsNotNull = atual.parent().rightChild() != null;
                if (parentRightChildIsNotNull) {
                    atual = atual.parent().rightChild();
                    break;
                } else {
                    return atual.parent();
                }
            } else {
                atual = atual.parent();
            }
        }

        while (atual.hasLeftChild()) {
            atual = atual.leftChild();
        }

        return atual;
    }

    private void upHeap(Node node) {
        Node atual = node;
        while (!atual.equals(this.root)) {
            Object atualKeyParent = atual.parent().element().key();
            Object atualKey = atual.element().key();

            this.comp = new Comparador(atualKey, atualKeyParent);
            int comparado = this.comp.comparer();
            if (comparado < 0) {
                swap(atual, atual.parent());
            }

            atual = atual.parent();
        }
    }

    private void swap(Node node1, Node node2) {
        Item temp = node1.element();
        node1.setValue(node2.element());
        node2.setValue(temp);
    }

    public int size() {
        return size;
    }

    public int altura(Node no) {
        if (no == null)
            return -1;
        int alturaDireita = altura(no.rightChild());
        int alturaEsquerda = altura(no.leftChild());

        return 1 + Math.max(alturaDireita, alturaEsquerda);
    }

    public void emOrdem(Node node) {
        if (node != null) {
            if (isInternal(node)) {
                emOrdem(node.leftChild());
            }
            if (node == root) {
                System.out.println(node.element().key() + " pai na esquerda de " + node.leftChild().element().key()
                        + " e na direita de " + node.rightChild().element().key());
            } else {
                if (node.hasLeftChild() && node.hasRightChild()) {
                    System.out.println(node.element().key() + "  pai na esquerda de " + node.leftChild().element().key()
                            + " e na direita de "
                            + node.rightChild().element().key());
                } else if (node.hasLeftChild() && !node.hasRightChild()) {
                    System.out
                            .println(node.element().key() + "  pai na esquerda de " + node.leftChild().element().key());
                } else if (!node.hasLeftChild() && node.hasRightChild()) {
                    System.out.println(node.element().key() + " filho de " + node.parent().element().key()
                            + " e pai na direita de " + node.rightChild().element().key());
                } else if (!node.hasLeftChild() && !node.hasRightChild()) {
                    System.out.println(node.element().key() + " filho de " + node.parent().element().key()
                            + " e sem filhos");
                }
            }
            if (isInternal(node)) {
                emOrdem(node.rightChild());
            }
        }

    }

    public int getcol(int h) {
        if (h == 1)
            return 1;
        return getcol(h - 1) + getcol(h - 1) + 1;
    }

    public void printTree(String[][] M, Node node, int col, int row, int height) {
        if (node == null)
            return;

        if (row < M.length && col < M[row].length) {
            M[row][col] = "(" + node.element().key() + "," + node.element().value() + ")";
            printTree(M, node.leftChild(), col - (int) Math.pow(2, height - 2), row + 1, height - 1);
            printTree(M, node.rightChild(), col + (int) Math.pow(2, height - 2), row + 1, height - 1);
        }
    }

    public void mostrar() {
        int h = altura(root);
        int col = getcol(h);
        String[][] M = new String[h][col];
        printTree(M, root, col / 2, 0, h);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < col; j++) {
                if (M[i][j] == null)
                    System.out.print("      ");
                else
                    System.out.print(M[i][j] + " ");
            }
            System.out.println();
            System.out.println();
        }
    }

    public boolean isInternal(Node node) {
        boolean hasLeftChild = node.hasLeftChild();
        boolean hasRightChild = node.hasRightChild();
        boolean isInternal = hasLeftChild || hasRightChild;
        return isInternal;
    }

    private void downHeap(Node node) {
        Node atual = node;
        while (atual != null) {

            if (atual.hasLeftChild()) {
                Object atualFilhoEsquerdoKey = atual.leftChild().element().key();
                Object atualFilhoDireitoKey = atual.rightChild().element().key();
                Object atualKey = atual.rightChild().element().key();

                this.comp = new Comparador(atualKey, atualFilhoEsquerdoKey);
                int compE = this.comp.comparer();

                if (compE > 0) {
                    swap(atual, atual.leftChild());
                    atual = atual.leftChild();
                } else if (atual.hasRightChild()) {
                    this.comp = new Comparador(atualKey, atualFilhoDireitoKey);
                    int compD = this.comp.comparer();
                    if (compD > 0) {
                        swap(atual, atual.rightChild());
                        atual = atual.rightChild();
                    }
                } else {
                    break;
                }

            } else {
                break;
            }

        }
    }

    public Item removeMin() {
        Item min = this.root.element();
        Node parentLastNode = this.lastNode.parent();
        if (parentLastNode.leftChild().equals(this.lastNode)) {
            parentLastNode.setLeftChild(null);
        } else {
            parentLastNode.setRightChild(null);
        }
        this.root.setValue(this.lastNode.element());
        downHeap(this.root);
        return min;
    }
}
