import java.util.Scanner;

public class QuickSort {
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);  //array of integers
    }

    private static void quickSort(int[] array, int low, int high) {  //array, starting index (low) and ending index (high)
        if (low < high) {    //array is greater than 1
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);         //called recursively to sort subarrays, left
            quickSort(array, pi + 1, high);     //right of the pivot
        }
    }

    private static int partition(int[] array, int low, int high) { //array split into 2 halves, smaller or bigger than pivot
        int pivot = array[high]; //last element selected as pivot
        int i = low - 1;  //position before beginning of subarray
        for (int j = low; j < high; j++) { //for loop to iterate through elements
            if (array[j] < pivot) { //j is supposed to be > pivot
                i++; //increment i
                swap(array, i, j); //swap
            }
        
        }
        swap(array, i + 1, high);  //pivot placed in correct position, this is the index of the pivot
        return i + 1; //return index of the pivot
    }

    private static void swap(int[] array, int i, int j) { 
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
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
        
        quickSort(array);

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
