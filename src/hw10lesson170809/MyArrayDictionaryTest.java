package hw10lesson170809;

import mytestframework.Asserts;

public class MyArrayDictionaryTest {
    public static void main(String[] args) {

//        <String, String>
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

//        <String, Integer>
        MyArrayDictionary<String, Integer> simad = new MyArrayDictionary<>();

        simad.put("Sam", 1);
        simad.put("Ivan", 10);

        System.out.println(Asserts.assertEquals(simad.get("Ivan"), 10));
        System.out.println(Asserts.assertEquals(simad.get("Sam"), 1));

        System.out.println(Asserts.assertNotEquals(simad.get("Ivan"), 1));

//          <Integer, String>
        MyArrayDictionary<Integer, String> ismad = new MyArrayDictionary<>();

        ismad.put(1, "Sam");
        ismad.put(10, "Ivan");

        System.out.println(Asserts.assertEquals(ismad.get(10), "Ivan"));
        System.out.println(Asserts.assertEquals(ismad.get(1), "Sam"));

        System.out.println(Asserts.assertNotEquals(ismad.get(1), "Ivan"));

//        <Integer, Integer>
        MyArrayDictionary<Integer, Integer> imad = new MyArrayDictionary<>();

        System.out.println("Elapsed: " + benchmark(imad, 1_000));
        System.out.println("Elapsed: " + benchmark(imad, 10_000));
        System.out.println("Elapsed: " + benchmark(imad, 100_000));
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

