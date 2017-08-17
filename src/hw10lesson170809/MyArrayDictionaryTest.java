package hw10lesson170809;

import mytestframework.Asserts;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class MyArrayDictionaryTest {
    public static void main(String[] args) {

        MyArrayDictionary<String> mad = new MyArrayDictionary<>();

        mad.put("Frank", "LA");
        mad.put("Randy", "NY");
        mad.put("Andrei", "St. Petersburg");
        mad.put("Jukka", "Imatra");
        mad.put("Zhora", "Goose-Khrustalny");

        mad.put("Andrei", "Zelenogorsk");

        System.out.println(mad.get("Andrei"));
//
//        mad.print();

//        System.out.println(Asserts.assertEquals(MyArrayDictionary.remove(0), "elem_0"));
//        System.out.println(Asserts.assertEquals(MyArrayDictionary.);
    }
}

