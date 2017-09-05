package hw11lesson170811;


import java.util.ArrayList;
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

        long startTime = System.currentTimeMillis();
        fill(linkl);
        long endTime = System.currentTimeMillis();

        System.out.println("LinkedList has filled with elements in " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        fill(arrl);
        endTime = System.currentTimeMillis();

        System.out.println("ArrayList has filled with elements in " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        fill(set);
        endTime = System.currentTimeMillis();

        System.out.println("TreeSet has filled with elements in " + (endTime - startTime) + " ms");
    }



    private static void fill(List list) {
        for (int i = 0; i < 1_000_000; i++) {
            list.add(new ElementClass());
        }
    }

    private static void fill(Set set) {
        for (int i = 0; i < 1_000_000; i++) {
            set.add(new ElementClass());
        }
    }

}
