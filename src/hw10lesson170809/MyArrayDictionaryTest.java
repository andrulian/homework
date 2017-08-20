package hw10lesson170809;

import mytestframework.Asserts;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class MyArrayDictionaryTest {
    public static void main(String[] args) {

//        MyArrayDictionary<String, String> smad = new MyArrayDictionary<>();
//
//        smad.put("Frank", "LA");
//        smad.put("Randy", "NY");
//        smad.put("Andrei", "St. Petersburg");
//        smad.put("Zhora", "Goose-Khrustalny");
//        smad.put("Jukka", "Imatra");
//
//        smad.put("Zhora", "Moscow");
//
//        System.out.println(smad.get("Zhora"));
//        System.out.println(smad.get("Randy"));

        MyArrayDictionary<Integer, Integer> imad = new MyArrayDictionary<>();

        long start = System.nanoTime();

        for (int i = 0; i < 100; i++) {
            imad.put(i, i);
            System.out.println(i);
        }

        long end = System.nanoTime();
        System.out.println("Elapsed: " + (end - start));
        System.out.println(imad.data.length);




//        System.out.println(Asserts.assertEquals(MyArrayDictionary.remove(0), "elem_0"));
//        System.out.println(Asserts.assertEquals(MyArrayDictionary.);
    }
}

