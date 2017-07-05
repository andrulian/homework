package hw05;

import java.util.Arrays;

public class MillionIntegerSorting {

    public static void main(String[] args) {
//        int[] data = ArrayGenerator.generator(1000000);

//        int[] data = ArrayGenerator.generator(10);
        int[] data = new int[] {4, 15, 28, 73, 14, 5, 46, 97, 81, 9};

        System.out.print("Unsorted: " + Arrays.toString(data));

        final long startTime = System.currentTimeMillis();

//        Arrays.sort(data);
        MyLousyRadixSort.makeRadixSort(data);

        System.out.print("\nSorted:   " + Arrays.toString(data));
        System.out.println("\n\nTime: " + (System.currentTimeMillis() - startTime) + " ms");


    }
}
