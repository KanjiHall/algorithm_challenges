import java.util.Scanner;

public class Fibonancci {
    public static void main(String[] args) {
        // Fibonanci
        // f(n) = f(n-1) + f(n-2) với n > 2
        // 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
        Scanner scanner = new Scanner(System.in);
        do {

            System.out.println("Enter n: ");
            int n = scanner.nextInt();
            
            // validate
            if(n < 3){
                System.out.println("n phải lớn hơn 2");
                continue;
            }

            int fn = 0;
            int fn1 = 1;
            int fn2 = 1;

            System.out.printf("%d ", fn1);
            System.out.printf("%d ", fn2);
            for (int i = 3; i <= n; i++) {
                fn = fn1 + fn2;
                System.out.printf("%d ", fn);
                // Cập nhật giá trị 2 biến fn1, fn2
                fn1 = fn2;
                fn2 = fn;
            }
            System.out.println();

        } while (true);
    }
}
