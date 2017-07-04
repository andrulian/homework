package hw05.printarray;

public class PrintArray {

    public static void main(String[] args) {

        int[] data = ArrayGenerator.generator(10);

//        System.out.println(Arrays.toString(data));

        printMethod(data);

    }

    private static void printMethod(int[] data) {
        for (int elem : data) {
            System.out.print(elem + " ");
        }
    }
}
