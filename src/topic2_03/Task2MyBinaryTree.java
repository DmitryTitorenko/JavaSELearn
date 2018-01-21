package topic2_03;

/**
 * @author Dmitry Titorenko on 21.01.2018
 */
public class Task2MyBinaryTree {

    public static void main(String[] args) {
        BinaryTree continents = new BinaryTree();
        continents.addNode(1, "Европа");
        continents.addNode(3, "Африка");
        continents.addNode(5, "Австралия");
        continents.addNode(4, "Америка");
        continents.addNode(2, "Азия");
        continents.addNode(6, "Антарктида");
        continents.addNode(7, "new");
        //continents.traverseTree();
        System.out.println(continents.findByIndex(3));

        System.out.println(continents.findNodeWithChild(4));

        System.out.println(continents.deleteByIndex(6));

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


    public String deleteByIndex(int key) {
        Node node = findByIndex(key);

        if (node != null) {
            Node parent = findNodeWithChild(node.key);

            if (node.leftChild == null) { //1
                if (parent.rightChild == node) {
                    parent.rightChild = node.rightChild;

                } else {
                    //parent.leftChild = node.rightChild;
                }


            } else if (node.rightChild == null) { //2

            }


            return "Delete - " + node.toString();
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
