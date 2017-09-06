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
            else return mid;
        }

        return lo;
    }

    public static void main(String[] args) {
        int[] tArr = new int[10];

        for (int i = 0; i < tArr.length; i++) {
            tArr[i] = i;
        }

        System.out.println(Arrays.toString(tArr));
        System.out.println(binarySearch(tArr, 8));
    }
}
