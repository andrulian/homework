package hw07;


public class MyStringLinkedList {

    private static Node first;
    private static Node last;
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
        Node currentNode = first;

        if (i < 0 || i >= size) {
//            System.err.println("Index out of range");
            return "";
        }

         if (i == 0) {
            return first.value;
         }

        for (int j = 0; j <= i; j++) {
            currentNode = currentNode.node;
        }

        return currentNode.value;
    }

    public static boolean remove(String str) {
        Node currentNode = first;
        Node previousNode = null;
        boolean res = false;

        for (int i = 0; i < size; i++) {
            if (currentNode.value.equals(str)) {
                if (previousNode == null) {
                    first = currentNode.node;
                } else {
                    previousNode.node = currentNode.node;
                    if (currentNode.node == null) {
                        last = previousNode;
                    }
                }

                size--;
                res = true;
                break;
            }

            previousNode = currentNode;
            currentNode = currentNode.node;
        }

        if (first == null) {
            last = null;
        }

        return res;
    }

    public static String remove(int value) {
        if (value >= size || value < 0) {
            System.err.println("Index is out of range");
            return "";
        }

        Node currentNode = first;
        Node previousNode = null;

        if (value == 0) {
            first = first.node;
            if (first == null) {
                last = null;
            }

        } else {
            for (int i = 0; i < value; i++) {
                previousNode = currentNode;
                currentNode = currentNode.node;
            }

            if (currentNode.node != null) {
                previousNode.node = currentNode.node;
            } else {
                previousNode.node = null;
                last = previousNode;
            }
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
        System.out.println("\n-=MyStringLinkedList content=-");
        System.out.println("Size: " +  size);
        Node currentNode = first;
        Node previousNode = null;

        if (isEmpty()) {
            System.out.println("No content!");
        } else {
            for (int i = 0; i < size; i++) {
                System.out.println("value: " + currentNode.value);
                System.out.println("address: " + currentNode);
                System.out.println("next node: " + currentNode.node + "\n");
                previousNode = currentNode;
                currentNode = currentNode.node;
            }
            System.out.println("\nlast. " + "value: " + last.value + ", address: " + last + ", node: " + last.node);
        }
    }

    public static void listEraser() {
        first = null;
        last = null;
        size = 0;
    }

    public static String myStaticToString() {
        StringBuilder sb = new StringBuilder();
        Node currentNode = first;

        sb.append("[");

        if (currentNode != null) {
            sb.append(currentNode.value);
        }

        while (currentNode.node != null) {
            currentNode = currentNode.node;
            sb.append(", ");
            sb.append(currentNode.value);
        }

        sb.append("]");
        return sb.toString();
    }
}