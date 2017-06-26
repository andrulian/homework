package hw01.isFibonacci;

public class isFibonacciTest {

    public static void main(String[] args) {
        System.out.println(SimpleUnit.assertsEqual(IsFibonacci.isFibonacci(5), 5));
        System.out.println(SimpleUnit.assertsEqual(IsFibonacci.isFibonacci(10), 55));
        System.out.println(SimpleUnit.assertsEqual(IsFibonacci.isFibonacci(16), 987));

        System.out.println(SimpleUnit.assertsNotEqual(IsFibonacci.isFibonacci(1), 0));
        System.out.println(SimpleUnit.assertsNotEqual(IsFibonacci.isFibonacci(6), 87));
        System.out.println(SimpleUnit.assertsNotEqual(IsFibonacci.isFibonacci(9), 23));
    }
}
