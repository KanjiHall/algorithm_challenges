public class Menu {
    // Design a program that allows users choose the input base system (2, 10, 16)
    // and the output base system (2,10,16) then enter input value, the program will
    // print the equivalent output value
    // The program should be repetitive until users close the program
    // Function details:
    // 1. Required user choose the base number input ( example 1 is binary, 2 is
    // decimal, 3 is hexadecimal)
    // 2. Required user choose the base number out ( example 1 is binary, 2 is
    // decimal, 3 is hexadecimal)
    // 3. Required user enter the input value;
    // 4. Program process and print output value;
    // 5. Program ask user if they want to continue or not;
    // 6. If user choose to continue, program will repeat from step 1;
    // 7. If user choose to exit, program will exit;
    // 8. Program should be repetitive until users close the program
    // 9. Program should be able to handle invalid input from user from Validation
    // class
    public void Console() {
        do {
            // Clear screen after each loop
            System.out.print("\033[H\033[2J");
            System.out.flush();
            // Menu
            System.out.println("Change base number system");
            System.out.println("1. Binary");
            System.out.println("2. Decimal");
            System.out.println("3. Hexadecimal");
            System.out.print("Choose input base: ");
            int input = Validation.checkInputIntLimit(1, 3);
            System.out.print("Choose output base: ");
            int output = Validation.checkInputIntLimit(1, 3);
            System.out.print("Enter input value: ");
            String value = Validation.checkInputString();
            ChangeBase changeBase = new ChangeBase(input, output, value);
            changeBase.change();
            System.out.println("Result: " + changeBase.getValue());
            System.out.print("Do you want to continue? (Y/N): ");
            if (!Validation.checkInputYN()) {
                break;
            }
        } while (true);
    }
}
