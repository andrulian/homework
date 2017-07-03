package hw04;


public class MatrixSumElem {
    public static void main(String[] args) {

        int[][] matrix = MatrixGenerator.generator(25, 250);

        printMatrix(matrix);

        countSum(matrix);
    }
    private static void countSum(int[][] matrix) {

        OUTER: for (int i = 0; i < matrix.length; i++) {
            int sumRow = 0;
            for (int j = 0; j < matrix[i].length; j++) {

                if(matrix[i][j] < 0) {
                    System.out.println("В " + i + "-ом ряду отридцательный элемент " + matrix[i][j]);
                    continue OUTER;
                }
                sumRow += matrix[i][j];
            }
            System.out.println("Сумма элементов ряда " + i + " равна " + sumRow);
        }
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
