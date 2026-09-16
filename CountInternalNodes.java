public class CountInternalNodes {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static int countInternalNodes(Node root) {

        // Empty tree
        if (root == null) {
            return 0;
        }

        // Leaf node is NOT an internal node
        if (root.left == null && root.right == null) {
            return 0;
        }

        // Current node is internal
        return 1 + countInternalNodes(root.left)
                 + countInternalNodes(root.right);
    }

    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(6);

        System.out.println("Number of internal nodes = "
                + countInternalNodes(root));
    }
}