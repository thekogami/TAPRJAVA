package tapr.univille.com;

// crie tabela hash de 10 posisoes onde cada posicao tem uma lista encadeada

public class TabelaHash {
    private ListaEncadeada[] tabela;
    private int tamanho;

    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new ListaEncadeada[tamanho];
        for (int i = 0; i < tamanho; i++) {
            this.tabela[i] = new ListaEncadeada();
        }
    }

    public void adiciona(int valor) {
        int posicao = valor % this.tamanho;
        this.tabela[posicao].adiciona(valor);
    }

    public void print() {
        for (int i = 0; i < this.tamanho; i++) {
            System.out.println("Posição " + i + ":");
            this.tabela[i].print();
        }
    }

    public static void main(String[] args) {
        TabelaHash tabela = new TabelaHash(10);
        tabela.adiciona(10);
        tabela.adiciona(20);
        tabela.adiciona(30);
        tabela.adiciona(40);
        tabela.adiciona(50);
        tabela.adiciona(60);
        tabela.adiciona(70);
        tabela.adiciona(80);
        tabela.adiciona(90);
        tabela.adiciona(100);
        tabela.adiciona(110);
        tabela.adiciona(120);
        tabela.adiciona(130);
        tabela.adiciona(140);
        tabela.adiciona(150);
        tabela.adiciona(160);
        tabela.adiciona(170);
        tabela.adiciona(180);
        tabela.adiciona(190);
        tabela.adiciona(200);
        tabela.print();
    }
}
