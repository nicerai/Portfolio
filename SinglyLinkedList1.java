import java.util.Scanner;

public class SinglyLinkedList1 {
    private static Scanner scanner = new Scanner(System.in);
    private Node head;  //refernece to the first node in the list
    private int size;       //field to reference to the next node

    // Node class representing a node in the linked list
    private class Node {
        int data;       // field to store the value
        Node next;      // field to reference to the next node

        // constructor initializes fields
        public Node(int data) {
            this.data = data;   
            this.next = null;
        }
    }

    // Constructor to initialize values of an empty list
    public SinglyLinkedList1() { 
        this.head = null;   // no head yet
        this.size = 0;         // size of list is 0
    }

    // Add a node with given data at the beginning of the list
    public void addFirst(int data) {
        Node newNode = new Node(data); // creating new node
        newNode.next = head; 
        head = newNode;  // set as new head
        size++;  // increment size counter
    }

    // Remove the first node from the list
    public void removeFirst() { 
        if (head != null) {  // check if the list is empty or not
            head = head.next; // set the next node to be the new head, essentially removing the current head
            size--;         // decrement size
        }
    }

    // Add a node with given data at the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data); // create new node
        if (head == null) {   // if list is empty
            head = newNode;  // set newNode as head
        } else {
            Node current = head;  // start at the head
            while (current.next != null) { // looks for the last node
                current = current.next; 
            }
            current.next = newNode;  // set next of last reference to the new node
        }
        size++;  // increment counter
    }

    // Remove the last node from the list
    public void removeLast() {
        if (head == null || head.next == null) {   // if the list is empty or there is only one node
            head = null;   // set head to null, list is empty
        } else {
            Node current = head;       // start at the beginning of the list
            while (current.next.next != null) {  // go through list until you get to the end
                current = current.next;  // move through the list
            }
            current.next = null;  // Set last node to point to nothing
        }
        size--;  // decrement counter
    }

    // Return the value of the first node in the list
    public int getFirst() {    
        if (head != null) {   // check if list is empty
            return head.data;  // value of first node
        }
        throw new IllegalStateException("List is empty");   // If list is empty
    }

    // Return the value of the last node in the list
    public int getLast() {
        if (head != null) {   // if list is not empty
            Node current = head;  // start from the first node
            while (current.next != null) {  // find last node
                current = current.next;
            }
            return current.data;     // return data of last node
        }
        throw new IllegalStateException("List is empty");
    }

    // Return the size of the list
    public int size() {   // return size
        return size;
    }

    public static void main(String[] args) {
        SinglyLinkedList1 list = new SinglyLinkedList1(); // create instance of SinglyLinkedList

        // Loop for user interaction
        boolean exit = false;
        while (!exit) {
            // Display menu
            System.out.println("\nChoose an action:");
            System.out.println("1. Add First");
            System.out.println("2. Remove First");
            System.out.println("3. Add Last");
            System.out.println("4. Remove Last");
            System.out.println("5. Get First");
            System.out.println("6. Get Last");
            System.out.println("7. Display Size");
            System.out.println("8. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter data to add at first:");
                    int data1 = scanner.nextInt();
                    list.addFirst(data1);
                    break;
                case 2:
                    list.removeFirst();
                    break;
                case 3:
                    System.out.println("Enter data to add at last:");
                    int data2 = scanner.nextInt();
                    list.addLast(data2);
                    break;
                case 4:
                    list.removeLast();
                    break;
                case 5:
                    System.out.println("First element: " + list.getFirst());
                    break;
                case 6:
                    System.out.println("Last element: " + list.getLast());
                    break;
                case 7:
                    System.out.println("Size: " + list.size());
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
                }
            }
            scanner.close();
        }
    }