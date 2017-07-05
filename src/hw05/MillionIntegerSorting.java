package hw05;

import java.util.Arrays;


public class MillionIntegerSorting {

    public static void main(String[] args) {
        int[] data0 = ArrayGenerator.generator(1000000,"real");
        int[] data1 = ArrayGenerator.generator(1000000, "natural");

        final long startTime0 = System.currentTimeMillis();
        Arrays.sort(data0);
        System.out.println("\nArrays.sort time: " + (System.currentTimeMillis() - startTime0) + " ms");

        final long startTime1 = System.currentTimeMillis();
        RadixSort.makeRadixSort(data1);
        System.out.println("RadixSort time: " + (System.currentTimeMillis() - startTime1) + " ms");

    }
}
