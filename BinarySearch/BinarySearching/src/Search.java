import java.util.Random;
import java.util.Scanner;

public class Search {

    public int search(int[] arr, int n) {
        // Create Random method for array
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rd.nextInt(100);
        }
        // Sort array
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("Display array");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
        // Enter the number to binary search
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number to binary search");
        int x = input.nextInt();
        // Check validation from Validation class
        if (Validation.isNumber(x)) {
            int left = 0;
            int right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                // System.out.println("mid = " + arr[mid]);
                if (x == arr[mid]) {
                    return mid;
                } else if (x < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        } else {
            System.out.println("Please enter the number to binary search");
        }
        return -1;
}

}
