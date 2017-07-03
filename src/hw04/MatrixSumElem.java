package hw04;


public class MatrixSumElem {
    public static void main(String[] args) {

        int[][] matrix = MatrixGenarator.generator(5, 15);

        printMatrix(matrix);

        




    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length ; i++) {
            System.out.println();
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }
}
