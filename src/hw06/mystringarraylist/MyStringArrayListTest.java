package hw06.mystringarraylist;

import mytestframework.Asserts;


public class MyStringArrayListTest {
    public static void main(String[] args) {
        MyStringArrayList.add("testing");

        System.out.println(Asserts.assertEquals(MyStringArrayList.get(0), "testing"));
    }
}
