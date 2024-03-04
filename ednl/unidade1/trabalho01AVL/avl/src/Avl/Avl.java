package Avl;

import AbpTree.AbpTree;
import InterfacesAVL.IAVL;
import ItemAVl.Item;
import NodeABP.NodeABP;

public class Avl extends AbpTree implements IAVL {

    public Avl(Item item) {
        super(item);
    }

    public NodeABP insertItem(Item i) {
        NodeABP novo = this.incluir(i);
        int h = this.altura(novo);
        novo.setHeitgh(h);

        rebalance(novo);
        return novo;
    }

    @Override
    public void rebalance(NodeABP node) {
        NodeABP atual = node;
        NodeABP pai = atual.parent();
        NodeABP avo = pai.parent();
        while (!atual.equals(this.root())) {
            if (!isBalanced(atual)) {
                if (isLeftPending(avo) && pai.leftChild().equals(atual))
                    doubleRotateRight(atual);
            } else {
                atual = pai;
            }

        }

    }

    @Override
    public boolean isBalanced(NodeABP node) {
        int bf = this.altura(node.leftChild()) - this.altura(node.rightChild());
        return (-1 <= bf) && (bf <= 1);
    }

    @Override
    public boolean isRightPending(NodeABP node) {
        return this.altura(node.leftChild()) - this.altura(node.rightChild()) == -1;
    }

    @Override
    public boolean isLeftPending(NodeABP node) {
        return this.altura(node.leftChild()) - this.altura(node.rightChild()) == 1;
    }

    @Override
    public void rotateRight(NodeABP node) {
        NodeABP pai = node.parent();
        NodeABP avo = pai.parent();
        pai.setRightChild(avo);
    }

    @Override
    public void rotateleft(NodeABP node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rotateleft'");
    }

    @Override
    public void doubleRotateRight(NodeABP node) {
    
    }

    @Override
    public void doubleRotateleft(NodeABP node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doubleRotateleft'");
    }

    public void showIsBalanced(NodeABP n) {
        System.out.println(n.element().toString() + " " + isBalanced(n));
        // System.out.println(n.element().toString() + " " + this.altura(n));
        if (n.equals(this.root)) {
            return;
        }
        ;
        showIsBalanced(n.parent());
    }

    @Override
    public NodeABP tallerChild(NodeABP node) {
        if (this.altura(node.leftChild()) >= this.altura(node.rightChild()))
            return node.leftChild();
        else
            return node.rightChild();
    }

}
