public class CountNodes {

    // Node class
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Function to count nodes
    static int countNodes(Node root) {

        // If tree is empty
        if (root == null) {
            return 0;
        }

        // Count root + left subtree + right subtree
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {

        // Creating the tree
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);

        int result = countNodes(root);

        System.out.println("Number of nodes = " + result);
    }
}