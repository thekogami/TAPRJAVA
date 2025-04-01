package tapr.univille.com;

// Faça uma funçao recursiva que imprima o enésimo valor da sequencia de fibonatti

public class RecursividadeFibonacci {

  private static int cont;

  public static void main(String[] args) {
    System.out.println(fibo(50));
    System.out.println(cont);
  }
  
  public static int fibo(int n) {
    cont++;
    if (n <= 1) {
      return n;
    }
    return fibo(n - 1) + fibo(n - 2);
  }

}
