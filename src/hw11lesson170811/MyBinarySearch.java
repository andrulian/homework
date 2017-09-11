package hw11lesson170811;

import java.util.Arrays;

public class MyBinarySearch {
    public static int binarySearch(int[] arr, int key) {
        int lo = 0, hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
//            System.out.println("mid: " + mid);
            if (key < arr[mid]) hi = mid - 1;
            else if (key > arr[mid]) lo = mid + 1;
            else return mid + 1;
        }

        return  -(lo + 1);
    }
//few changes were applied
    public static void main(String[] args) {
        int[] arrL = new int[10];

        for (int i = 0; i < 10; i++) {
            arrL[i] = i * 2;
        }
        System.out.println("array: " + Arrays.toString(arrL));

        System.out.println("Looking for 9: " + binarySearch(arrL, 9));
        System.out.println("Looking for -5: " + binarySearch(arrL, -5));
        System.out.println("Looking for 12: " + binarySearch(arrL, 12));
        System.out.println("Looking for 122: " + binarySearch(arrL, 122));
    }
}