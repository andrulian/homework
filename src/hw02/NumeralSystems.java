package hw02;

import java.util.Scanner;


public class NumeralSystems {

    private static int number, radix;

    public static void main(String[] args) {
        receiveInput();
        numeralSystemSelector();
    }

    public static void numeralSystemSelector() {
        switch (radix) {
            case 2:
                System.out.println(intoBinaryOrOctalNs());
                break;
            case 8:
                System.out.println(intoBinaryOrOctalNs());
                break;
            case 16:
                System.out.println(intoHexNs());
                break;
            default:
                System.err.println("Неизвестное основание сс");
                break;
        }
    }

    public static void receiveInput() {
        System.out.print("Введите число в десятичной системе счисления: ");
        Scanner in = new Scanner(System.in);
        number = in.nextInt();
        System.out.print("Укажите основание: ");
        radix = in.nextInt();
    }

    public static String intoBinaryOrOctalNs() {

        int value = number;
        String result = "";

        if (number <= 0) {
            result = "0";
        } else {
            while (value > 0) {
                result = value % radix + result;
                value = value / radix;
            }
        }
        return result;
    }

    public static String intoHexNs() {
        final char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        int value = number;
        String result = "";

        if (value <= 0) {
            result = "0";
        } else {
            while (value > 0) {
                result = hexDigits[value % radix] + result;
                value = value / radix;
            }
        }
        return result;
    }
}
