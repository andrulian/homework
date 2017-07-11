package hw07;

public class Node {
    String value;
    Node node;

    public Node(String value, Node node) {
        this.node = node;
        this.value = value;
    }

}
