package Vetor;
public class Teste {
    public static void main(String[] args) {
        Vetor vetor = new Vetor();

        vetor.insertAtRank(0, "A");
        vetor.insertAtRank(1, "B");
        vetor.insertAtRank(2, "C");

        vetor.replaceAtRank(1, "D");
        vetor.replaceAtRank(2, "E");

        vetor.printList(); 
        vetor.removeAtRank(1);
        vetor.printList(); 
    }
}
