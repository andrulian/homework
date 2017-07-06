package hw05;

import java.util.Arrays;


public class MillionIntegerSorting {

    public static void main(String[] args) {
        int[] data0 = ArrayGenerator.generator(1000000,"real");
        int[] data1 = ArrayGenerator.generator(1000000, "natural");

        long startTime = System.currentTimeMillis();
        Arrays.sort(data0);
        System.out.println("\nArrays.sort time: " + (System.currentTimeMillis() - startTime) + " ms");

        startTime = System.currentTimeMillis();
        RadixSort.makeRadixSort(data1);
        System.out.println("RadixSort time: " + (System.currentTimeMillis() - startTime) + " ms");

    }
}
