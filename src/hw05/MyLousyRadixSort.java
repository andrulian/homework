package hw05;

public class MyLousyRadixSort {

    public static int[] makeRadixSort(int[] data) {

        int numerousRadix = getNumerousRadix(data);


        return data;
    }

    private static int getNumerousRadix(int[] data) {
        int numerousRadix = 0;

        for (int elem : data) {
            int len = String.valueOf(elem).length();
            if (len > numerousRadix) {
                numerousRadix = len;
            }
        }
        System.out.println("\nnumerousRadix: " + numerousRadix);
        return numerousRadix;
    }


//    // Largest place for a 32-bit int is the 1 billion's place
//        for(int place=1; place <= 1000000000; place *= 10){
//        // Use counting sort at each digit's place
//        input = countingSort(input, place);
//    }
//
//        return input;
//}
//
//    private static int[] countingSort(int[] input, int place){
//        int[] out = new int[input.length];
//
//        int[] count = new int[10];
//
//        for(int i=0; i < input.length; i++){
//            int digit = getDigit(input[i], place);
//            count[digit] += 1;
//        }
//
//        for(int i=1; i < count.length; i++){
//            count[i] += count[i-1];
//        }
//
//        for(int i = input.length-1; i >= 0; i--){
//            int digit = getDigit(input[i], place);
//
//            out[count[digit]-1] = input[i];
//            count[digit]--;
//        }
//
//        return out;
//
//    }
//
//    private static int getDigit(int value, int digitPlace){
//        return ((value/digitPlace ) % 10);
//    }



}
