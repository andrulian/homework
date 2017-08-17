package hw10lesson170809;

import mytestframework.Asserts;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class MyArrayDictionaryTest {
    public static void main(String[] args) {

//        MyArrayDictionary<String> mad = new MyArrayDictionary<>();
//
//        mad.put("Frank", "LA");
//        mad.put("Randy", "NY");
//        mad.put("Andrei", "St. Petersburg");
//        mad.put("Zhora", "Goose-Khrustalny");
//        mad.put("Jukka", "Imatra");
//
//        mad.put("Zhora", "Moscow");
//
//        System.out.println(mad.get("Zhora"));

//        mad.print();

        MyArrayDictionary<Integer> imad = new MyArrayDictionary<>();

        for (int i = 1; i < 51; i++ ) {
            imad.put(i, i);
        }

        imad.print();






//        System.out.println(Asserts.assertEquals(MyArrayDictionary.remove(0), "elem_0"));
//        System.out.println(Asserts.assertEquals(MyArrayDictionary.);
    }
}

