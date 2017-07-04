package hw05;

public class PrintArray {

    public static void main(String[] args) {

        int[] data = ArrayGenerator.generator(10);

        printMethod(data);

    }

    private static void printMethod(int[] data) {
        for (int elem : data) {
            System.out.print(elem + " ");
        }
    }
}
