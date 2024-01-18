package Interfaces;

public interface IVetor {
    public Object elementAtRank(int r);
    public Object replaceAtRank(int r, Object o);
    public void insertAtRank(int r, Object o);
    public Object removeAtRank(int r);
}
