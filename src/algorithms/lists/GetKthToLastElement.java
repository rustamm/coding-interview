package algorithms.lists;

/**
 * Implement an algorithm to find the kth to last element of a singly linked list
 * Created by Rustam Miftakhutdinov on 05.01.15.
 */
public class GetKthToLastElement {
    public static Node findKthToLastElement(Node head, int k) {
        if (head == null) {
            throw new IllegalArgumentException("head must be not null");
        }

        if (k < 1) {
            throw new IllegalArgumentException("k must be greater than or equal to 1");
        }

        Node n = head;
        while (k > 1) {
            if (n.getNext() == null) {
                return null;
            }

            n = n.getNext();
            k--;
        }

        Node follower = head;

        while (n.getNext() != null) {
            follower = follower.getNext();
            n = n.getNext();
        }

        return follower;
    }
}
