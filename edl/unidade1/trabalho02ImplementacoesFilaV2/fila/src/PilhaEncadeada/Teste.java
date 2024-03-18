package PilhaEncadeada;

public class Teste {
    public static void main(String[] args) {
        Pilha p = new Pilha();
        //p.pop();
        p.push(10);
        p.push(40);
        p.push(980);
        p.push(45);
        p.push(17);

        System.out.println(p);
        p.pop();
        System.out.println(p);
        System.out.println(p.top());
    }
}
