package hw10lesson170809;

import mytestframework.Asserts;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class MyArrayDictionaryTest {
    public static void main(String[] args) {

        MyArrayDictionary<String, String> smad = new MyArrayDictionary<>();

        smad.put("Frank", "LA");
        smad.put("Randy", "NY");
        smad.put("Andrei", "St. Petersburg");
        smad.put("Zhora", "Goose-Khrustalny");
        smad.put("Jukka", "Imatra");

//        Zhora moves to Moscow
        smad.put("Zhora", "Moscow");

        System.out.println(Asserts.assertEquals(smad.get("Zhora"), "Moscow"));
        System.out.println(Asserts.assertEquals(smad.get("Frank"), "LA"));

        System.out.println(Asserts.assertNotEquals(smad.get("Jukka"), "Tampere"));




//        System.out.println(Asserts.assertEquals(MyArrayDictionary.);


//        MyArrayDictionary<Integer, Integer> imad = new MyArrayDictionary<>();

//        System.out.println("Elapsed: " + benchmark(imad, 1_000));
//        System.out.println("Elapsed: " + benchmark(imad, 10_000));
//        System.out.println("Elapsed: " + benchmark(imad, 100_000));

    }

    private static <K, V> long benchmark(MyArrayDictionary mad, long value) {
        long start = System.nanoTime();

        for (int i = 0; i < value; i++) {
            mad.put(i, i);
        }

        long end = System.nanoTime();

        return end - start;
    }
}

