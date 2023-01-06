import java.util.Random;
import java.util.Scanner;

public class SapXepVetCan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        System.out.println("Enter the number of elements");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rd.nextInt(100);
        }
        display(arr);
        int[] result = sapXep(arr);
        System.out.println();
        display(result);
    }

    private static int[] sapXep(int[] x) {
        System.out.println();
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                // System.out.println("i: " + i + " j: " + j + "\t" + x[i] + " < " + x[j]); // DEBUG
                if (x[j] > x[i]) { // First "= x[i]; Second = x[j];
                    System.out.println("swap");
                    int temp = x[i];
                    x[i] = x[j];
                    x[j] = temp;
                    display(x);
                }
            }
        }
        return x;
    }

    private static void display(int[] x) {
        System.out.print("The Array: ");
        for (int i : x) {
            System.out.printf("%d ", i);
        }
    }
}
