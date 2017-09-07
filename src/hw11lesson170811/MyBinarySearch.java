package hw11lesson170811;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MyBinarySearch {
    public static int binarySearch(int[] arr, int key) {
        int lo = 0, hi = arr.length - 1;
//        int lo = 0, hi = arr.size() - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
//            System.out.println("mid: " + mid);
            if (key < arr[mid]) hi = mid - 1;
            else if (key > arr[mid]) lo = mid + 1;
            else return mid;
        }

        return lo;
    }
}
