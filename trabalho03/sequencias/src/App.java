import listImplements.ListaEncadeada.ListaEncadeada;

public class App {
    public static void main(String[] args) throws Exception {
        ListaEncadeada lista = new ListaEncadeada();
        
        // Inserir alguns elementos na lista
        for (int i = 0; i <= 100; i += 10) {
            lista.insertLast(i);
        }
        
        System.out.println("Lista inicial:");
        lista.printList();
        
        System.out.println("Chamando o método insertAfter(30, 60):");
        lista.insertAfter(30, 60);
        lista.printList();
        
        System.out.println("Chamando o método insertBefore(60, 50):");
        lista.insertBefore(60, 50);
        lista.printList();

        System.out.println("Chamando o método replaceElement(50, 55):");
        lista.replaceElement(50, 55);
        lista.printList();
        
        System.out.println("Chamando o método swapElements(55, 40):");
        lista.swapElements(55, 40);
        lista.printList();
        
        System.out.println("Chamando o método remove(60):");
        lista.remove(60);
        lista.printList();

        System.out.println("Chamando o método insertFirst(554):");
        lista.insertFirst(554);
        lista.printList();

        System.out.println("Chamando o método before(70):");
        System.out.println(lista.before(70));

        System.out.println("Chamando o método after(70):");
        lista.after(70);
        System.out.println(lista.after(70));
    }
}
