package mytestframework;

public class Asserts {

    //    Boolean
    public static boolean assertEquals(boolean actual, boolean expected) {
        boolean equals = actual == expected;
        if (!equals) {
            System.err.println("Test failed. Expected '" + expected + "' but actual is '" + actual + "'");
        }
        return equals;

    }

    public static boolean assertNotEquals(boolean actual, boolean expected) {
        boolean equals = actual != expected;
        if (!equals) {
            System.err.println("Test failed. Expected not '" + expected + "', actual is '" + actual + "'");
        }
        return equals;
    }

    //    Integer
    public static boolean assertEquals(int actual, int expected) {
        boolean equals = actual == expected;
        if (!equals) {
            System.err.println("Test failed. Expected '" + expected + "' but actual is '" + actual + "'");
        }
        return equals;

    }

    public static boolean assertNotEquals(int actual, int expected) {
        boolean equals = actual != expected;
        if (!equals) {
            System.err.println("Test failed. Expected not '" + expected + "', actual is '" + actual + "'");
        }
        return equals;
    }

    //    String
    public static boolean assertEquals(String actual, String expected) {
        boolean equals = actual.equals(expected);
        if (!equals) {
            System.err.println("Test failed. Expected '" + expected + "' but actual is '" + actual + "'");
        }
        return equals;
    }

    public static boolean assertNotEquals(String actual, String expected) {
        boolean equals = !actual.equals(expected);
        if (!equals) {
            System.err.println("Test failed. Expected not '" + expected + "', actual is '" + actual + "'");
        }
        return equals;
    }
}