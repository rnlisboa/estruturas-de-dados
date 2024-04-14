package Sequencia;

public class Teste {
    public static void main(String[] args) {
        Sequencia sequencia = new Sequencia();

        for(int i = 0; i <= 100; i+=10)
            sequencia.insertLast(i);
        sequencia.printList();
        sequencia.insertAfter(sequencia.findNode(23), 15);
        sequencia.printList();

        System.out.println("Size: " + sequencia.size());
        System.out.println("isEmpty: " + sequencia.isEmpty());
        System.out.println("first: " + sequencia.first());
        System.out.println("last: " + sequencia.last());
        System.out.println("before(80): " + sequencia.before(sequencia.findNode(80)));
        System.out.println("after(80): " + sequencia.after(sequencia.findNode(80)));


        sequencia.printList();

        System.out.println("Remove(90): " + sequencia.remove(sequencia.findNode(90)));

        sequencia.printList();

        sequencia.insertAtRank(3, 4545);
        sequencia.printList();
    }
}
