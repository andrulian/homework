package hw02;

import java.util.Scanner;


public class NumeralSystems {

    private static int number, radix;
//    int number, radix;

    public static void main(String[] args) {
        receiveInput();
        intoBinaryString();
        intoHexString();
        intoOctalString();
        intoCustomString();
    }

    public static void receiveInput() {
        System.out.print("Введите число в десятичной системе счисления: ");
        Scanner in = new Scanner(System.in);
        number = in.nextInt();
        System.out.print("Укажите основание: ");
        radix = in.nextInt();
    }

    public static void intoBinaryString() {
        System.out.println("Binary: " + Integer.toBinaryString(number));
    }

    public static void intoHexString() {
        System.out.println("Hex: " + Integer.toHexString(number));
    }

    public static void intoOctalString() {
        System.out.println("Octal: " + Integer.toOctalString(number));
    }

    public static void intoCustomString() {
        System.out.println("");
        System.out.println("Десятичное число '" + number + "' в '" + radix + "'-ой системе счисления равно '" +
                            Integer.toString(number, radix) + "'.");
    }
}
