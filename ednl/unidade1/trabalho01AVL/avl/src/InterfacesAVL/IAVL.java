package InterfacesAVL;

import NodeABP.NodeABP;

public interface IAVL {
    public boolean isBalanced(NodeABP node);
    public boolean isRightPending(NodeABP node);
    public boolean isLeftPending(NodeABP node);
    public void rebalance(NodeABP node);
    public void rotateRight(NodeABP node);
    public void rotateleft(NodeABP node);
    public void doubleRotateRight(NodeABP node);
    public void doubleRotateleft(NodeABP node);
    public NodeABP tallerChild(NodeABP node);
}
