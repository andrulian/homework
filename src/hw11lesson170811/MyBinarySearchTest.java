package hw11lesson170811;

import mytestframework.Asserts;

public class MyBinarySearchTest {
    public static void main(String[] args) {

        int[] arrL = fillArray();

        System.out.println(Asserts.assertEquals(MyBinarySearch.binarySearch(arrL, 9), -6));
        System.out.println(Asserts.assertEquals(MyBinarySearch.binarySearch(arrL, -5), -1));
        System.out.println(Asserts.assertEquals(MyBinarySearch.binarySearch(arrL, 12), 7));
        System.out.println(Asserts.assertEquals(MyBinarySearch.binarySearch(arrL, 122), -11));
    }

    private static int[] fillArray() {
        int[] arrL = new int[12];

        for (int i = 0; i < 10; i++) {
            arrL[i] = i * 2;
        }

        arrL[10] = 125;
        arrL[11] = 128;

        for (int i = 0; i < arrL.length; i++) {
            System.out.print("elm: " + arrL[i] + ", pos: " + (i + 1) + "|");
        }
        System.out.println("\n");

        return arrL;
    }
}
