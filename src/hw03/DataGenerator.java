package hw03;

import java.util.Random;

public class DataGenerator {

    public static byte[] LETTERS = {'A', 'B', 'C', 'D'};

    public static byte[] dataGenerator(int size) {
        Random random = new Random();
        byte[] data = new byte[size];

        for (int i = 0; i < size; i++) {
            data[i] = LETTERS[random.nextInt(LETTERS.length)];
        }
        return data;
    }

}
