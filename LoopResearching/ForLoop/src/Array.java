import java.util.Scanner;

public class Array {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] scores = new int[5];
        for (int i = 0; i < scores.length; i++) {
            System.out.println("Mời bạn nhập cho phần tử thứ i: " + i);
            scores[i] = scanner.nextInt();
        }
      

        // Tìm giá trị lớn nhất trong mảng vừa nhập
        // Tìm giá trị nhỏ nhất trong mảng vừa nhập
        // In ra các phần tử chẵn của mảng
        // In ra các phần tử lẻ của mảng


        // Tìm giá trị lớn nhất trong mảng vừa nhập
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < scores.length; i++) {
            if(max < scores[i]){
                max  = scores[i];
            }
        }

        // Tìm giá trị nhỏ nhất trong mảng vừa nhập
        int min =  Integer.MAX_VALUE;
        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];
            if(min > score){
                min = score;
            }
        }

        // In ra các phần tử chẵn của mảng
        System.out.print("Các phần tử chẵn trong mảng là: ");
        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];
            if(score%2 == 0){
                System.out.printf("%d ", score);
            }
            
        }
        System.out.println();

        // In ra các phần tử lẻ của mảng
        System.out.print("Các phần tử lẻ trong mảng là: ");
        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];
            if(score%2 != 0){
                System.out.printf("%d ", score);
            }
        }

        System.out.println();
        System.out.printf("Max Value: %d", max);
        System.out.println();
        System.out.printf("Min Value: %d", min);
    }
}
