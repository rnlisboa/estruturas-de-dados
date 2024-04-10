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

    public Node getLastNode() {
        return this.lastNode;
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

    public Item removeMin() {
        Item min = this.root.element();
        if (this.lastNode.equals(root)) {
            this.root = null;
            return min;
        }

        Node parentLastNode = this.lastNode.parent();
        boolean lastNodeIsLeftChild = parentLastNode.leftChild().equals(this.lastNode);
        if (lastNodeIsLeftChild) {
            this.root.setValue(this.lastNode.element());
            downHeap(this.root);
            atualizarUltimoNo(this.lastNode);
            parentLastNode.setLeftChild(null);
        } else {
            this.root.setValue(this.lastNode.element());
            downHeap(this.root);
            atualizarUltimoNo(this.lastNode);
            parentLastNode.setRightChild(null);
        }

        return min;
    }

    private void downHeap(Node node) {
        Node atual = node;
        while (isInternal(atual)) {
            Object atualKey = atual.element().key();
            Object letftKey = atual.leftChild().element().key();
            this.comp = new Comparador(atualKey, letftKey);
            int compAE = this.comp.comparer();

            if (atual.hasRightChild()) {
                Object rightKey = atual.rightChild().element().key();
                this.comp = new Comparador(atualKey, rightKey);
                int compAD = this.comp.comparer();
                this.comp = new Comparador(letftKey, rightKey);
                int compED = this.comp.comparer();

                if (compED >= 0) {
                    if (compAD >= 0) {
                        swap(atual, atual.rightChild());
                        atual = atual.rightChild();
                    }
                } else {
                    if (compAE >= 0) {
                        swap(atual, atual.leftChild());
                        atual = atual.leftChild();
                    }
                }
            } else {
                if (compAE >= 0) {
                    swap(atual, atual.leftChild());
                    atual = atual.leftChild();
                }
            }

        }
    }

    private void atualizarUltimoNo(Node lastNode) {
        Node atual = lastNode;
        while (atual != root) {
            Node parent = atual.parent();
            Node parentRightChild = parent.rightChild();
            boolean isRightChild = atual.equals(parentRightChild);
            if (isRightChild) {
                boolean parentRightChildIsNotNull = atual.parent().leftChild() != null;
                if (parentRightChildIsNotNull) {
                    atual = atual.parent().leftChild();
                    break;
                } else {
                    atual = atual.parent();
                }
            } else {
                atual = atual.parent();
            }
        }

        while (atual.hasRightChild()) {
            atual = atual.rightChild();
        }

        this.lastNode = atual;
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

    public int profundidade(Node no) {
        if (no.equals(this.root))
            return 0;
        return 1 + profundidade(no.parent());
    }

    private int emOrdemMatriz(Node[][] matriz, Node no, int i){
        if(no.hasLeftChild()){
            i = emOrdemMatriz(matriz, no.leftChild(), i);
        }
        i++;
        matriz[profundidade(no)][i] = no;
        if(no.hasRightChild()){
            i = emOrdemMatriz(matriz, no.rightChild(), i);
        }

        return i;
    }

    public void mostrar(){
        int qtdLinhas = altura(root) + 1;
        int qtdColunas = (int)Math.pow(2, qtdLinhas);
        Node[][] matriz = new Node[qtdLinhas][qtdColunas];
        this.emOrdemMatriz(matriz, root, 0);
        for (int i = 0; i < qtdLinhas; i++) {
            for (int j = 0; j < qtdColunas; j++) {
                if (matriz[i][j] == null)
                    System.out.print("    ");
                else
                    System.out.print("(" + matriz[i][j].element().key() + ", " + matriz[i][j].element().value() + ")");
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
}
