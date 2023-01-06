import java.util.*;

class BubbleSort {
    void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++){
            boolean isSorted = true;
            for (int j = 0; j < n - i - 1; j++) {
                if(arr[j] > arr[j+1]){
                    isSorted = false;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            printStepOfSort(i, arr);
            if (isSorted) {
                break;
            }
        }
            
    }

    private void printStepOfSort(int index, int[] arr) {
        System.out.printf("%d: ", index);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }

    /* Prints the array */
    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method to test above
    public static void main(String args[]) {
        BubbleSort ob = new BubbleSort();
        int arr[] = { 1, 2, 3, 4, 5, 9, 8};
        ob.bubbleSort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }
}