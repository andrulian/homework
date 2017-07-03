package hw04;

import java.util.Random;

public class MatrixGenarator {

    public static int[][] generator(int lastRowSize, int randomRange) {

        Random random = new Random();
        int[][] matrix = new int[lastRowSize][];

        for (int i = 0; i < lastRowSize; i++) {
            matrix[i] = new int [i+1];
            for (int j = 0; j <= i; j++) {
                matrix[i][j] = random.nextInt(randomRange);
            }
        }
        return matrix;
    }
}

