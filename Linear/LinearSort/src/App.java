import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter number of array");
            int n = input.nextInt();
            if (Validation.isNumber(n)) {
                int[] arr = new int[n];
                Search search = new Search();
                int index = search.search(arr, n);
                if (index == -1) {
                    System.out.println("Not found");
                } else {
                    System.out.println("Found at index " + index);
                }
            }
            // Do you want to continue?
            System.out.println("Do you want to continue? (Y/N)");
            String answer = input.next();
            if (answer.equalsIgnoreCase("N")) {
                break;
            }
        } while (true);
    }
}
