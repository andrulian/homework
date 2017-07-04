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


//    public static void generator(String ArrayType) {

//    public ArrayGenerator(String ArrayType) {
//        switch (ArrayType) {
//            case "int":
//                System.out.println("int type");
//                break;
//
//            case "String":
//                System.out.println("String type");
//                break;
//
//            default:
//                System.err.println("Enter valid data type");
//                break;
//        }
//    }


}
