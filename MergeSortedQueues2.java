import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MergeSortedQueues2 {

    public static Queue<Integer> mergeSortedQueues2(Queue<Integer> queueA, Queue<Integer> queueB) {  //method to merge sorted queues
        Queue<Integer> mergedQueue = new LinkedList<>();  //create new linked list
 
        while (!queueA.isEmpty() && !queueB.isEmpty()) {  //go through the first queue
            if (queueA.peek() <= queueB.peek()) {  //compare front two elements of both queues
                mergedQueue.offer(queueA.poll());  // add smaller element to mergedQueue
            } else {
                mergedQueue.offer(queueB.poll()); //add the smaller element to mergedQueue
            }
        }

        // Add remaining elements from queueA, if any
        while (!queueA.isEmpty()) {         //continue through Queue A if list is not empty
            mergedQueue.offer(queueA.poll());   
        }

        // Add remaining elements from queueB, if any
        while (!queueB.isEmpty()) {            //continue thorugh Queue B if list is not empty
            mergedQueue.offer(queueB.poll());
        }

        return mergedQueue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  //scanner object

        // Input for both queues A and B
        System.out.print("Provide elements for Queue A and Queue B (in the format 'A = ... B = ...'): ");
        String input = scanner.nextLine();
        String[] parts = input.split("B = ");  //Split A and B 

        Queue<Integer> queueA = parseInput(parts[0].substring(4)); // Extracting elements for queue A
        Queue<Integer> queueB = parseInput(parts[1]); // Extracting elements for queue B

        // Merge sort both queues
        Queue<Integer> mergedQueue = mergeSortedQueues2(queueA, queueB);

        // Print the merged sorted queue S
        System.out.println("Merged Sorted Queue S:");

        while (!mergedQueue.isEmpty()) {       //go thorugh entire mergedQueue
            System.out.print(mergedQueue.poll() + " ");
        }

        scanner.close();
    }

    // Utility method to parse input string and return sorted queue
    private static Queue<Integer> parseInput(String input) {
        Queue<Integer> queue = new LinkedList<>();     //create new linkedList
        String[] elements = input.split(",");       //split string based on ","
        for (String element : elements) {           //go through each element
            try {
                int num = Integer.parseInt(element.trim()); //convert string to integer
                queue.offer(num);       //add integer to queue
            } catch (NumberFormatException e) {  //ignore non-integer inputs
                
            }
        }
        return queue;
    }
}
