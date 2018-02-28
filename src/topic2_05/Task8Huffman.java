package topic2_05;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Dmitry Titorenko on 28.02.2018
 * <p>
 * 3.8 Реализация алгоритма Хаффмана (задача повышенной трудности)
 * <p>
 * Разработать программу, которая осуществляет архивацию текстового файла с использованием алгоритма Хаффмана, а также извлечение данных из архива.
 * <p>
 * see https://www.youtube.com/watch?v=iJB_jlBFxww  "04 - Алгоритмы. Жадные алгоритмы: практика и разбор задач. Java"
 */
public class Task8Huffman {
    private Map<Character, Integer> count; // Store count frequency entry every symbol;
    Map<Character, Node> charNode; // Store leaf nodes (uses for show last line)
    PriorityQueue<Node> queueNode; // Store nodes by priority

    public static void main(String[] args) {
        String s = "abacabad";// String to comprising
        Task8Huffman task8Huffman = new Task8Huffman();
        task8Huffman.countSymbol(s);
        task8Huffman.createLeafs();
        task8Huffman.createInternal();
        task8Huffman.showOutput(s);
    }

    /**
     * Math count frequency entry every symbol.
     *
     * @param s to parsing
     */
    public void countSymbol(String s) {
        count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count.containsKey(c)) {
                count.put(c, count.get(c) + 1);
            } else {
                count.put(c, 1);
            }
        }
    }

    /**
     * Create leaf nodes.
     */
    public void createLeafs() {
        charNode = new HashMap<>();
        queueNode = new PriorityQueue();
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            LeafNode leafNode = new LeafNode(entry.getKey(), entry.getValue());
            charNode.put(entry.getKey(), leafNode);
            queueNode.add(leafNode);
        }
    }

    /**
     * Create internal nodes (for create new node is necessary to delete two low priority node).
     */
    public void createInternal() {
        while (queueNode.size() > 1) { // Don't delete last(root) node
            Node left = queueNode.poll();
            Node right = queueNode.poll();
            InternalNode internalNode = new InternalNode(left, right);
            queueNode.offer(internalNode);
        }
    }

    /**
     * Show output data.
     */
    public void showOutput(String s) {

        // show character and his code
        Node root = queueNode.peek();
        root.buildCode("");

        // Show comprising last line
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sb.append(charNode.get(c).code);
        }
        System.out.println(sb.toString());
    }

    class Node implements Comparable<Node> {
        String code;
        int sum;

        public void buildCode(String code) {
            this.code = code;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.sum, o.sum);
        }
    }

    class InternalNode extends Node {
        Node left;
        Node right;

        InternalNode(Node left, Node right) {
            this.left = left;
            this.right = right;
            sum += left.sum + right.sum;
        }

        @Override
        public void buildCode(String code) {
            super.buildCode(code);
            left.buildCode(code + "0");
            right.buildCode(code + "1");
        }
    }

    class LeafNode extends Node {
        private char symbol;

        LeafNode(char symbol, int count) {
            this.symbol = symbol;
            sum = count;
        }

        @Override
        public void buildCode(String code) {
            super.buildCode(code);
            System.out.println(symbol + " " + code);
        }
    }
}