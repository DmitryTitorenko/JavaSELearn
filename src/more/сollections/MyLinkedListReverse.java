package more.сollections;


/**
 * @author Dmitry Titorenko on 26.01.2018
 */
public class MyLinkedListReverse {
    public static void main(String[] args) {
        LinkedListReverse<Integer> linkedListReverse = new LinkedListReverse<>();
        linkedListReverse.addNode(1);
        linkedListReverse.addNode(2);
        System.out.println(linkedListReverse.nextToString(linkedListReverse.first));

        LinkedListReverse.Node node = linkedListReverse.reverse(linkedListReverse.first);
        System.out.println(linkedListReverse.nextToString(node));
    }
}


class LinkedListReverse<T> {

    Node<T> first = null;
    private Node<T> last = null;

    public class Node<T> {
        Node<T> next;
        T value;

        Node(Node next, T value) {
            this.next = next;
            this.value = value;
        }
    }


    /**
     * Appends the specified element to the end of this linkedList.
     *
     * @param value store value for node.
     */
    public void addNode(T value) {
        Node<T> node = new Node(null, value);
        if (first == null) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;
    }

    /**
     * Returns node with has reverse node.next link and refer to nods with revers links
     *
     * @param node root Node<T> from with start to reverse links.
     * @return the node with reverse link.
     */
    public Node<T> reverse(Node<T> node) {
        Node<T> previous = null;
        Node<T> root = node;
        while (root != null) {
            Node temp = root.next;
            root.next = previous;
            previous = root;
            root = temp;
        }
        return previous;
    }

    /**
     * Returns a string representation of the linkedList
     *
     * @param node root Node<T> from with start to found next link.
     * @return the string representation of the linkedList.
     */
    public String nextToString(Node<T> node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.value).append(" ");
            node = node.next;
        }
        return sb.toString();
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("\n[");
        LinkedListReverse.Node link = first;
        while (link != null) {
            s.append(link.value);
            link = link.next;
            if (link != null) {
                s.append(", ");
            }
        }
        s.append("]\n");
        return s.toString();
    }
}

