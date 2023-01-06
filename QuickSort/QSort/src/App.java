import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Generate a random array based on input and use the quickSort method 
        // from Sort.java to sort the array
        do {
            // Generate a random array
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the number of array: ");
            int n = sc.nextInt();
            // Check if the input is a number
            if (Validation.isNumber(n)) {
                int[] arr = new int[n];
                // Call randomArray method from Sort.java                
                Sort sort = new Sort();
                sort.randomArray(arr);
                // Call quickSort method from Sort.java
                sort.quickSort(arr, 0, arr.length - 1);
                // Call display method from Sort.java
                sort.display(arr);
                break;
            } else {
                System.out.println("Please enter the number of elements");
            }        
        } while (true);
    }
}
