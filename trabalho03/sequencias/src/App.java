import sequencia.Array.Array;

public class App {
    public static void main(String[] args) throws Exception {
        Array array = new Array();
        array.removeAtRank(30);
        for(int i = 0; i < 10; i++){
            array.insertAtRank(i, i+5);
        }
        System.out.println(array.elementAtRank(2));
        array.printList();
        Object elementoRemovido = array.replaceAtRank(3, 21);
        System.out.println("Elemento removido por replace: " + elementoRemovido);
        array.printList();
        System.out.println("Operação de insertAtRank");
        array.insertAtRank(4, 78);
        array.printList();
        System.out.println("Operação de insertAfter");
        array.insertAfter(3, 88);
        array.printList();
        System.out.println("Operação de insertBefore");
        array.insertBefore(10, 101);
        array.printList();
        System.out.println("Operação de insertFirst");
        array.insertFirst(10010);
        array.printList();
        array.retornaSize();
        System.out.println("Operação de insertLast");
        array.insertLast(8080);
        array.printList();
        System.out.println("Operação de insertLast");
        array.insertLast(8080);
        array.printList();
    }
}
