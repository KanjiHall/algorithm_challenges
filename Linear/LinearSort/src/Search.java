import java.util.Random;
import java.util.Scanner;

/**
 * Search
 */
public class Search {

    public int search(int[] arr, int n) {
        try (// Create Random method for array
        Scanner sc = new Scanner(System.in)) {
            Random rd = new Random();
            for (int i = 0; i < n; i++) {
                arr[i] = rd.nextInt(100);
            }
            // The array : [2, 5, 6, 1, 7, 5] display like this
            System.out.println("The array: " + java.util.Arrays.toString(arr));
            System.out.println();
            // Search number in array
            System.out.println("Enter number to search");
            int number = sc.nextInt();
            for (int i = 0; i < n; i++) {
                if (arr[i] == number) {
                    return i;
                }
            }
        }
        return -1;
    }
}