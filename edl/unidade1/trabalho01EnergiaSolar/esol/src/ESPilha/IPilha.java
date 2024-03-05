package ESPilha;

public interface IPilha {
    public Object top();
    public Object pop();
    public Object push(Object o);
    public int size();
    public boolean isEmpty();
}
