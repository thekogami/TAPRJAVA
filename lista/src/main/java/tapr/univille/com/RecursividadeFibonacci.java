package tapr.univille.com;

// Faça uma funçao recursiva que imprima o enésimo valor da sequencia de fibonatti
// com Memoization

public class RecursividadeFibonacci {

  private static int cont;
  private static int[] memo;

  public static void main(String[] args) {
    int n = 50;
    memo = new int[n + 1]; // Array para armazenar os valores já calculados
    for (int i = 0; i <= n; i++) {
      memo[i] = -1; // Inicializa o array com -1 para indicar valores não calculados
    }
    System.out.println(fibo(n));
    System.out.println(cont);
  }

  public static int fibo(int n) {
    cont++;
    if (n <= 1) {
      return n;
    }
    if (memo[n] != -1) { // Verifica se o valor já foi calculado
      return memo[n];
    }
    memo[n] = fibo(n - 1) + fibo(n - 2); // Calcula e armazena o valor no array
    return memo[n];
  }
}