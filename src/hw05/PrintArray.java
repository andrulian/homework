package hw05;

public class PrintArray {

    public static void main(String[] args) {

        int[] data = ArrayGenerator.generator(10, "real");

        System.out.println(printMethod(data));

    }

    private static String printMethod(int[] data) {
        String str = "[";
        int len = data.length - 1;

        for (int i = 0; i < len; i++) {
            str += data[i] + ", ";
        }
        str += data[len] + "]";

        return str;
    }
}