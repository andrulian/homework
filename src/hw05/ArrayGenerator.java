package hw05;


import java.util.Random;

public class ArrayGenerator {

    public static int[] generator(int size) {

        int[] data = new int[size];
        Random rand = new Random();

        for (int i = 0; i < data.length; i++) {
            data[i] = rand.nextInt();
        }
        return data;
    }
}
