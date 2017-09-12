package hw11lesson170811;

import java.util.Arrays;

public class MyBinarySearch {
    public static  int binarySearch(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length-1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int res = arr[mid] - key;

            if (res < 0) lo = mid + 1;
            else if (res > 0) hi = mid - 1;
            else return mid;
        }

        return -(lo + 1);
    }

    public static void main(String[] args) {
        int[] arrL = new int[12];

        for (int i = 0; i < 10; i++) {
            arrL[i] = i * 2;
        }

        arrL[10] = 125;
        arrL[11] = 128;

//        System.out.println("array: " + Arrays.toString(arrL));
        for (int i = 0; i < arrL.length; i++) {
            System.out.print(arrL[i] + " pos: " + (i + 1) + " | ");
        }
        System.out.println();

        Arrays.sort(arrL);

        System.out.println("Looking for 11: " + binarySearch(arrL, 11));
        System.out.println("Looking for 9: " + binarySearch(arrL, 9));
        System.out.println("Looking for -5: " + binarySearch(arrL, -5));
        System.out.println("Looking for 12: " + binarySearch(arrL, 12));
        System.out.println("Looking for 122: " + binarySearch(arrL, 122));
        System.out.println("Looking for 126: " + binarySearch(arrL, 126));
    }
}