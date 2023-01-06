import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        do {
            // Enter the number of arrays
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the number of elements");
            int n = input.nextInt();
            // Check validation from Validation class
            if (Validation.isNumber(n)) {
                int[] arr = new int[n];
                Search searchSome = new Search();
                int result = searchSome.search(arr, n);
                if (result == -1) {
                    System.out.println("Not found");
                } else {
                    System.out.println("Found at index " + (result+1));
                }
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
