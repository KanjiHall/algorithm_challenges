
import java.util.Scanner;

public class BubbleSort {
    /**
     * @param args
     */
    public static void main(String[] args) {
        do {
            // Enter the number of arrays
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the number of elements");
            int n = input.nextInt();
            // Check validation from Validation class
            if (Validation.isNumber(n)) {
                int[] arr = new int[n];
                Sort sort = new Sort();
                sort.bubble(arr, n);
            } else {
                System.out.println("Please enter the number of elements");
                continue;
            }
            System.out.println("Do you want to continue? (Y/N)");
            String answer = input.next();
            if (answer.equalsIgnoreCase("N")) {
                break;
            }

        } while (true);// End of do-while loop
    }
}
