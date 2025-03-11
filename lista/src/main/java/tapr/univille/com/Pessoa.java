package tapr.univille.com;

// sobreescrever o metodo HashCode

public class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public int hashCode() {
        return nome.hashCode() + idade;
    }
    
    @Override
    public boolean equals(Object obj) {
      if (obj instanceof Pessoa) {
        Pessoa p = (Pessoa) obj;
        return nome.equals(p.nome) && idade == p.idade;
      }
      return false;
    }

    public static void main(String[] args) {
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
