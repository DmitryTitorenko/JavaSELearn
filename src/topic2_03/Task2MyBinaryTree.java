package topic2_03;

/**
 * @author Dmitry Titorenko on 21.01.2018
 * <p>
 * 3.2 Реализация функции удаления элемента из дерева
 * Добавить к примеру 2.2 функцию удаления заданного элемента из дерева.
 */
public class Task2MyBinaryTree {

    public static void main(String[] args) {
        BinaryTree continents = new BinaryTree();
        continents.addNode(5, "1");
        continents.addNode(10, "Европа");
        continents.addNode(8, "Африка");
        continents.addNode(7, "Австралия");
        continents.addNode(15, "Америка");
        continents.addNode(20, "Азия");
        continents.addNode(25, "Антарктида");
        continents.addNode(14, "new");
        continents.addNode(13, "new");
        continents.traverseTree();
        System.out.println(continents.deleteByIndex(10));
        continents.traverseTree();
    }
}

class BinaryTree {
    private Node root;

    class Node {
        private Node leftChild;
        private Node rightChild;
        private int key;
        private String value;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return "Key: " + key + " Value:" + value;
        }
    }

    public void addNode(int key, String value) {
        Node node = new Node(key, value);
        Node currentNode = root;
        if (root == null) {
            root = node;
        } else {
            boolean end = false;

            while (!end) {

                Node parentNode = currentNode;
                if (node.key > currentNode.key) {
                    currentNode = currentNode.rightChild;
                    if (currentNode == null) {
                        parentNode.rightChild = node;  // use parentNode because we can't assign "currentNode.rightChild = node" (because he did't exist)
                        end = true;
                    }
                } else {
                    currentNode = currentNode.leftChild;
                    if (currentNode == null) {
                        parentNode.leftChild = node;
                        end = true;
                    }
                }
            }
        }
    }

    public void traverseTree() {
        traverseTree(root);
    }


    public Node findByIndex(int index) {
        Node currentNode = root;
        while (currentNode.key != index) {
            if (index > currentNode.key) {
                currentNode = currentNode.rightChild;
            } else {
                currentNode = currentNode.leftChild;
            }
            if (currentNode == null) {
                return null;
            }
        }
        return currentNode;
    }

    public Node findNodeWithChild(int index) {
        Node currentNode = root;
        Node parent = root;
        while (currentNode.key != index) {
            parent = currentNode;
            if (index > currentNode.key) {
                currentNode = currentNode.rightChild;

            } else {
                currentNode = currentNode.leftChild;
            }
            if (currentNode == null) {
                return null;
            }
        }
        return parent;
    }

    /**
     * Replace parent note link from oldNode to newNode
     *
     * @param parent  parent node, with link need to change
     * @param oldNode this node need to delete
     * @param newNode replace this node to oldNode
     */
    public static void replaceParentLinks(Node parent, Node oldNode, Node newNode) {
        if (parent.rightChild == oldNode) {
            parent.rightChild = newNode;
        } else {
            parent.leftChild = newNode;
        }
    }

    public String deleteByIndex(int key) {
        Node delNode = findByIndex(key);

        if (delNode != null) {
            Node parentNode = findNodeWithChild(delNode.key);
            if (delNode.leftChild == null & delNode.rightChild == null) {
                replaceParentLinks(parentNode, delNode, null);
            } else if (delNode.leftChild == null) {
                replaceParentLinks(parentNode, delNode, delNode.rightChild);
            } else if (delNode.rightChild == null) {
                replaceParentLinks(parentNode, delNode, delNode.leftChild);
            } else {
                Node child = delNode.rightChild;
                if (child.leftChild == null) {
                    child.leftChild = delNode.leftChild;
                    replaceParentLinks(parentNode, delNode, delNode.rightChild);
                } else {

                    // See Thomas H. Cormen Introduction to Algorithms, Third Edition - p.297
                    Node replaceNode = child.leftChild; // y
                    child.leftChild = replaceNode.leftChild; // x

                    replaceNode.leftChild = delNode.leftChild; // l
                    replaceNode.rightChild = delNode.rightChild; //r

                    replaceParentLinks(parentNode, delNode, replaceNode); //parentNode - q; delNode - z;
                }
            }
            return "Delete - " + delNode.toString();
        } else {
            return "This key doesn't exist";
        }
    }

    public void traverseTree(Node currentNode) {
        if (currentNode != null) {
            traverseTree(currentNode.leftChild);
            System.out.println(currentNode);
            traverseTree(currentNode.rightChild);
        }
    }
}
