public class ChangeBase {
    private int input;
    private int output;
    private String value;
    private String result;

    public ChangeBase(int input, int output, String value) {
        this.input = input;
        this.output = output;
        this.value = value;
    }

    public void change() {
        if (input == 1 && output == 2) {
            result = binaryToDecimal();
        } else if (input == 1 && output == 3) {
            result = binaryToHexadecimal();
        } else if (input == 2 && output == 1) {
            result = decimalToBinary();
        } else if (input == 2 && output == 3) {
            result = decimalToHexadecimal();
        } else if (input == 3 && output == 1) {
            result = hexadecimalToBinary();
        } else if (input == 3 && output == 2) {
            result = hexadecimalToDecimal();
        }
    }

    public String getValue() {
        return result;
    }

    private String binaryToDecimal() {
        int decimal = 0;
        int length = value.length();
        for (int i = 0; i < length; i++) {
            if (value.charAt(i) == '1') {
                decimal += Math.pow(2, length - i - 1);
            }
        }
        return String.valueOf(decimal);
    }

    private String binaryToHexadecimal() {
        int decimal = Integer.parseInt(binaryToDecimal());
        return decimalToHexadecimal(String.valueOf(decimal));
    }

    private String decimalToBinary() {
        int decimal = Integer.parseInt(value);
        String binary = "";
        while (decimal > 0) {
            binary = (decimal % 2) + binary;
            decimal /= 2;
        }
        return binary;
    }

    private String decimalToHexadecimal() {
        int decimal = Integer.parseInt(value);
        String hexadecimal = "";
        while (decimal > 0) {
            int temp = decimal % 16;
            if (temp < 10) {
                hexadecimal = temp + hexadecimal;
            } else {
                hexadecimal = (char) (temp + 55) + hexadecimal;
            }
            decimal /= 16;
        }
        return hexadecimal;
    }

    private String hexadecimalToBinary() {
        int decimal = Integer.parseInt(hexadecimalToDecimal());
        return decimalToBinary(String.valueOf(decimal));
    }

    private String hexadecimalToDecimal() {
        int decimal = 0;
        int length = value.length();
        for (int i = 0; i < length; i++) {
            char c = value.charAt(i);
            int temp = 0;
            if (c >= '0' && c <= '9') { 
                temp = c - '0';
            } else if (c >= 'A' && c <= 'F') {
                temp = c - 55; 
            }
            decimal += temp * Math.pow(16, length - i - 1);
        }
        return String.valueOf(decimal); 
    }

    private String decimalToBinary(String value) {
        int decimal = Integer.parseInt(value);
        String binary = "";
        while (decimal > 0) {
            binary = (decimal % 2) + binary;
            decimal /= 2;
        }
        return binary;
    }

    private String decimalToHexadecimal(String value) {
        int decimal = Integer.parseInt(value);
        String hexadecimal = "";
        while (decimal > 0) {
            int temp = decimal % 16;
            if (temp < 10) {
                hexadecimal = temp + hexadecimal;
            } else {
                hexadecimal = (char) (temp + 55) + hexadecimal;
            }
            decimal /= 16;
        }
        return hexadecimal;
    }
}
