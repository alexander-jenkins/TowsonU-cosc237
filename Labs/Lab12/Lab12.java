import java.util.Scanner;
public class Lab12 {
    public static void main(String[] args) {
        int num, base;
        char temp;
        boolean cont;
        Scanner input = new Scanner(System.in);
        do {
            num = getInt(input, "Enter a positive integer: ");
            if (num < 0) do {
                num = getInt(input, "INVALID! Should be a positive integer! REENTER: ");
            } while (num < 0);
            base = getInt(input, "Enter a positive integer for base: ");
            if (base < 0) do {
                base = getInt(input, "INVALID! Should be a positive integer! REENTER: ");
            } while (base < 0);
            System.out.printf("Sum of digits for %d is %d (iterative solution)%n", num, sumIntDigits(num));
            System.out.printf("Sum of digits for %d is %d (recursive solution)%n", num, sumIntDigitsRecursive(num));
            binary(num);
            binaryRecursive(num);
            System.out.printf("%d in base %d is %s (iterative solution)%n", num, base, newBase(num, base));
            System.out.printf("%d in base %d is %s (recursive solution)%n", num, base, newBaseRecursive(num, base));
            System.out.print("Would you like to continue (y/Y): ");
            temp = input.next().charAt(0);
            cont = temp == 'y' || temp == 'Y';
        } while (cont);
    }

    // find sum of digits of any integer
    public static int sumIntDigits(int num) {
        int sum = 0;
        // grab the last number and add it to the total
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    // find sum of digits of any integer (recursive)
    public static int sumIntDigitsRecursive(int num) {
        // if 0, return 0 - else, return the next digit
        return (num == 0) ? 0 : num % 10 + sumIntDigitsRecursive(num/10);
    }

    // display a number in binary
    public static void binary(int num) {
        int old = num;
        // we can use log base 2 to determine how many bits an integer takes up and create an array based off that
        int[] binary = new int[(int)(Math.log(num)/Math.log(2)) + 1];
        // convert the number to binary
        for (int i = binary.length - 1; i >= 0; i--) {
            binary[i] = num % 2;
            num /= 2;
        }
        // print the binary number
        System.out.print(old + " in binary is ");
        for (int bit : binary) {
            System.out.print(bit);
        }
        System.out.println(" (iterative solution)");
    }

    // display a number in binary (recursive)
    public static void binaryRecursive(int num) {
        System.out.print(num + " in binary is ");
        binaryRecursiveHelper(num);
        System.out.println(" (recursive solution)");
    }
    public static void binaryRecursiveHelper(int num) {
        if (num > 1) binaryRecursiveHelper(num / 2);
        System.out.print(num % 2);
    }

    // string representation of a number in any base
    public static String newBase(int num, int base) {
        String convertedString = "";
        // we can use log base of base to determine how many bits are needed up and create an array based off that
        int[] converted = new int[(int)(Math.log(num)/Math.log(base)) + 1];
        // convert the number to the new base
        for (int i = converted.length - 1; i >= 0; i--) {
            converted[i] = num % base;
            num /= base;
        }
        for (int bit : converted) {
            convertedString += bit;
        }
        return convertedString;
    }

    // string representation of a number in any base (recursive)
    public static String newBaseRecursive(int num, int base) {
        return (num == 0) ? "" : newBaseRecursive(num/base, base) + Integer.toString(num % base);
    }

    private static int getInt(Scanner input, String prompt) {
        System.out.print(prompt);
        while (!input.hasNextInt()) {
            input.next();
            System.out.print("WRONG TYPE! Not a positive integer! REENTER: ");
        }
        return input.nextInt();
    }
}
