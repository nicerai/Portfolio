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

// BST class implements Binary Search Tree operations
public class BST{
    Node root; // Reference to the root of the BST

    // Constructor to initialize an empty BST
    BST() {
        root = null;
    }

    // Search for a key in the BST
    // Returns true if key is found, false otherwise
    boolean search(Node root, int key) {
        // Base Cases: root is null or key is present at root
        if (root == null || root.key == key)
            return root != null; // If root is null, key not found, otherwise key found

        // Key is greater than root's key, search in right subtree
        if (root.key < key)
            return search(root.right, key);

        // Key is smaller than root's key, search in left subtree
        return search(root.left, key);
    }

    // Insert a new key into the BST
    Node insert(Node root, int key) {
        // If the tree is empty, create a new node
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

    // Remove a key from the BST
    Node remove(Node root, int key) {
        // Base Case: If the tree is empty, return null
        if (root == null)
            return root;

        // Recur down the tree
        if (key < root.key)
            root.left = remove(root.left, key); // Key is in the left subtree
        else if (key > root.key)
            root.right = remove(root.right, key); // Key is in the right subtree
        else {
            // Node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = remove(root.right, root.key);
        }
        return root;
    }

    // Helper function to find the node with the minimum key value in a subtree
    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        BST bst = new BST();

        while (true) {
            System.out.println("1. Search");
            System.out.println("2. Insert");
            System.out.println("3. Remove");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter key to search: ");
                    int searchKey = scanner.nextInt();
                    if (bst.search(bst.root, searchKey)) {
                        System.out.println("Key " + searchKey + " found in the tree.");
                    } else {
                        System.out.println("Key " + searchKey + " not found in the tree.");
                    }
                    break;
                case 2:
                    System.out.print("Enter key to insert: ");
                    int insertKey = scanner.nextInt();
                    bst.root = bst.insert(bst.root, insertKey);
                    System.out.println("Key " + insertKey + " inserted into the tree.");
                    break;
                case 3:
                    System.out.print("Enter key to remove: ");
                    int removeKey = scanner.nextInt();
                    bst.root = bst.remove(bst.root, removeKey);
                    System.out.println("Key " + removeKey + " removed from the tree.");
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
