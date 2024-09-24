package Lab5;

class Node {
    int key;
    Node left, right;

    Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BSTSearch2 {
    Node root;

    BSTSearch2() {
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

    // Search for a key in the BST
    boolean search(Node root, int key) {
        if (root == null)
            return false;
        if (root.key == key)
            return true;
        if (root.key < key)
            return search(root.right, key);
        return search(root.left, key);
    }

    // Perform search operations for keys 1 and 15 100,000 times
    void performSearchOperations(int times) {
        long startTime, endTime;
        int key1 = 1, key2 = 15;

        // Perform search(1) 100,000 times
        startTime = System.nanoTime();
        for (int i = 0; i < times; i++) {
            search(root, key1);
        }
        endTime = System.nanoTime();
        System.out.println("Time taken for search(1) " + times + " times: " + (endTime - startTime) + " nanoseconds");

        // Perform search(15) 100,000 times
        startTime = System.nanoTime();
        for (int i = 0; i < times; i++) {
            search(root, key2);
        }
        endTime = System.nanoTime();
        System.out.println("Time taken for search(15) " + times + " times: " + (endTime - startTime) + " nanoseconds");
    }

    public static void main(String[] args) {
        BSTSearch2 bst = new BSTSearch2();
        int[] keys = {8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15};

        // Insert keys into the BST
        for (int key : keys) {
            bst.root = bst.insert(bst.root, key);
        }

        // Perform search operations for keys 1 and 15 100,000 times
        bst.performSearchOperations(100000);
    }
}
