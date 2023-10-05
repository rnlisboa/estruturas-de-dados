import listImplements.Lista.Lista;

public class App {
    public static void main(String[] args) throws Exception {
        Lista lista = new Lista();
        
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
    }
}
