package ArvoreBinariaPesquisa;

public class TesteABP {
    public static void main(String[] args) {
        ArvoreBinariaPesquisa abp = new ArvoreBinariaPesquisa(10);
        abp.incluir(5);
        abp.incluir(15);
        abp.incluir(2);
        abp.incluir(22);
        abp.incluir(8);
        abp.incluir(25);

        abp.mostrar();
    }
}
