/**
 * An DLList is a list of integers, which encapsulates the
 * naked linked list structure.
 */
public class DLList<T> {

    /**
     * Node is a nested class that represents a single node in the
     * DLList, storing an item and a reference to the next Node.
     */
    private class Node {
        /*
         * The access modifiers inside a private nested class are irrelevant:
         * both the inner class and the outer class can access these instance
         * variables and methods.
         */
        public T item;
        public Node next;
        public Node prev;

        public Node(T item, Node next) { // TODO: consider adding another constructor
            this.item = item;
            this.next = next;
            this.prev = null; // TODO
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node that = (Node) o;
            return item.equals(that.item);
        }

        @Override
        public String toString() {
            return item + "";
        }

    }

    /* The first item (if it exists) is at sentinel.next. */
    private Node sentinel;
    private int size;

    /** Creates an empty DLList. */
    public DLList() {
        sentinel = new Node(null, null);
        sentinel.next = sentinel;
        size = 0;
    }

    public DLList(T x) {
        sentinel = new Node(null, null);
        sentinel.next = new Node(x, null);
        sentinel.next.next = sentinel;
        size = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DLList<T> otherList = (DLList<T>) o;
        if (size != otherList.size) return false;

        Node l1 = sentinel.next;
        Node l2 = otherList.sentinel.next;

        while (l1 != sentinel && l2 != otherList.sentinel) {
            if (!l1.equals(l2)) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != sentinel || l2 != otherList.sentinel) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        Node l = sentinel.next;
        String result = "";

        while (l != sentinel) {
            result += l + " ";
            l = l.next;
        }

        return result.trim();
    }

    /** Returns the size of the list. */
    public int size() {
        return size;
    }

    /** Adds x to the front of the list. */
    public void addFirst(T x) {
        sentinel.next = new Node(x, sentinel.next);
        size += 1;
    }

    /** Return the value at the given index. */
    public T get(int index) {
        Node p = sentinel.next;
        while (index > 0) {
            p = p.next;
            index -= 1;
        }
        return p.item;
    }

    /** Adds x to the list at the specified index. */
    public void add(int index, T x) {
        //TODO: your code here!
    }

    /** Destructively reverses this list. */
    public void reverse() {
        //TODO: your code here!
    }
}
