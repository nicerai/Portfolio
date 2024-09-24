// BST class implements Binary Search Tree operations
public class BSTInOrder {
    Node root; // Reference to the root of the BST

    // Constructor to initialize an empty BST
    BSTInOrder() {
        root = null;
    }

    // Other methods (search, insert, remove) remain the same as before...

    // InOrder traversal of the BST to display keys in increasing order
    void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left); // Traverse left subtree
            System.out.print(root.key + " "); // Visit current node (print its key)
            inOrderTraversal(root.right); // Traverse right subtree
        }
    }

    // Method to start the InOrder traversal from the root
    void inOrder() {
        inOrderTraversal(root);
    }

    // Main method for testing
    public static void main(String[] args) {
        BSTInOrder bst = new BSTInOrder();
        bst.root = new Node(50);
        bst.root.left = new Node(30);
        bst.root.right = new Node(70);
        bst.root.left.left = new Node(20);
        bst.root.left.right = new Node(40);
        bst.root.right.left = new Node(60);
        bst.root.right.right = new Node(80);

        System.out.println("InOrder traversal of the BST:");
        bst.inOrder(); // Display keys in increasing order
    }
}

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
