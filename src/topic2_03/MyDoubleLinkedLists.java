package topic2_03;

/**
 * @author Dmitry Titorenko on 19.01.2018
 * <p>
 * 3.1 Реализация двухсвязного списка*
 * Реализовать обобщенный класс, представляющий двусвязный список
 */
public class MyDoubleLinkedLists {

    public static void main(String[] args) {
        MyDoubleLinkedList<Integer> linkedList = new MyDoubleLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println(linkedList);
        System.out.println(linkedList.showPrevious());
    }
}

class MyDoubleLinkedList<E> {

    private Node first = null;
    private Node last = null;
    private int size = 0;


    private class Node {
        E data;
        Node next;
        Node previous;

        public Node(E data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }


    public void add(E e) {
        Node node = new Node(e, null, null);

        if (first == null) {
            first = node;

        } else {
            node.previous = last;
            last.next = node;
        }
        last = node;
        size++;
    }


    public int size() {
        return size;
    }


    @Override
    public String toString() {
        String s = "size = " + size() + "\n[";
        Node link = first;
        while (link != null) {
            s += link.data;
            link = link.next;
            if (link != null) {
                s += ", ";
            }
        }
        s += "]\n";
        return s;
    }

    public String showPrevious() {
        String s = "From last to first use previous links: \n[";
        Node node = last;
        while (node != null) {
            s += node.data;
            node = node.previous;
            if (node != null) {
                s += ", ";
            }
        }
        s += "]\n";
        return s;
    }
}
