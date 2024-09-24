import java.util.Scanner;

public class InsertionSort {
    public static void insertionSort(int[] array) { //input of array
        int n = array.length;
        for (int i = 1; i < n; i++) { 
            int key = array[i];  
            int j = i - 1;  //index of element before current element
            while (j >= 0 && array[j] > key) { //skipping sorted section
                array[j + 1] = array[j]; //shift element to the right to make room for key
                j = j - 1; //move to previous element
            }
            array[j + 1] = key; //once position found we insert the key in correct position
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int size = scanner.nextInt();

        int[] array = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("\nOriginal Array:");
        printArray(array);

        insertionSort(array);

        System.out.println("\nSorted Array:");
        printArray(array);

        scanner.close();
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
