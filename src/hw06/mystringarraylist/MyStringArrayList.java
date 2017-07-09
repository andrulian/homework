package hw06.mystringarraylist;

import java.util.Arrays;


//Доделать класс StringArrayList:   добавить методы get, set, size, isEmpty, remove(value), toString (переписать)
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
        return elements[index];
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
