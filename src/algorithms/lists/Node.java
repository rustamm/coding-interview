package algorithms.lists;

/**
 * Created by Rustam Miftakhutdinov on 05.01.15.
 */
public class Node {
    private Node next;

    private int data;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public static Node create(int... values) {
        Node head = null;

        for (int i = values.length - 1; i >= 0; i--) {
            Node node = new Node();
            node.setNext(head);
            node.setData(values[i]);

            head = node;
        }

        return head;
    }
}
