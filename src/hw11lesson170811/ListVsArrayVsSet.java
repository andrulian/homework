package hw11lesson170811;


import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Set;
import java.util.List;
import java.util.TreeSet;


public class ListVsArrayVsSet {
    private static List<ElementClass> linkl;
    private static List<ElementClass> arrl;
    private static Set<ElementClass> set;

    public static void main(String[] args) {
        linkl = new LinkedList<>();
        arrl = new ArrayList<>();
        set = new TreeSet<>();

        System.out.println("LinkedList has filled with elements in " + timer(linkl) + " ms");
        System.out.println("ArrayList has filled with elements in " + timer(arrl) + " ms");
        System.out.println("TreeSet has filled with elements in " + timer(set) + " ms\n");

        // sort

    }

    private static long timer(Collection obj) {
        long startTime = System.currentTimeMillis();
        fill(obj);
        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

//    private static  long timer(List list) {
//        long startTime = System.currentTimeMillis();
//        fill(list);
//        long endTime = System.currentTimeMillis();
//
//        return endTime - startTime;
//    }
//
//    private static  long timer(Set set) {
//        long startTime = System.currentTimeMillis();
//        fill(set);
//        long endTime = System.currentTimeMillis();
//
//        return endTime - startTime;
//    }

    private static void fill(Collection obj) {
        for (int i = 0; i < 1_000_000; i++) {
            obj.add(new ElementClass());
        }
    }

//    private static void fill(List list) {
//        for (int i = 0; i < 1_000_000; i++) {
//            list.add(new ElementClass());
//        }
//    }
//
//    private static void fill(Set set) {
//        for (int i = 0; i < 1_000_000; i++) {
//            set.add(new ElementClass());
//        }
//    }
}
