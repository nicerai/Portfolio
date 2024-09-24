import java.util.Scanner;

class Node {
    int data;   //store value of node
    Node next;   //reference to next node

    public Node(int data) {  //constructor to initialize node
        this.data = data;
        this.next = null;  //list is empty, therefore there is no node to point to
    }
}

class SinglyLinkedList {
    private Node head;  //reference to the first node of the list

    public SinglyLinkedList() {  //constructor to initalize empty list
        this.head = null;
    }

    public void addFirst(int data) {  
        Node newNode = new Node(data);  //create new node with value
        newNode.next = head;   //point new node to the current head node
        head = newNode; //set new node as head
    }

    public int removeFirst() {
        if (head != null) {   //check if list is empty
            int data = head.data;  //access data of first node
            head = head.next;  //set the next node as head, indriectly removing the first node
            return data;  //show user data removed
        }
        throw new IllegalStateException("Stack is empty");
    }

    public int getFirst() {
        if (head != null) {  //check if list is empty
            return head.data;  //show data of first node
        }
        throw new IllegalStateException("Stack is empty");
    }

    public int size() {  
        int count = 0;   //initialize with 0
        Node current = head;   //start at the first node
        while (current != null) { //iterate through linked list until the end
            count++;   //increase counter by 1
            current = current.next; //continue to the next node
        }
        return count;  //show count
    }

    public boolean isEmpty() {   
        return head == null;  //check if first node is empty
    }
}

public class Stack {
    private SinglyLinkedList linkedList;

    public Stack() {  //constrcutor to initiliaze stack woith empty list
        this.linkedList = new SinglyLinkedList();  
    }

    public void push(int data) {
        linkedList.addFirst(data);  //add element at beginning of list
        System.out.println("Pushed: " + data);
    }

    public int pop() {
        int poppedValue = linkedList.removeFirst();  
        System.out.println("Popped: " + poppedValue);
        return poppedValue;
    }

    public int top() {
        int topValue = linkedList.getFirst();
        System.out.println("The top element is: " + topValue);
        return topValue;
    }

    public int size() {
        int stackSize = linkedList.size();
        System.out.println("Stack size is: " + stackSize);
        return stackSize;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();   //create instance of stack class
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select: push, pop, top, size, exit");
            System.out.print("Enter your option: ");
            String option = scanner.next();

            switch (option) {
                case "push":
                    System.out.print("Enter desired value to push: ");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    stack.pop();
                    break;
                case "top":
                    stack.top();
                    break;
                case "size":
                    stack.size();
                    break;
                case "exit":
                    System.out.println("Exiting the program, thank you.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
