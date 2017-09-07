package hw11lesson170811;

import java.util.Random;

public class ElementClass implements Comparable<ElementClass> {
    int x;
//    static Random r = new Random(1);

    public ElementClass(int capacity, Random r) {
        x = r.nextInt(capacity);
    }

//    public ElementClass(int capacity) {
//        x = r.nextInt(capacity);
//    }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                '}';
    }

    @Override
    public int compareTo(ElementClass ec) {
        return x - ec.x;
    }

}
