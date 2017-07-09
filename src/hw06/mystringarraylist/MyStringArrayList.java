package hw06.mystringarraylist;

import java.util.Arrays;


public class MyStringArrayList {
    static final int DEFAULT_SIZE = 2;
    static String[] elements = new String[DEFAULT_SIZE];
    static int size = 0;

    public static void add(String string) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        elements[size++] = string;
    }

    public static String get(int index) {
        if (rangeCheck(index) ) {
            return elements[index];
        }
        return "";
    }

    public static String set(int index, String newElem) {
        if (rangeCheck(index) ) {
            String oldElem = elements[index];
            elements[index] = newElem;
            return oldElem;
        }
        return "";
    }

    public static String remove(int index) {
        if (rangeCheck(index) ) {
            String oldElem = elements[index];
            int tillEnd = size - 1 - index;
            if(tillEnd > 0) {
                System.arraycopy(elements, index + 1, elements, index, tillEnd);
            }
            elements[--size] = null;
            return oldElem;
        }
        return "";
    }

    public static boolean isEmpty() {
        return size == 0;
    }

    public static int size() {
        return size;
    }

    private static boolean rangeCheck(int index) {
        if(index < 0 || index >= size) {
            System.err.println("Index out of range");
            return false;
        }
        return true;
    }
//    @Override
//    public String toString() {
//
//        return Arrays.toString(elements);
//    }
//
//    //  [a,b,c,d,e,_]
//    //   0 1 2 3 4 5
//    //  [a,b,d,e,_,_]
//    //   0 1 2 3 4
//
//    public void remove(int i) {
//        if (i >= size || i < 0) {
//            return;
//        }
//
//        System.arraycopy(elements, i+1, elements, i, --size - i);
//        elements[size] = null;
//
//    }

}
