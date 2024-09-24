import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedListQueue1 {
    private Node head;  //first node in queue
    private Node tail;   //last node in queue
    private int size;    //size of queue

    public SinglyLinkedListQueue1() {  //constructor to initialize queue
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);  //new node
        if (isEmpty()) {         
            head = newNode;  
            tail = newNode;  
        } else {
            newNode.next = head;    //set as first node
            head = newNode;
        }
        size++;   //increment
    }

    public void removeFirst() {
        if (!isEmpty()) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;  //set next node as head
            }
            size--;  //decrement size
        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;  
            tail = newNode;   //set new node as last node
        }
        size++;
    }

    public void removeLast() {
        if (!isEmpty()) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                Node current = head;        //start from first node
                while (current.next != tail) { //iterate until second last node
                    current = current.next; 
                } 
                current.next = null;  
                tail = current; //set as new tail
            }
            size--;   //decrement
        }
    }

    public int getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return head.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        SinglyLinkedListQueue1 queue = new SinglyLinkedListQueue1();  //create instance
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements to enqueue: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {    //loop to enqueue elements
            System.out.print("Enter element " + (i + 1) + ": ");  
            int element = scanner.nextInt();  //scan element from user
            queue.addLast(element);  //enqueue
        }

        System.out.println("Front element: " + queue.getFirst());
        System.out.println("Queue size: " + queue.size());

        System.out.print("Enter number of elements to dequeue: ");
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {   
            queue.removeFirst();  //dequeue element
        }

        System.out.println("Front element after dequeue: " + queue.getFirst());
        System.out.println("Queue size after dequeue: " + queue.size());

        scanner.close();
    }
}
