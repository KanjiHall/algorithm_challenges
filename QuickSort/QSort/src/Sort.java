import java.util.Random;

public class Sort {
    public void randomArray(int[] arr) {
        // Create Random method for array
        Random rd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(100);
        }
        System.out.print("Unsorted array: ");
        for (int i = 0; i < arr.length; i++) {
            // Print the array like " [ 1, 3 , 51, 2] "
            if (i == 0) {
                System.out.print("[" + arr[i] + ", ");
            } else if (i == arr.length - 1) {
                System.out.print(arr[i] + "]");
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.println();
        // Do a Quick Sort
    }
    
    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    public int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;
        return i + 1;
    }

    //Display the array afterQuickSort like " [ 1, 3 , 51, 2] "
    public void display(int[] arr) {
        System.out.print("Sorted array: ");
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.print("[" + arr[i] + ", ");
            } else if (i == arr.length - 1) {
                System.out.print(arr[i] + "]");
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
    }


}
