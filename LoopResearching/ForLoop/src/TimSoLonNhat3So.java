import java.util.Scanner;

public class TimSoLonNhat3So {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Mời bạn nhập số a: ");
            int a = scanner.nextInt();

            System.out.println("Mời bạn nhập số b: ");
            int b = scanner.nextInt();

            System.out.println("Mời bạn nhập số c: ");
            int c = scanner.nextInt();

            int max = 0;

            if (a > b) {
                max = a;
            } else {
                max = b;
            }

            if (c > max) {
                max = c;
            }
            System.out.printf("Max is %d", max);
        }
    }
}
