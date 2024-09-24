import java.util.LinkedList;
import java.util.Queue;

public class MergeSort { //divide and conquer approach
    
    public static void mergeSort(Queue<Integer> queue) {  
        if (queue.size() <= 1) {
            return; // Base case: already sorted
        }
        
        Queue<Integer> leftQueue = new LinkedList<>();  //generate 2 linked lists
        Queue<Integer> rightQueue = new LinkedList<>();
        int mid = queue.size() / 2;
        
        // Split the queue into two halves
        for (int i = 0; i < mid; i++) {
            leftQueue.add(queue.poll());
        }
        while (!queue.isEmpty()) {
            rightQueue.add(queue.poll());
        }
        
        // Recursively sort the left and right halves
        mergeSort(leftQueue);
        mergeSort(rightQueue);
        
        // Merge the sorted halves
        merge(queue, leftQueue, rightQueue); //compares left and right queues and adds teh smaller one to the queue
    }

    private static void merge(Queue<Integer> result, Queue<Integer> left, Queue<Integer> right) {
        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.peek() <= right.peek()) { //check first element
                result.add(left.poll()); 
            } else {
                result.add(right.poll());
            }
        }
        // Add remaining elements from left and right queues
        while (!left.isEmpty()) {
            result.add(left.poll());
        }
        while (!right.isEmpty()) {
            result.add(right.poll());
        }
    }
    
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(9);
        queue.add(8);
        queue.add(7);
        queue.add(6);
        queue.add(5);
        queue.add(4);
        queue.add(3);
        queue.add(2);
        queue.add(1);
    
        
        System.out.println("Original Queue:");
        System.out.println(queue);
        
        mergeSort(queue);
        
        System.out.println("\nSorted Queue:");
        System.out.println(queue);
    }
}
