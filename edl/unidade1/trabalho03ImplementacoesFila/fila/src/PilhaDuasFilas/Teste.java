package PilhaDuasFilas;

public class Teste {
    public static void main(String[] args) {
        PilhaDuasFilas pDuasFilas = new PilhaDuasFilas(2);
        pDuasFilas.push(10);
        pDuasFilas.push(20);
        pDuasFilas.push(30);
        pDuasFilas.push(40);
        pDuasFilas.push(50);

        pDuasFilas.print();
        
        System.out.println(pDuasFilas.pop());
        System.out.println(pDuasFilas.pop());
        pDuasFilas.print();


        
    }
}
