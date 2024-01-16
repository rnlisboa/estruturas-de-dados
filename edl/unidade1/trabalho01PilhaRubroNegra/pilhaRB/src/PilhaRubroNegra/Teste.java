package PilhaRubroNegra;

public class Teste {
    public static void main(String[] args) {
        PilhaRubroNegra pRubroNegra = new PilhaRubroNegra(2);

        pRubroNegra.pushBlack(10);
        pRubroNegra.pushRed(20);
        pRubroNegra.pushBlack(77);
        pRubroNegra.pushBlack(18);
        pRubroNegra.pushRed(35);
        pRubroNegra.pushRed(78);
        pRubroNegra.pushBlack(5);

        pRubroNegra.printRedBlackStack();
    }
}
