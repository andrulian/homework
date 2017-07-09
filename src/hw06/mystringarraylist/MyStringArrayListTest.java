package hw06.mystringarraylist;

import hw05.ArrayGenerator;
import mytestframework.Asserts;

import java.util.Arrays;


public class MyStringArrayListTest {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(MyStringArrayList.elements));

        MyStringArrayList.add("elem_0");
        MyStringArrayList.add("elem_1");

        System.out.println(Asserts.assertEquals(MyStringArrayList.get(0), "elem_0"));
        System.out.println(Asserts.assertEquals(MyStringArrayList.get(1000), ""));

        System.out.println(Asserts.assertEquals(MyStringArrayList.size(), 2));

        System.out.println(Asserts.assertEquals(MyStringArrayList.set(1, "elem_1.1"), "elem_1"));


    }
}
