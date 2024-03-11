public class Teste {
    public static void main(String[] args) throws Exception {
        //int r = produto(5, 10);
        int c = combinacao(40, 4);
        System.out.println(c);
    }

    public static int produto(int m, int n){
        //5x3 = 5+5+5 = 15
        if(n == 1) return m;
        return m + produto(m,n = n-1);
    }

    public static int combinacao(int n, int k) {
        int numerador = fatorial(n);
        int denominador = fatorial(k) * (fatorial(n - k));

        return numerador / denominador;
    }

    public static int fatorial(int n){
        if(n == 1) return 1;
        return n * fatorial(n=n-1);
    }
}
