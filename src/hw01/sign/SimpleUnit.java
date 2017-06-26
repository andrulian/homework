package hw01.sign;

public class SimpleUnit {
    public static boolean assertsEqual(int actual, int expected) {
        boolean equals = actual == expected;
        if (!equals) {
            System.err.println("Test failed. Expected '" + expected + "' but actual is '" + actual + "'");
        }
        return equals;

    }
    public static boolean assertsNotEqual(int actual, int expected) {
        boolean equals = actual != expected;
        if (!equals) {
            System.err.println("Test failed. Expected not '" + expected + "' but actual is '" + actual + "'");
        }
        return equals;
    }
}