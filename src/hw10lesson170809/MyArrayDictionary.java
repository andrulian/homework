package hw10lesson170809;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;


//    String[] was used instead of Pair class just for a change.

public class MyArrayDictionary implements Iterable<String[]>{
    private static final int MAX = 10;

    List<String[]>[] data = new List[MAX];

    public void put(String key, String value) {
        int index = hash(key);

        List<String[]> list = data[index];

        if (list == null) {
            list = new ArrayList<>();
            data[index] = list;
        }

        String[] pair = getPair(key);

        if (pair == null) {
            list.add(new String[] {key, value});
        } else { pair[1] = value; }
    }

    private int hash(String key) {
        return key.hashCode() & 0x7FFFFFF % data.length;
    }

    private String[] getPair(String key) {
        int index = hash(key);

        List<String[]> list = data[index];

        if (list == null) {return null;}

        for (String[] pair : list) {
            if (pair[0].equals(key)) {
                return pair;
            }
        }

        return null;
    }

    public String get(String key) {
        String[] pair = getPair(key);

        return pair == null ? null : pair[1];
    }

    @Override
    public Iterator<String[]> iterator() {
        return new Iterator<String[]>() {
            int currentElement = -1;
            Iterator<String[]> listIterator = null;

            @Override
            public boolean hasNext() {

                if (listIterator!= null && listIterator.hasNext()) {
                    return true;
                }

                listIterator = null;

                for (++currentElement; listIterator == null && currentElement < data.length; currentElement++) {
                    List<String[]> list = data[currentElement];

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
            public String[] next() {
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
