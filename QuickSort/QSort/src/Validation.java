public class Validation {
    // Check if the input is a number
    public static boolean isNumber(int n) {
        try {
            // nếu n là chữ cái thì bắt nhập số khác
            if (n < 0 || n > 100 || n == 0) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            // TODO: handle exception
            // System.out.println("Please enter the number of elements");
            return false;
        }
}
}