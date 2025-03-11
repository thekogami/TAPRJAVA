package tapr.univille.com;

// Fila, Desenvolva a fila com os metodos add e remove.

// Sugestao: use uma implementacxao de circular.

public class Fila {
    private int[] fila;
    private int inicio;
    private int fim;
    private int tamanho;
    private int capacidade;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
        this.fila = new int[capacidade];
        this.inicio = 0;
        this.fim = -1;
        this.tamanho = 0;
    }

    public void add(int i) {
        if (tamanho == capacidade) {
            throw new IllegalStateException("Fila cheia");
        }
        fim = (fim + 1) % capacidade;
        fila[fim] = i;
        tamanho++;
    }

    public int remove() {
        if (tamanho == 0) {
            throw new IllegalStateException("Fila vazia");
        }
        int elementoRemovido = fila[inicio];
        inicio = (inicio + 1) % capacidade;
        tamanho--;
        return elementoRemovido;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public boolean isFull() {
        return tamanho == capacidade;
    }

    public int size() {
        return tamanho;
    }
}