package tapr.univille.com;

// descobra os dois numeros primos que tem como produto o seguinte valor:

// 36.588.421
// p1 x p2 = 36.588.421
// p1 e p2 tem até 4 digitos

// regra: se o numero for primo, o seu inverso também é primo
// se for divisivel por 2 ou 3, não é primo
// mas não é regra geral


public class Primos {
    public static void main(String[] args) {
        int produto = 36588421;
        int p1 = 0;
        int p2 = 0;

        for (int i = 1; i <= Math.sqrt(produto); i++) {
            if (produto % i == 0) {
                int divisor = produto / i;
                if (isPrimo(i) && isPrimo(divisor)) {
                    p1 = i;
                    p2 = divisor;
                    break;
                }
            }
        }

        System.out.println("Os dois números primos são: " + p1 + " e " + p2);
    }

    public static boolean isPrimo(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
