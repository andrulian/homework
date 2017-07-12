package hw07;

public class MyStringLinkedList {

    private static Node first;// = new Node(null);
    private static Node last;// = new Node(null);
    private static int size;

    public static void add(String value) {
        Node newNode = new Node(value, null);
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
//        homework. remove by index
        if (value > size || value < 0) {
            System.err.println("Index is out of range");
            return "";
        }

        Node currentNode = first;
        Node previousNode = null;

        if (value == 0) {
            first = first.node;
        } else {
            for (int i = 0; i < value-1; i++) {
                previousNode = currentNode;
                currentNode = currentNode.node;
            }
            previousNode.node = currentNode.node;
        }
        size--;
        return currentNode.value;
    }

    public static int size() {
        return size;
    }

    public static boolean isEmpty() {
        return size==0;
    }

    public static void printList() {
        System.out.println("\nMyStringLinkedList content: \n");
        Node curreNode = first;
        Node previNode = null;

        for (int i = 0; i < size; i++) {
            System.out.println("value: " + curreNode.value);
            System.out.println("address: " + curreNode);
            System.out.println("next node: " + curreNode.node+"\n");
            previNode = curreNode;
            curreNode = curreNode.node;
        }
        System.out.println("\nlast. " + "value: " + last.value + ", address: " + last + ", node: " + last.node);
    }
}
