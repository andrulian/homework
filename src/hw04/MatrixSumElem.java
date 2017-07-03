package hw04;


public class MatrixSumElem {
    public static void main(String[] args) {

        int[][] matrix = MatrixGenarator.generator(5, 15);

        printMatrix(matrix);

        System.out.println(countSum(matrix, 13));
    }

    private static int countSum(int[][] matrix, int maxSum) {
        int totalSum = 0;
        int step = 0;

        OUTER: for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                step++;
                totalSum += matrix[i][j];
                if(totalSum > maxSum) {
                    System.out.println("step: " + step);
                    break OUTER;
                }
            }
        }
        return totalSum;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length ; i++) {
            System.out.println();
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
        System.out.println("\n");
    }
}
