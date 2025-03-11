package tapr.univille.com;
import java.lang.classfile.components.ClassPrinter.Node;
import java.util.List;
import java.util.*;
import java.util.LinkedList;

// Lista duplamente encadeada

// criar metodos:

// * adiciona 
// * print
// * print reverse

public class ListaEncadeada {
    private No inicio;
    private No fim;
    private int tamanho;

    public ListaEncadeada() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void adiciona(int valor) {
        No novo = new No(valor);
        if (this.inicio == null) {
            this.inicio = novo;
            this.fim = novo;
        } else {
            this.fim.setProximo(novo);
            novo.setAnterior(this.fim);
            this.fim = novo;
        }
        this.tamanho++;
    }

    public void print() {
        No aux = this.inicio;
        while (aux != null) {
            System.out.println(aux.getValor());
            aux = aux.getProximo();
        }
    }

    public void printReverse() {
        No aux = this.fim;
        while (aux != null) {
            System.out.println(aux.getValor());
            aux = aux.getAnterior();
        }
    }

    public int getTamanho() {
        return this.tamanho;
    }

     public static void main(String[] args) {
         ListaEncadeada lista = new ListaEncadeada();
         lista.adiciona(1);
         lista.adiciona(2);
         lista.adiciona(3);
         lista.adiciona(4);
         lista.adiciona(5);
         lista.print();
         System.out.println("Tamanho: " + lista.getTamanho());
         lista.printReverse();
     }
}