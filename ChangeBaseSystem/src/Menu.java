public class Menu {
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
