package FilaPrioridade;

public class Teste {
    public static void main(String[] args) {
        FilaPrioridade fp = new FilaPrioridade();
        fp.insert(10, "A");
        fp.insert(30, "B");
        fp.insert(2, "C");
        fp.insert(25, "D");
        fp.insert(16, "E");

        fp.print();
    }

}
