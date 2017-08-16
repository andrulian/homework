package hw10lesson170809;

import mytestframework.Asserts;

public class MyArrayDictionaryTest {
    public static void main(String[] args) {

        MyArrayDictionary mad = new MyArrayDictionary();

        mad.put("Frank", "LA");
        mad.put("Randy", "NY");
        mad.put("Andrei", "St. Petersburg");
        mad.put("Jukka", "Imatra");

        mad.put("Andrei", "Zelenogorsk");

        for (String[] str: mad) {
            System.out.println(str[0] + " lives in " + str[1]);
        }

//        System.out.println(Asserts.assertEquals(MyArrayDictionary.remove(0), "elem_0"));
//        System.out.println(Asserts.assertEquals(MyArrayDictionary.);
    }
}
