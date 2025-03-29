package tapr.univille.lambda;
import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Teste {
  public static void main(String[] args) {
    Set<Pessoa> tree = new TreeSet<>(new Comparator<Pessoa>() {
      @Override
      public int compare(Pessoa p1, Pessoa p2) {
        return p1.getNome().compareTo(p2.getNome());
      }
    });
    
    Pessoa p1 = new Pessoa("Joao", 20);
    Pessoa p2 = new Pessoa("Maria", 30);
    Pessoa p3 = new Pessoa("Joao", 20);
    Pessoa p4 = new Pessoa("Maria", 30);

    System.out.println("HashCodes:");
    System.out.println("p1: " + p1.hashCode());
    System.out.println("p2: " + p2.hashCode());
    System.out.println("p3: " + p3.hashCode());
    System.out.println("p4: " + p4.hashCode());

    System.out.println("\nVerificações de igualdade:");
    System.out.println("p1 equals p2: " + p1.equals(p2));
    System.out.println("p1 equals p3: " + p1.equals(p3));
    System.out.println("p2 equals p4: " + p2.equals(p4));
  }
}
