public class App {
    public static void main(String[] args) throws Exception {
        int count = 0;
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.printf("%d " , count);
                count = count + 1;        
            }
            System.out.println();
        }
    }
}
