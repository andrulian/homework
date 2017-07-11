package hw07;

public class MyStringLinkedList {

    private static Node first;// = new Node(null);
    private static Node last;// = new Node(null);
    private static int size;

    public static void add(String value) {
        Node newNode = new Node(value, last);
        if (first == null) {
            first = newNode;
        } else {
            last.node = newNode;
        }
        last = newNode;
        size++;
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

    public static String remove(int value) {
        if (value > size || value < 0) {
            System.err.println("Index is out of range");
            return "";
        }

        Node curreNode = first;
        Node previNode = null;

        for (int i = 0; i < value; i++) {
            System.out.println(curreNode.value);
            previNode = curreNode;
            curreNode = curreNode.node;
        }

        previNode.node = curreNode.node;
        size--;

        return curreNode.value;
    }

    public static int size() {
        return size;
    }

    public static boolean isEmpty() {
        return size==0;
    }

    public static void printList() {
        System.out.println("\nMyStringLinkedList content: ");
        Node curreNode = first;
        Node previNode = null;

        for (int i = 0; i < size; i++) {
            System.out.println(curreNode.value);
            previNode = curreNode;
            curreNode = curreNode.node;
        }
    }
}
