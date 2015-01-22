package algorithms.stacks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rustam Miftakhutdinov on 18.01.15.
 */
public class Stack {

    private class Node {
        private final int value;

        private final Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return this.value;
        }

        public Node getNext() {
            return this.next;
        }
    }

    private Node top = null;

    private int size = 0;

    public void push(int value) {
        Node newTop = new Node(value, this.top);
        this.top = newTop;
        this.size++;
    }

    public int pop() {
        if (this.top == null) {
            throw new IllegalStateException("Can't pop an element from an empty stack");
        }

        Node oldTop = this.top;
        this.top = oldTop.getNext();
        this.size--;
        return oldTop.getValue();
    }

    public int getSize() {
        return this.size;
    }

    public int peek() {
        if (this.top == null) {
            throw new IllegalStateException("Can't peek an element from an empty stack");
        }

        return this.top.getValue();
    }

    public List<Integer> getAllElements() {
        ArrayList<Integer> list = new ArrayList<>();

        Node p = this.top;
        while (p != null) {
            list.add(p.getValue());
            p = p.getNext();
        }

        return list;
    }
}

