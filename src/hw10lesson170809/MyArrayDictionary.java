package hw10lesson170809;

import java.util.List;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ArrayList;

// Array of 2 was used instead of Pair class just for a change.         <------

public class MyArrayDictionary<T> implements Iterable<T[]>{

    static final double LOAD_FACTOR = 0.7;
    private static int currentSize = 10;
    private int capacity;

    List<T[]>[] data = new List[currentSize];

    public void put(T key, T value) {
        int index = hash(key);

        List<T[]> list = data[index];

        if (list == null) {
            list = new ArrayList<>();
            data[index] = list;
            capacity++;
        }

        T[] pair = getPair(key, index);

        if (pair == null) {
            list.add( (T[]) new Object[]{key, value} );
        } else { pair[1] = value;}

        resize();
    }

    private void resize() {
        System.out.println("Capacity: " + capacity);
        System.out.println("Data length: " + data.length);

        if (currentSize * LOAD_FACTOR <= capacity) {
            System.err.println("WARNING");

            currentSize *= 2;

            List<T[]>[] newData = new List[currentSize];

            System.arraycopy(data, 0, newData, 0, data.length);

            data = newData;

            System.out.println("Data array size is: " + data.length);
        }

    }

    public void print() {
        for (List<T[]> i : data) {
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

        return getPair(key, index);
    }

//    with index.
    private T[] getPair(T key, int index) {

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
