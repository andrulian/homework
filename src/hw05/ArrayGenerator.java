package hw05;


import java.util.Random;

public class ArrayGenerator {

    public static int[] generator(int size, String type) {

        int[] data = new int[size];
        Random rand = new Random();

        switch (type) {
            case "natural":
                for (int i = 0; i < data.length; i++) {
                    data[i] = rand.nextInt(1000000);
                }
                break;

            case "real":
                for (int i = 0; i < data.length; i++) {
                    data[i] = rand.nextInt();
                }
                break;
        }
        return data;
    }
}
