package Lab5;

// Node class represents a single node in the binary search tree
class Node {
    int key; // Key value stored in the node
    Node left, right; // References to the left and right child nodes

    // Constructor to initialize a new node with given key
    Node(int item) {
        key = item;
        left = right = null; // Initialize left and right children to null
    }
}

// BSTNew class implements Binary Search Tree operations
public class BSTNew {
    Node root; // Reference to the root of the BST

    // Constructor to initialize an empty BST
    BSTNew() {
        root = null;
    }

    // Insert a new key into the BST
    Node insert(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.key)
            root.left = insert(root.left, key); // Insert into the left subtree
        else if (key > root.key)
            root.right = insert(root.right, key); // Insert into the right subtree

        // Return the unchanged node pointer
        return root;
    }

    // InOrder traversal of the BST to display keys in increasing order
    void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left); // Traverse left subtree
            System.out.print(root.key + " "); // Visit current node (print its key)
            inOrderTraversal(root.right); // Traverse right subtree
        }
    }

    // Method to start the InOrder traversal from the root
    void visualize() {
        inOrderTraversal(root);
    }

    // Main method for testing
    public static void main(String[] args) {
        BSTNew bst = new BSTNew();
        int[] keys = {8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15};

        // Insert keys into the BST
        for (int key : keys) {
            bst.root = bst.insert(bst.root, key);
        }

        // Display keys in the BST using InOrder traversal
        System.out.println("Keys in the BST (InOrder traversal):");
        bst.visualize();
    }
}
