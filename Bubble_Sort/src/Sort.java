import java.util.Random;

/**
 * Sort
 */
public class Sort {

    void bubble(int arr[], int n){
        Random rd = new Random(); 
        // Create a Random method for aray
        for (int i = 0; i < n; i++) {
            arr[i] = rd.nextInt(100);
        }

        System.out.println("Display array");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
        // Sort the array
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n - 1; j++){
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Display array after sort");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

}
