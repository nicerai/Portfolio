package Lab4;

public class HeapSort {
    public static void heapSort(int[] array) {
        // Step 1: Build a max-heap from the input array
        buildMaxHeap(array);

        // Step 2: Perform heap sort
        int heapSize = array.length;
        for (int i = array.length - 1; i > 0; i--) {
            // Swap the root (max element) with the last element of the heap
            swap(array, 0, i);
            // Reduce the size of the heap
            heapSize--;
            // Restore heap property for the remaining elements
            downHeap(array, 0, heapSize);
        }
    }

    // Helper function to build a max-heap
    private static void buildMaxHeap(int[] array) {
        int heapSize = array.length;
        // Start from the last non-leaf node and downheap
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            downHeap(array, i, heapSize);
        }
    }

    // Helper function to perform heapify-down operation
    private static void downHeap(int[] array, int index, int heapSize) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int largest = index;

        // Find the largest element among the current node and its children
        if (leftChild < heapSize && array[leftChild] > array[largest]) {
            largest = leftChild;
        }
        if (rightChild < heapSize && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        // If the largest element is not the current node, swap and continue heapifying down
        if (largest != index) {
            swap(array, index, largest);
            downHeap(array, largest, heapSize);
        }
    }

    // swapping two functions
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 10, 8, 6, 4, 2};
        System.out.println("Array before sorting:");
        printArray(array);

        heapSort(array);

        System.out.println("Array after sorting:");
        printArray(array);
    }

    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
