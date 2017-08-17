package hw10lesson170809;

import java.util.Arrays;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;


public class MyArrayDictionary<T> implements Iterable<T[]>{

    private static final int MAX = 10;

    List<T[]>[] data = new List[MAX];

    public void put(T key, T value) {
        int index = hash(key);

        List<T[]> list = data[index];

        if (list == null) {
            list = new ArrayList<>();
            data[index] = list;
        }

//        T[] pair = getPair(key);
        T[] pair = getPair(key);

        if (pair == null) {

            list.add( (T[]) new Object[]{key, value} );

        } else { pair[1] = value;}
    }

    public void print() {
        for (List<T[]> i : data) {
//            System.out.println( i );
//            System.out.println( Arrays.toString(i.toArray()) );
            if (i != null) {
                for (T[] j : i) {
                    System.out.println(Arrays.toString(j));
                }
            }
        }
    }

    private int hash(T key) {
        return key.hashCode() & 0x7FFFFFF % data.length;
    }

    private T[] getPair(T key) {
        int index = hash(key);
//        System.out.println(index);
//        System.out.println(data[index]);

        List<T[]> list = data[index];

        if (list == null) {return null;}

        for (T[] pair : list) {
            if (pair[0].equals(key)) {
                return pair;
            }
        }

        return null;
    }

    public T get(T key) {
        T[] pair = getPair(key);
        return pair == null ? null : pair[1];
    }

    @Override
    public Iterator<T[]> iterator() {
        return new Iterator<T[]>() {
            int currentElement = -1;
            Iterator<T[]> listIterator = null;

            @Override
            public boolean hasNext() {

                if (listIterator!= null && listIterator.hasNext()) {
                    return true;
                }

                listIterator = null;

                for (++currentElement; listIterator == null && currentElement < data.length; currentElement++) {
                    List<T[]> list = data[currentElement];

                    if (list == null) {
                        continue;
                    }

                    listIterator = list.iterator();

                    if (!listIterator.hasNext()) {continue;}

                    return listIterator.hasNext();
                }

                return false;
            }

            @Override
            public T[] next() {
                if (!hasNext()) {
                    throw new IllegalArgumentException();
                }

                return listIterator.next();
            }

            @Override
            public void remove() {

            }
        };
    }


}
