package hw05;

import java.util.Arrays;

public class MillionIntegerSorting {

    public static void main(String[] args) {
//        int[] data = ArrayGenerator.generator(1000000);

        int[] data = ArrayGenerator.generator(10);

        System.out.print("Unsorted: " + Arrays.toString(data));

        final long startTime = System.currentTimeMillis();
        Arrays.sort(data);

        System.out.print("\nSorted:   " + Arrays.toString(data));
        System.out.println("\n\nTime: " + (System.currentTimeMillis() - startTime) + " ms");


    }
}
