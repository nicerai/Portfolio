package Lab4;

public class Heap {
    private int[] heap;
    private int size;
    private int capacity;

    public Heap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }

    // Insert
    public void insert(int value) { //check if heap is full
        if (size == capacity) {
            return;
        }
        heap[size] = value;  //insert the new value at the end of the array
        // Perform  upHeap to maintain heap property
        upHeap(size);
        size++;
    }

    private void upHeap(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap[index] < heap[parentIndex]) {  //if parent is bigger than child
            // Swap the current node with its parent
            int temp = heap[index];
            heap[index] = heap[parentIndex];
            heap[parentIndex] = temp;
            // Move up the tree
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    // RemoveMin operation
    public int removeMin() {
        if (size == 0) {
            // Heap is empty
            return -1; 
        }
        // Replace the root with the last element in the array
        int minValue = heap[0];
        heap[0] = heap[size - 1];
        // Perform downHeap to maintain heap property
        downHeap(0);
        size--;
        return minValue;
    }

    private void downHeap(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallest = index;
        // Find the smallest of the current node and its children
        if (leftChild < size && heap[leftChild] < heap[smallest]) {
            smallest = leftChild;  //left child is smallest
        }
        if (rightChild < size && heap[rightChild] < heap[smallest]) {
            smallest = rightChild; //right child is smallest
        }
        if (smallest != index) {
            // Swap the current node with the smallest child
            int temp = heap[index];
            heap[index] = heap[smallest];
            heap[smallest] = temp;
            // Recursively downHeap
            downHeap(smallest);
        }
    }

    // Return the minimum element without removing it
    public int min() {
        if (size == 0) {
            // Heap is empty
            return -1; 
        }
        return heap[0];
    }

    // Return the size of the heap
    public int size() {
        return size;
    }

    // Check if the heap is empty
    public boolean isEmpty() {
        return size == 0;
    }
}

class Main {
    public static void main(String[] args) {
        // Create a heap with a capacity of 10
        Heap heap = new Heap(10);

        // Insert elements into the heap
        heap.insert(2);
        heap.insert(10);
        heap.insert(5);
        heap.insert(8);
        heap.insert(1);

        // Output the minimum element
        System.out.println("Minimum element in the heap: " + heap.min());

        // Remove and output the minimum element
        System.out.println("Removed minimum element: " + heap.removeMin());

        // Output the minimum element after removal
        System.out.println("Minimum element in the heap after removal: " + heap.min());

        // Output the size of the heap
        System.out.println("Size of the heap: " + heap.size());

        // Check if the heap is empty
        System.out.println("Is the heap empty? " + heap.isEmpty());
    }
}
