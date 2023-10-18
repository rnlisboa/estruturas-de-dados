package Pilha;

public class teste {
    public static void main(String[] args) {
        Pilha pilha = new Pilha();
        Pilha pilha2 = new Pilha();

        for (int i = 1; i <= 5; i++)
            pilha.push(i);
        
        for (int i = 10; i <= 50; i+=10)
            pilha2.push(i);
        
        System.out.print("Pilha1 ");
        pilha.print();
        
        System.out.print("Pilha2 ");
        pilha2.print();

        pilha.adicionaPilha(pilha2);
        pilha.print();
        System.out.print("Pilha2 ");
        pilha2.print();
    }
}
