package hw05;

import java.util.Arrays;

public class RadixSort {

    public static void makeRadixSort(int[] data) {

        int maxNumber = getMaxNumber(data);

        // exp - номер разряда элемента массива
        for (int exp = 1; maxNumber/exp > 0; exp *= 10) {
            sortingMethod(data, exp);
        }
    }

    private static void sortingMethod(int[] data, int exp) {
        int output[] = new int[data.length]; // output array
        int i;
        int count[] = new int[10];

        Arrays.fill(count,0);

        // Элементы в count[] инкрементируются согласно значению exp каждого элемента массива
        for (i = 0; i < data.length; i++)
            count[ (data[i]/exp)%10 ]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = data.length - 1; i >= 0; i--)
        {
            output[count[ (data[i]/exp)%10 ] - 1] = data[i];
            count[ (data[i]/exp)%10 ]--;
        }

        for (i = 0; i < data.length; i++)
            data[i] = output[i];

    }

    private static int getMaxNumber(int[] data) {
        int maxNumber = 0;

        for (int elem : data) {
//            int len = String.valueOf(elem).length();
//            if (len > maxNumber) {
//                maxNumber = len;
            if (elem > maxNumber) {
                maxNumber = elem;
            }
        }
//        System.out.println("\nmaxNumber: " + maxNumber);
        return maxNumber;
    }
}