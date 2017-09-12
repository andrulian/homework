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
            else return mid + 1;
        }

        return -(lo + 1);
    }
}