package hw11lesson170811;

import mytestframework.Asserts;

import java.util.Arrays;

public class MyBinarySearchTest {
    public static void main(String[] args) {

        int[] arrL = new int[10];

        for (int i = 0; i < 10; i++) {
            arrL[i] = i * 2;
        }
        System.out.println(Arrays.toString(arrL));

        System.out.println(Asserts.assertEquals(MyBinarySearch.binarySearch(arrL, 9), -6));
        System.out.println(Asserts.assertEquals(MyBinarySearch.binarySearch(arrL, -5), -1));
        System.out.println(Asserts.assertEquals(MyBinarySearch.binarySearch(arrL, 12), 7));
        System.out.println(Asserts.assertEquals(MyBinarySearch.binarySearch(arrL, 122), -11));

    }

}
