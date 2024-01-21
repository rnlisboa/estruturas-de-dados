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
    }

    public Node root() {
        return this.root;
    }

    public Node lastNode() {
        return lastNode;
    }

    public void insert(Item item) {
        Node newNode = new Node(item);
        findLastNode(this.lastNode, newNode);
        heapUp(this.root);
        size++;
    }

    private Node findLastNode(Node node, Node newNode) {
        if (!node.equals(root) && node.equals(node.parent().rightChild())) {
            node = findRec(node);
        }
        if (node.hasLeftChild() && !node.hasRightChild()) {
            node.setRightChild(newNode);
            newNode.setParent(node);
            this.lastNode = newNode;
        } else if (!node.hasLeftChild()) {
            node.setLeftChild(newNode);
            newNode.setParent(node);
            this.lastNode = node;
        }
        return node;
    }

    private Node findRec(Node node) {
        if (node.equals(root) || node.equals(node.parent().leftChild())) {
            if (node.hasLeftChild()) {
                if(node.equals(root)){}
                return findRec(node.leftChild());
            } else {
                return node;
            }
        } else {
            return findRec(node.parent());
        }
    }

    private void heapUp(Node node) {
        if (node != root) {
            this.comp = new Comparador(node.element().key(), node.parent().element().key());
            int comparado = this.comp.comparer();
            while (node.parent() != null && comparado > 0) {
                swap(node, node.parent());
                node = node.parent();
                this.comp = new Comparador(node.element().key(), node.parent().element().key());
                comparado = this.comp.comparer();
            }
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
        if (node == root) {
            System.out.println(node.element().key() + " pai na esquerda de " + node.leftChild().element().key()
                    + " e na direita de " + node.rightChild().element().key());
        } else {
            if (node.hasLeftChild() && node.hasRightChild()) {
                System.out.println(node.element().key() + "  pai na esquerda de " + node.leftChild().element().key()
                        + " e na direita de "
                        + node.rightChild().element().key());
            } else if (node.hasLeftChild() && !node.hasRightChild()) {
                System.out.println(node.element().key() + "  pai na esquerda de " + node.leftChild().element().key());
            } else if (!node.hasLeftChild() && node.hasRightChild()) {
                System.out.println(node.element().key() + " filho de " + node.parent().element().key()
                        + " e pai na direita de " + node.rightChild().element().key());
            }
        }
        if (node != null) {
            if (isInternal(node))
                emOrdem(node.leftChild());
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
                    System.out.print(" ");
                else
                    System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isInternal(Node node) {
        boolean hasLeftChild = node.hasLeftChild();
        boolean hasRightChild = node.hasRightChild();
        boolean isInternal = hasLeftChild || hasRightChild;
        return isInternal;
    }

    public Node removeMin() {
        Node min = this.root;
        return min;
    }
}
