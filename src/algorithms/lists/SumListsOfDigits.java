package algorithms.lists;

/**
 * Created by Rustam Miftakhutdinov on 05.01.15.
 */
public class SumListsOfDigits {

    public static Node sumListsInBackwardOrder(Node firstHead, Node secondHead) {
        Node p1 = firstHead;
        Node p2 = secondHead;

        Node prev = null;
        Node resultHead = null;

        boolean addOne = false;

        while (p1 != null || p2 != null) {
            int d1 = p1 != null ? p1.getData() : 0;
            int d2 = p2 != null ? p2.getData() : 0;

            int res = d1 + d2 + (addOne ? 1 : 0);

            addOne = res / 10 > 0;

            Node resDigit = new Node();
            resDigit.setData(res % 10);

            if (prev != null) {
                prev.setNext(resDigit);
            } else {
                resultHead = resDigit;
            }

            prev = resDigit;

            p1 = p1.getNext();
            p2 = p2.getNext();
        }

        return resultHead;
    }


}
