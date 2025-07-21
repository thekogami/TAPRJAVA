import java.math.BigInteger;

public class RSASimplificado {

  public static void main(String[] args) {
    // passo 1: escolher dois primos p e q
    int p = 3;
    int q = 11;

    // passo 2: calcular n = p * q
    int n = p * q;

    // passo 3: calcular totiente(n) = (p - 1) * (q - 1)
    int totiente = (p - 1) * (q - 1);

    // passo 4: escolher um e tal que seja coprimo de totiente(n)
    int e = 17;

    // passo 5: calcular o d tal que (e * d) % totiente == 1
    int d = encontrarD(e, totiente);

    // chaves
    System.out.println("Chave Pública (e, n): (" + e + ", " + n + ")");
    System.out.println("Chave Privada (d, n): (" + d + ", " + n + ")");

    // msg
    int mensagemOriginal = 9;
    System.out.println("Mensagem original: " + mensagemOriginal);

    // criptografar: c = m^e mod n
    BigInteger m = BigInteger.valueOf(mensagemOriginal);
    BigInteger c = m.pow(e).mod(BigInteger.valueOf(n));
    System.out.println("Mensagem criptografada: " + c);

    // cecriptografar: m = c^d mod n
    BigInteger decrypt = c.pow(d).mod(BigInteger.valueOf(n));
    System.out.println("Mensagem decriptografada: " + decrypt);
  }

  // encontra o d usando busca ingenua
  public static int encontrarD(int e, int totiente) {
    int d = 1;
    while ((e * d) % totiente != 1) {
      d++;
    }
    return d;
  }
}