class Node {
    int key;
    Node left, right;

    Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BSTRemove2 {
    Node root;

    BSTRemove2() {
        root = null;
    }

    // Insert a new key into the BST
    Node insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insert(root.left, key);
        else if (key > root.key)
            root.right = insert(root.right, key);

        return root;
    }

    // InOrder traversal of the BST to display keys in increasing order
    void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.key + " ");
            inOrderTraversal(root.right);
        }
    }

    // Remove a key from the BST
    Node remove(Node root, int key) {
        if (root == null)
            return root;

        if (key < root.key)
            root.left = remove(root.left, key);
        else if (key > root.key)
            root.right = remove(root.right, key);
        else {
            // Node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = remove(root.right, root.key);
        }

        return root;
    }

    // Find the node with the smallest key value in a subtree
    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    // Method to start the InOrder traversal from the root
    void visualize() {
        inOrderTraversal(root);
    }

    public static void main(String[] args) {
        BSTRemove2 bst = new BSTRemove2();
        int[] keys = {8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15};

        // Insert keys into the BST
        for (int key : keys) {
            bst.root = bst.insert(bst.root, key);
        }

        // Display keys in the BST using InOrder traversal
        System.out.println("Keys in the BST before removing key 8 (InOrder traversal):");
        bst.visualize();

        // Remove key 8 from the BST
        bst.root = bst.remove(bst.root, 8);

        // Display keys in the BST after removing key 8 using InOrder traversal
        System.out.println("\nKeys in the BST after removing key 8 (InOrder traversal):");
        bst.visualize();
    }
}
