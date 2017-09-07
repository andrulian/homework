package hw11lesson170811;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;
import java.util.List;
import java.util.TreeSet;

public class ListVsArrayVsSet {
    static long total;
    static long startTime;
    static long endTime;

    private static int searchResult;
        private static final int QUANTITY = 1_000_000;

    private static Random r;
    private static ElementClass item;
    private static List<ElementClass> arrl;
    private static List<ElementClass> linkl;
    private static TreeSet<ElementClass> set;


    public static void main(String[] args) {
        r = new Random(1);
        item = new ElementClass(QUANTITY, r);
//        item.x = 1000000 - 1;

        linkl = new LinkedList<>();
        arrl = new ArrayList<>();
        set = new TreeSet<>();

        total = 0;
        searchResult = 0;
        System.out.println("-=Linked list=-");
        System.out.println("Filled: " + fillTimer(linkl) + " ms ");
        System.out.println("Sorted in " + sortTimer(linkl) + " ms");
        System.out.println("Searching... " +
                           "\n              Item: " + item +
                           "\n              Time: " + searchTimer(linkl, item) + " ms" +
                           "\n              Result: " + searchResult);
        System.out.println("Total time: " + (total) + " ms.\n");

        total = 0;
        searchResult = 0;
        System.out.println("-=Array list=-");
        System.out.println("Filled: " + fillTimer(arrl) + " ms ");
        System.out.println("Sorted in " + sortTimer(arrl) + " ms");
        System.out.println("Searching... " +
                "\n              Item: " + item  +
                "\n              Time: " + searchTimer(arrl, item) + " ms" +
                "\n              Result: " + searchResult);

        System.out.println("Total time: " + (total) + " ms.\n");
    }

    private static long searchTimer(List<ElementClass> obj, ElementClass item) {
        startTime = System.currentTimeMillis();
//        MyBinarySearch.binarySearch(obj, item);
        searchResult = Collections.binarySearch(obj, item);
        endTime = System.currentTimeMillis();
        total += endTime - startTime;
        return endTime - startTime;
    }

    private static long sortTimer(List obj) {

        startTime = System.currentTimeMillis();
        Collections.sort(obj);
        endTime = System.currentTimeMillis();
        total += endTime - startTime;
        return endTime - startTime;
    }

    private static long fillTimer(Collection<ElementClass> obj) {
        startTime = System.currentTimeMillis();
        Random rr = new Random(1);
        for (int i = 0; i < QUANTITY; i++) {
            obj.add(new ElementClass(QUANTITY, rr));
        }

        endTime = System.currentTimeMillis();

        total += endTime - startTime;
        return endTime - startTime;
    }
}


