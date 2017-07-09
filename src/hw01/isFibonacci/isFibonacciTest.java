package hw01.isFibonacci;

import mytestframework.Asserts;

public class isFibonacciTest {
    public static void main(String[] args) {
        
        System.out.println(Asserts.assertEquals(IsFibonacci.isFibonacci(5), true));
        System.out.println(Asserts.assertEquals(IsFibonacci.isFibonacci(8), true));
        System.out.println(Asserts.assertEquals(IsFibonacci.isFibonacci(13), true));
        System.out.println(Asserts.assertEquals(IsFibonacci.isFibonacci(21), true));
        System.out.println(Asserts.assertEquals(IsFibonacci.isFibonacci(34), true));

        System.out.println(Asserts.assertEquals(IsFibonacci.isFibonacci(19), false));
        System.out.println(Asserts.assertEquals(IsFibonacci.isFibonacci(14), false));
        System.out.println(Asserts.assertEquals(IsFibonacci.isFibonacci(22), false));
        System.out.println(Asserts.assertEquals(IsFibonacci.isFibonacci(6), false));
        System.out.println(Asserts.assertEquals(IsFibonacci.isFibonacci(35), false));
        
//        System.out.println(SimpleUnit.assertsEqual(IsFibonacci.isFibonacci(5), true));
//        System.out.println(SimpleUnit.assertsEqual(IsFibonacci.isFibonacci(8), true));
//        System.out.println(SimpleUnit.assertsEqual(IsFibonacci.isFibonacci(13), true));
//        System.out.println(SimpleUnit.assertsEqual(IsFibonacci.isFibonacci(21), true));
//        System.out.println(SimpleUnit.assertsEqual(IsFibonacci.isFibonacci(34), true));
//
//        System.out.println(SimpleUnit.assertsEqual(IsFibonacci.isFibonacci(19), false));
//        System.out.println(SimpleUnit.assertsEqual(IsFibonacci.isFibonacci(14), false));
//        System.out.println(SimpleUnit.assertsEqual(IsFibonacci.isFibonacci(22), false));
//        System.out.println(SimpleUnit.assertsEqual(IsFibonacci.isFibonacci(6), false));
//        System.out.println(SimpleUnit.assertsEqual(IsFibonacci.isFibonacci(35), false));
    }
}
