package FilaDuasPilhas;

public class Teste {
    public static void main(String[] args) {
        FilaDuasPilhas fDuasPilhas = new FilaDuasPilhas(2);
        fDuasPilhas.enqueue(10);
        fDuasPilhas.enqueue(20);
        fDuasPilhas.enqueue(30);
        fDuasPilhas.enqueue(40);
        fDuasPilhas.enqueue(50);

        fDuasPilhas.print();

        System.out.println(fDuasPilhas.first());
        fDuasPilhas.print();
    }
}
