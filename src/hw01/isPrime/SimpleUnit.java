package hw01.isPrime;

public class SimpleUnit {
    public static boolean assertsEqual(boolean actual, boolean expected) {
        boolean equals = actual == expected;
        if (!equals) {
            System.err.println("Test failed. Expected '" + expected + "' but actual is '" + actual + "'");
        }
        return true;

    }

    public static boolean assertsNotEqual(boolean actual, boolean expected) {
        boolean equals = actual != expected;
        if (!equals) {
            System.err.println("Test failed. Expected not '" + expected + "', actual is '" + actual + "'");
        }
        return true;
    }
}
