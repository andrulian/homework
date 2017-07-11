package hw07;

public class MyStringLinkedList {

    private static Node first;// = new Node(null);
    private static Node last;// = new Node(null);

    public static void add(String value) {
        Node newNode = new Node(value, last);
        if (first == null) {
            first.node = newNode;
        } else {
            last.node.node = newNode;
        }
        last.node = newNode;
        


    }

    public static String set(int i, String s) {
        return "Old string";
    }

    public static String get(int i) {
        return "";
    }

    public static String remove(String str) {
        return str;
    }

    public static String remove(int i) {
        return "";
    }

    public static int size() {
        return 100500;
    }

    public static boolean isEmpty() {
        return true;
    }
}
