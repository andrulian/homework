package hw06.mystringarraylist;

import hw05.ArrayGenerator;
import mytestframework.Asserts;

import java.util.Arrays;


public class MyStringArrayListTest {
    public static void main(String[] args) {

        MyStringArrayList.add("elem_0");
        MyStringArrayList.add("elem_1");
        MyStringArrayList.add("elem_2");
        MyStringArrayList.add("elem_3");
        MyStringArrayList.add("elem_4");
        MyStringArrayList.add("elem_5");

        System.out.println(Asserts.assertEquals(MyStringArrayList.get(0), "elem_0"));
        System.out.println(Asserts.assertEquals(MyStringArrayList.get(1000), ""));

        System.out.println(Asserts.assertEquals(MyStringArrayList.size(), 6));

        System.out.println(Asserts.assertEquals(MyStringArrayList.set(1, "elem_1.1"), "elem_1"));

        System.out.println(Asserts.assertEquals(MyStringArrayList.isEmpty(), false));

        System.out.println(Asserts.assertEquals(MyStringArrayList.remove(4), "elem_4"));

//        System.out.println(Arrays.toString(MyStringArrayList.elements));

    }
}
