package EXPilha.PilhaEncadeada;

public class Teste {
    public static void main(String[] args) {
        PilhaEncadeada pilhaEncadeada = new PilhaEncadeada();
        for( int i = 10; i < 100; i+=10){
            pilhaEncadeada.push(i);
        }

        pilhaEncadeada.print();
    }
}
