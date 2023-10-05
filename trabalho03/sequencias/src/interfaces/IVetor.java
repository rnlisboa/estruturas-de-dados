package interfaces;

public interface IVetor {
    public Object elementAtRank(int r);
    public Object replaceAtRank(int r, Object o);
    public void insertAtRank(int r, Object o);
    public Object removeAtRank(int r);
    public void insertBefore(int r, Object o);
    public void insertAfter(int r, Object o);
    public void insertFirst(Object o);
    public void insertLast(Object o);
}
