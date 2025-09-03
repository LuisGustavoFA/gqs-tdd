package calculadora;

public class Calculadora {
    int somar (int n1, int n2) {
        return n1+n2;
    }

    int subtrair (int n1, int n2) {
        return n1-n2;
    }

    int multiplicar (int n1, int n2) {
        return n1*n2;
    }

    int dividir (int n1, int n2) {
        return n1/n2;
    }

    int fatorial (int n) {
//        if (n < 2) {
//            return n;
//        }
        return (n*n)*n;
    }
}