import java.util.ArrayList;
import java.util.Scanner;

public class Validation {

    static Scanner sc = new Scanner(System.in);

    public static String checkInputString() {
        String answer;
        while (true) {
            answer = sc.nextLine();
            if (!answer.isEmpty()) {
                return answer;
            } else {
                System.out.println("Invalid!");
                System.out.println("Enter again: ");
            }
        }
    }

    public static String checkInputYesNo() {
        //Scanner scanner = new Scanner(System.in);
        while (true) {
            String inputString = checkInputString();
            if (inputString.equalsIgnoreCase("Y")) {
                return "Y";
            } else if (inputString.equalsIgnoreCase("N")) {
                return "N";
            } else {
                System.out.print("Please enter Y/y or N/n: ");
            }
        }
    }

    // public static boolean checkExistName(ArrayList<Fruit> fruitList, String select) {
    //     for (Fruit fruit : fruitList) {
    //         if (fruit.getName().equalsIgnoreCase(select)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    public static double checkInputDouble() {
        String input;
        while (true) {
            input = checkInputString();
            try {
                if (Double.parseDouble(input) <= 0) {
                    System.out.println("Number must be greater than 0!");
                    System.out.print("Enter again: ");
                } else {
                    return Double.parseDouble(input);
                }
            } catch (NumberFormatException e) {
                System.out.println("Number must be number!");
                System.out.print("Enter again: ");
            }
        }
    }

    public static int checkInputInt() {
        String input;
        while (true) {
            input = checkInputString();
            try {
                if (Integer.parseInt(input) <= 0) {
                    System.out.println("Number must be greater than 0!");
                    System.out.print("Enter again: ");
                } else {
                    return Integer.parseInt(input);
                }
            } catch (NumberFormatException e) {
                System.out.println("Number must be number!");
                System.out.print("Enter again: ");
            }
        }
    }

    public static int checkInputInRange(int a, int b) {
        String input;
        while (true) {
            input = checkInputString();
            try {
                if (Integer.parseInt(input) < a || Integer.parseInt(input) > b) {
                    System.out.println("Number must be in range " + a + " to " + b + " !");
                    System.out.print("Enter again: ");
                } else {
                    return Integer.parseInt(input);
                }
            } catch (NumberFormatException e) {
                System.out.println("Number must be number!");
                System.out.print("Enter again: ");
            }
        }
    }

    // public static boolean checkIdIsExist(ArrayList<Fruit> fruitList, int id) {
    //     for (Fruit fruit : fruitList) {
    //         return fruit.getItemID() == id;
    //     }
    //     return false;
    // }
    
    // public static boolean checkNameIsExist(ArrayList<Fruit> fruitList, String name) {
    //     for (Fruit fruit : fruitList) {
    //         return fruit.getName().equalsIgnoreCase(name);
    //     }
    //     return false;
    // }
    
    // public static int checkQuantity(ArrayList<Fruit> fruitList, String name) {
    //     int input;
    //     while (true) {
    //         input = checkInputInt();
    //         for (Fruit fruit : fruitList) {
    //             if(fruit.getName().equalsIgnoreCase(name)){
    //                 if(input<= fruit.getQuantity()){
    //                     return input;
    //                 }else{
    //                     System.out.println("Number must be smaller than or equal to "  + fruit.getQuantity());
    //                     System.out.print("Enter again: ");
    //                 }
    //             }
    //         }
          
    //     }
    // }
  
}