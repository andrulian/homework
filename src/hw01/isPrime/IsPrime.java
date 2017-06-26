package hw01.isPrime;

public class IsPrime {
    public static boolean isPrime(int a) {
        boolean primeNumber = true;

        if(a < 2) {
            return primeNumber = false;
        }
        for(int i=2; i<a; i++) {
            if(a % i == 0) {
                primeNumber = false;
                break;
            }
        }
        return primeNumber;
    }
}
