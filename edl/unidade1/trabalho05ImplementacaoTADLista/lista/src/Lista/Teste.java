package Lista;

public class Teste {
    public static void main(String[] args) {
        Lista l = new Lista();
        for (int i = 10; i <= 100; i+=10) l.insertLast(i);
        l.printList();
        l.swapElements(40, 70);
        l.printList();
    }
}
