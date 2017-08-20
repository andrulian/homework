package hw10lesson170809;

import java.util.Arrays;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;


public class MyArrayDictionary<K, V> implements Iterable<MyArrayDictionary.Pair>{

    static final double LOAD_FACTOR = 0.7;
//    private static int currentSize = 10;
//    private int capacity;

    List<Pair>[] data;// = new List[10];

    MyArrayDictionary() {
        this(10);
    }

    MyArrayDictionary(int capacity) {
        data = new List[capacity];
    }

    public static class Pair<K, V> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        int index = hash(key);

        List<Pair> list = data[index];

        if (list == null) {
            list = new ArrayList<>();
            data[index] = list;
//            capacity++;
        }

        Pair pair = getPair(key);
//        System.out.println("PAIR: " + pair.key + pair.value);

        if (pair == null) {
            list.add(new Pair(key, value));
        } else {
            pair.value = value;
        }

//        Pair pair = Pair(key, value);

//        list.add(pair);

//        resize();
    }

    private void resize() {
        MyArrayDictionary<K, V> mad = new MyArrayDictionary<>(data.length * 2);

        for (Pair pair : this) {
            mad.put((K)pair.key, (V)pair.value);
        }

        this.data = mad.data;
    }

    private int hash(K key) {
        return key.hashCode() & 0x7FFFFFF % data.length;
    }

    private Pair getPair(K key) {
        int index = hash(key);

        return getPair(key, index);
    }

//    with index.
    private Pair getPair(K key, int index) {
        List<Pair> list = data[index];

        if (list == null) {return null;}

        for (Pair pair : list) {
            if (pair.key.equals(key)) {
                return pair;
            }
        }

        return null;
    }

    public V get(K key) {
        Pair pair = getPair(key);
        return pair == null ? null : (V) pair.value;
    }

    @Override
    public Iterator<Pair> iterator() {
        return new Iterator<MyArrayDictionary.Pair>() {
            int currentElement = -1;
            Iterator<Pair> listIterator = null;

            @Override
            public boolean hasNext() {

                if (listIterator != null && listIterator.hasNext()) {
                    return true;
                }

                listIterator = null;

                for (++currentElement; listIterator == null
                        && currentElement < data.length; currentElement++) {
                    List<Pair> list = data[currentElement];
                    if (list == null) {
                        continue;
                    }
                    listIterator = list.iterator();
                    if (!listIterator.hasNext()) {
                        continue;
                    }
                    return listIterator.hasNext();
                }

                return false;
            }

            @Override
            public Pair next() {
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
