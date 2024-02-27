import java.util.Date;

import EXPilha.Pilha;

public class App {
    public static void main(String[] args) throws Exception {
        /*************** Q1 **************************** */
            /*
            *  Descreva o estado da pilha (inicialmente vazia) após cada uma das operações a seguir (Esta questão é a mesma
                da R-4.1 do livro).
                push(5), push(3), pop(), push(2), push(8), pop(), pop(), push(9), push(1), pop(), push(7), push(6), pop(), pop(),
                push(4), pop(), pop().
            */
            /*
            * [5]
            * [5,3]
            * [5]
            * [5,2]
            * [5,2,8]
            * [5,2]
            * [5]
            * [5,9]
            * [5,9,1]
            * [5,9]
            * [5,9,7]
            * [5,9,7,6]
            * [5,9,7]
            * [5,9]
            * [5,9,4]
            * [5,9]
            * [5]
            */
        //****************************************** */

        /****************** Q2 */
        Pilha pilha = new Pilha(1, 0, 10);
        long inicio = System.currentTimeMillis();
        for(int i = 0; i<= 1000000; i++){
            pilha.push(1);
        }
        long fim = System.currentTimeMillis();
        System.out.println((fim - inicio)/1000);
        /** tamanho  tempo(s)
         *           c = 10  c = 100   c = 1000 duplicação
         * 10 lem      0        0          0       0
         * 100 lem     0        0          0       0
         * 1000 lem    0        0          0       0
         * 10000 lem   0        0          0       0
         * 100000 lem  2        0          0       0
         * 1000000 lem *        *          9       0
         */

    }
}
