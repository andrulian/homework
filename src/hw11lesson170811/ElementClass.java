package hw11lesson170811;

import java.util.Comparator;
import java.util.Random;

public class ElementClass implements Comparable<ElementClass> {
//public class ElementClass implements Comparator<ElementClass> {
    static Random r = new Random();
    int x = r.nextInt(1000000);

    @Override
    public String toString() {
        return "ElementClass{" +
                "x=" + x +
                '}';
    }

    @Override
    public int compareTo(ElementClass ec) {
        return ec.x - this.x;
    }


//    @Override
//    public int compare(ElementClass ec1, ElementClass ec2) {
//        return ec1.x - ec2.x;
//    }
}
