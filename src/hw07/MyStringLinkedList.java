package hw07;

import java.util.Arrays;

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
        return "";
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
        if (value > size - 1 || value < 0) {
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
                previousNode = currentNode; // elem_5
                currentNode = currentNode.node; // null
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
        System.out.println("\nMyStringLinkedList content: \n");
        System.out.println("Size: " +  size);
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