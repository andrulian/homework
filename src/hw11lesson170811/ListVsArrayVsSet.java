package hw11lesson170811;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Set;
import java.util.List;
import java.util.TreeSet;

public class ListVsArrayVsSet {
    private static final int QUANTITY = 10;
//    private static final int QUANTITY = 1_000_000;
    private static List<ElementClass> linkl;
    private static List<ElementClass> arrl;
    private static Set<ElementClass> set;


    public static void main(String[] args) {
        linkl = new LinkedList<>();
        arrl = new ArrayList<>();
        set = new TreeSet<>();

//      fill
        System.out.println("LinkedList has filled with elements in " + fillTimer(linkl) + linkl);
        System.out.println("ArrayList has filled with elements in " + fillTimer(arrl) + arrl);
        System.out.println("TreeSet has filled with elements in " + fillTimer(set) + set + "\n");
//      sort
        System.out.println("LinkedList sorted in " + sortTimer(linkl) + linkl);
        System.out.println("ArrayList sorted in " + sortTimer(arrl) + arrl);
        System.out.println("TreeSet is already sorted ");// + set);
//      search


    }



    private static long sortTimer(List obj) {
        long startTime = System.currentTimeMillis();
        Collections.sort(obj);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static long fillTimer(Collection obj) {
        long startTime = System.currentTimeMillis();
        fill(obj);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static void fill(Collection obj) {
        for (int i = 0; i < QUANTITY; i++) {
            obj.add(new ElementClass(QUANTITY));
        }
    }
}


