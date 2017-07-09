package hw06;

import mytestframework.Asserts;

public class MyStringMethodPracticeTest {

    public static void main(String[] args) {

        final String HELLO = "Hello";

        String s = "   Hello ";
        String s2 = "Hello";  // trimmed
        String s3 = "  Hello";
        String s4 = "Hello  ";
        String s5 = "  He l l o  ";
        String s6 = "";

        System.out.println(Asserts.assertEquals(MyStringMethodPractice.trim(s), HELLO));
        System.out.println(Asserts.assertEquals(MyStringMethodPractice.trim(s2), HELLO));
        System.out.println(Asserts.assertEquals(MyStringMethodPractice.trim(s3), HELLO));
        System.out.println(Asserts.assertEquals(MyStringMethodPractice.trim(s4), HELLO));
        System.out.println(Asserts.assertEquals(MyStringMethodPractice.trim(s5), "He l l o"));
        System.out.println(Asserts.assertEquals(MyStringMethodPractice.trim(s6), ""));
    }
}
