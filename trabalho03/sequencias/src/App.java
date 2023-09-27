import sequencia.Array.Array;

public class App {
    public static void main(String[] args) throws Exception {
        Array array = new Array();

        for(int i = 0; i < 10; i++){
            array.insertAtRank(i, i+5);
        }
        System.out.println(array.elementAtRank(2));
        array.printList();
        Object elementoRemovido = array.replaceAtRank(3, 21);
        System.out.println("Elemento removido por replace: " + elementoRemovido);
        array.printList();
        System.out.println("Operação de inserir");
        array.insertAtRank(4, 78);
        array.printList();
    }
}
