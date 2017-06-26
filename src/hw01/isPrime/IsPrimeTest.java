package hw01.isPrime;

public class IsPrimeTest {
    public static void main(String[] args) {
        System.out.println(SimpleUnit.assertsEqual(IsPrime.isPrime(5), true));
        System.out.println(SimpleUnit.assertsEqual(IsPrime.isPrime(8), false));
        System.out.println(SimpleUnit.assertsEqual(IsPrime.isPrime(81), false));
        System.out.println(SimpleUnit.assertsEqual(IsPrime.isPrime(181), true));
        System.out.println(SimpleUnit.assertsEqual(IsPrime.isPrime(-81), false));
        System.out.println(SimpleUnit.assertsEqual(IsPrime.isPrime(2), true));
        System.out.println(SimpleUnit.assertsEqual(IsPrime.isPrime(0), false));
    }
}
