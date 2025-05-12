package tapr.univille.com;

// Faça uma funçao recursiva que imprima o enésimo valor da sequencia de fibonatti
// com Memoization  // data da aula 31/03/2025

// 1) Defina Memoization  // data da aula 04/04/2025
// Memoization é uma técnica de otimização que armazena os resultados de chamadas de função
// para evitar cálculos repetidos. Em vez de recalcular o resultado para entradas já conhecidas,
// a função armazena o resultado em uma estrutura de dados (como um array ou um dicionário)
// e, quando a função é chamada novamente com a mesma entrada, ela retorna o resultado armazenado.

// 2) Escreva a funcao de fibonatti com recursividade e memoization

public class RecursividadeFibonacci {

  private static int cont; // conta quantas vezes fibo() foi chamada
  private static long[] memo; // array pra guardar os valores já calculados

  public static void main(String[] args) {
    int n = 50;
    memo = new long[n + 1]; // Array para armazenar os valores já calculados
    for (int i = 0; i <= n; i++) {
      memo[i] = -1; // Inicializa o array com -1 para indicar valores não calculados
    }
    System.out.println("50º termo: " + fibo(n));
    System.out.println("Número de chamadas recursivas: " + cont);
  }

  public static long fibo(int n) {
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