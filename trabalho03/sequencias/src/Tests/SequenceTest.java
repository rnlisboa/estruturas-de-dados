package Tests;

import sequenceImplements.Sequencia.Sequencia;

public class SequenceTest {
    public static void main(String[] args) {
        Sequencia sequencia = new Sequencia();

        for(int i = 0; i <= 100; i+=10)
            sequencia.insertLast(i);
        sequencia.printList();
        sequencia.insertAfter(0, 15);
        sequencia.printList();

        // System.out.println("Size: " + sequencia.size());
        // System.out.println("isEmpty: " + sequencia.isEmpty());
        // System.out.println("first: " + sequencia.first());
        // System.out.println("last: " + sequencia.last());
        // System.out.println("before(80): " + sequencia.before(75));
        // System.out.println("after(75): " + sequencia.after(75));

        // sequencia.replaceElement(75, 99);
        // sequencia.swapElements(80, 99);

        // sequencia.printList();

        // System.out.println("Remove(99): " + sequencia.remove(99));

        // sequencia.printList();
    }
}
