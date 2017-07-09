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

//      Элементы в count[] инкрементируются согласно значению exp каждого элемента массива

//      1)
//      data = {53, 12, 07, 23}
//      count[]  0 0 1 2 0 0 0 1 0 0
//               0-1-2-3-4-5-6-7-8-9

//      2)
//      data = {12,  53,  23,  7}
//      count[]  0 1 1 1 3 4 3 5 4 4
//               0-1-2-3-4-5-6-7-8-9

        for (i = 0; i < data.length; i++)
            count[ (data[i]/exp)%10 ]++;

//      Каждый элемент массива инкрементируется  на значение предыдущего элемента

//      1)
//      count[]  0 0 1 3 3 3 3 4 4 4
//               0-1-2-3-4-5-6-7-8-9

//      2)
//      count[]  0   0   1   4   7   10  13  17  21  25
//               0 - 1 - 2 - 3 - 4 - 5 - 6 - 7 - 8 - 9

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

//      1)
//      output[] 12  53  23  7
//                0 - 1 - 2 - 3
//
//      count[]  0 0 0 1 3 3 3 4 4 4
//               0-1-2-3-4-5-6-7-8-9

//      2)
//      data = {12,  53,  23,  7}

//      output[]  12  53  23  7
//                0 - 1 - 2 - 3
//
//      count[]  0   0   1   4   7   10  13  17  21  25
//               0 - 1 - 2 - 3 - 4 - 5 - 6 - 7 - 8 - 9

        for (i = data.length - 1; i >= 0; i--)
        {
            output[count[ (data[i]/exp)%10 ] - 1] = data[i];
            count[ (data[i]/exp)%10 ]--;
        }

//      1)
//      data = {12,  53,  23,  7,} вместо data = {53, 12, 07, 23}

//      2)
//      data = {12,  53,  23,  7,} вместо data = {53, 12, 07, 23}

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