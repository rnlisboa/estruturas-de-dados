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

        System.out.println("Size: " + sequencia.size());
        System.out.println("isEmpty: " + sequencia.isEmpty());
        System.out.println("first: " + sequencia.first());
        System.out.println("last: " + sequencia.last());
        System.out.println("before(80): " + sequencia.before(80));
        System.out.println("after(80): " + sequencia.after(80));


        sequencia.printList();

        System.out.println("Remove(90): " + sequencia.remove(90));

        sequencia.printList();

        sequencia.insertAtRank(3, 4545);
        sequencia.printList();
    }
}
