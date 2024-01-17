public class App {
    public static void main(String[] args) throws Exception {
        // Teste 1: Criar uma tabela hash
        TabelaHash tabela = new TabelaHash(13);

        // Teste 2: Inserir elementos
        tabela.inserir(1, "Valor1");
        tabela.inserir(11, "Valor2"); // Deverá acionar redimensionamento
        tabela.inserir(21, "Valor3");
        tabela.inserir(31, "Valor4");
        tabela.inserir(41, "Valor5");
        tabela.inserir(51, "Valor6");
        tabela.inserir(71, "Valor7");
        tabela.inserir(66, "Valor8");

        // Teste 3: Pesquisar por chave
        System.out.println("Valor associado à chave 21: " + tabela.pesquisarPorChave(21));

        // Teste 4: Pesquisar por chave e valor
        Item itemPesquisado = tabela.pesquisarPorChaveValor(11, "Valor2");
        System.out.println("Item associado à chave 11 e valor 'Valor2': " + itemPesquisado);

        // Teste 5: Remover elemento
        tabela.remover(11, "Valor2");
        System.out.println("Após remover o item associado à chave 11 e valor 'Valor2':");
        System.out
                .println("Item associado à chave 11 e valor 'Valor2': " + tabela.pesquisarPorChaveValor(11, "Valor2"));

        // Teste 6: Redimensionamento automático
        tabela.inserir(61, "NovoValor"); // Deverá acionar redimensionamento
        System.out.println("Valor associado à chave 61 após redimensionamento: " + tabela.pesquisarPorChave(61));

        // Teste 7: Exibir estado final da tabela
        System.out.println("Estado final da tabela:");
        for (int i = 0; i < tabela.getCapacidade(); i++) {
            System.out.println("Índice " + i + ": " + tabela.getArray()[i]);
        }
    }
}

class TabelaHash {
    private static final Item AVAILABLE = new Item();
    private int tam;
    private int capacidade;
    private Item[] array;

    public TabelaHash(int capacidade) {
        this.capacidade = capacidade;
        this.tam = 0;
        this.array = new Item[capacidade];
    }

    private int hash(int key) {
        return key % capacidade;
    }

    private int hashingDuplo(int indice) {
        return 7 - (indice % 7);
    }

    // Metodos para mostrar
    public int getCapacidade() {
        return capacidade;
    }

    // Metodos para mostrar
    public Item[] getArray() {
        return array;
    }

    private boolean ehPrimo(int numero) {
        // Verifica se o número é 2 (único número primo par)
        if (numero == 2) {
            return true;
        }

        // Verifica se o número é par ou menor que 2 (não é primo)
        if (numero % 2 == 0 || numero < 2) {
            return false;
        }

        // Verifica divisibilidade até a raiz quadrada do número
        int limite = (int) Math.sqrt(numero) + 1;
        for (int i = 3; i < limite; i += 2) {
            if (numero % i == 0) {
                // O número é divisível por i, portanto não é primo
                return false;
            }
        }

        // Se nenhum divisor foi encontrado, o número é primo
        return true;
    }

    private int pegaProximoPrimo(int valor) {
        while (ehPrimo(valor) != true) {
            valor++;
        }

        return valor;
    };

    private void redimensionar() {
        int novaCapacidade = capacidade * 2;
        // Capacidade recebe o proximo primo depois do dobro
        int novaCapacidadePrimo = pegaProximoPrimo(novaCapacidade);
        Item[] novoArray = new Item[novaCapacidadePrimo];

        // Faz a cópia
        for (int i = 0; i < capacidade; i++) {
            if (array[i] != null) {
                // Recalcula o hash visto que o tamanho mudou, logo o valor
                // do hash muda
                int novoHash = hash((int) array[i].getKey());
                int indice = novoHash;

                while (novoArray[indice] != null) {
                    // Pula as colisões
                    indice = hashingDuplo(indice);
                }

                novoArray[indice] = array[i];
            }
        }

        // Atualiza os ponteiros
        array = novoArray;
        capacidade = novaCapacidadePrimo;
    }

    public void inserir(int chave, Object valor) {
        // Verifica se o tamanho ja está chegando na metade da capacidade
        // Se sim dobra pois começaria a perder eficiencia
        if ((double) tam / capacidade > 0.5) {
            redimensionar();
        }

        int indice = hash(chave);

        // Enquanto nao encontrar um espaço vazio, utiliza o linear hashingDuplo
        while (array[indice] != null) {
            // Ja está ocupado
            indice = hashingDuplo(indice);
        }

        // Cria a instancia de um novo item, atribui chave valor a ele e
        // insere no array de acordo com o indice
        Item novoItem = new Item();
        novoItem.setKey(chave);
        novoItem.setValue(valor);
        array[indice] = novoItem;
        tam++;
    }

    public void remover(int chave, Object valor) {
        int indice = hash(chave);

        while (array[indice] != null && array[indice] != AVAILABLE) {
            if (array[indice].getKey() == chave && array[indice].getValue().equals(valor)) {
                // Marca o espaço como disponível
                array[indice] = AVAILABLE;
                tam--;
                return;
            }

            indice = hashingDuplo(indice);
        }
    }

    public Object pesquisarPorChave(int chave) {
        int indice = hash(chave);

        while (array[indice] != null && array[indice] != AVAILABLE) {
            // Se encontrou a chave, retorna o valor associado
            if (array[indice].getKey() == chave) {
                return array[indice].getValue();
            }

            // Se n encontrou a chave passa para o proximo
            indice = hashingDuplo(indice);
        }

        // Chave não encontrada
        return null;
    }

    public Item pesquisarPorChaveValor(int chave, Object valor) {
        int indice = hash(chave);

        while (array[indice] != null && array[indice] != AVAILABLE) {
            // Se encontrou a chave e o valor coincidir, retorna o Item associado
            if (array[indice].getKey() == chave && array[indice].getValue().equals(valor)) {
                return array[indice];
            }

            indice = hashingDuplo(indice);
        }

        // Chave e/ou valor não encontrados
        return null;
    }
}

class Item {
    private int key;
    private Object value;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Item{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}