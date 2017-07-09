package hw06;

import mytestframework.Asserts;

public class MyStringMethodPracticeTest {

    public static void main(String[] args) {

        final String HELLO = "Hello";

        String s = "   Hello ";
        String s2 = "Hello";
        String s3 = "  Hello";
        String s4 = "Hello  ";
        String s5 = "  He l l o  ";
        String s6 = "";

//        trim
        System.out.println(Asserts.assertEquals(MyStringMethodPractice.trim(s), HELLO));
        System.out.println(Asserts.assertEquals(MyStringMethodPractice.trim(s2), HELLO));
        System.out.println(Asserts.assertEquals(MyStringMethodPractice.trim(s3), HELLO));
        System.out.println(Asserts.assertEquals(MyStringMethodPractice.trim(s4), HELLO));
        System.out.println(Asserts.assertEquals(MyStringMethodPractice.trim(s5), "He l l o"));
        System.out.println(Asserts.assertEquals(MyStringMethodPractice.trim(s6), ""));

        System.out.println(Asserts.assertNotEquals(MyStringMethodPractice.trim(s), s));
        System.out.println(Asserts.assertNotEquals(MyStringMethodPractice.trim(s3), s3));
        System.out.println(Asserts.assertNotEquals(MyStringMethodPractice.trim(s4), s4));
        System.out.println(Asserts.assertNotEquals(MyStringMethodPractice.trim(s5), s5));


//        replace
        System.out.println(Asserts.assertEquals(MyStringMethodPractice.replace(HELLO, 'l', 'p'), "Heplo"));
        System.out.println(Asserts.assertEquals(MyStringMethodPractice.replace(s, ' ', '!'), "!  Hello "));
        System.out.println(Asserts.assertEquals(MyStringMethodPractice.replace(s4, ' ', '!'), "Hello! "));
        System.out.println(Asserts.assertEquals(MyStringMethodPractice.replace(s6, ' ', '!'), ""));

        System.out.println(Asserts.assertNotEquals(MyStringMethodPractice.replace(s4, ' ', ' '), "Hello! "));
    }
}