import sequencia.Lista.Lista;
import sequencia.VetorEncadeado.VetorEncadeado;

public class App {
    public static void main(String[] args) throws Exception {
        // VetorEncadeado vetorEncadeado = new VetorEncadeado();
        // vetorEncadeado.setInitialState();
        // for(int i = 1; i <= 100; i+=10)
        //     vetorEncadeado.insertLast(i);
        // vetorEncadeado.print();
        // vetorEncadeado.insertAtRank(0, 171);
        // vetorEncadeado.insertAfter(5, 555);
        // vetorEncadeado.insertBefore(7, 777);
        // vetorEncadeado.replaceAtRank(10, 1111);
        // vetorEncadeado.removeAtRank(3);
        // vetorEncadeado.insertFirst(29);
        // vetorEncadeado.print();

        Lista lista = new Lista();
        for(int i=0; i<=100; i+=10){
            lista.insertLast(i);
        }

        lista.printList();
        lista.insertAfter(30, 60);
        lista.printList();
    }
}
