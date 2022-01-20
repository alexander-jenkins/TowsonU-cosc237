//Client for ComplexNumbers
import java.util.Scanner;
public class ComplexNumberClient {
    public static void main(String[] args) {
        int counter = 0;
        int infiniteLoop = 1;
        Scanner input = new Scanner(System.in);
        ComplexNumber one = new ComplexNumber();
        ComplexNumber two = new ComplexNumber();
        while (infiniteLoop == 1) {
            menu();
            switch(getIntMenu(input, "Please enter your option: ")) {
                case 0: {
                    System.out.println("Testing completed.");
                    infiniteLoop = 0;
                    break;
                }
                case 1: {
                    System.out.println();
                    one.read();
                    two.read();
                    System.out.printf("First complex number is: %s%n", one);
                    System.out.printf("Second complex number is: %s%n", two);
                    System.out.printf("Result: %s + %s = %s%n", one, two, one.add(two));
                    counter++;
                    System.out.printf("   Command number %d completed.%n%n", counter);
                    break;
                }
                case 2: {
                    System.out.println();
                    one.read();
                    two.read();
                    System.out.printf("First complex number is: %s%n", one);
                    System.out.printf("Second complex number is: %s%n", two);
                    System.out.printf("Result: %s - %s = %s%n", one, two, one.subtract(two));
                    counter++;
                    System.out.printf("   Command number %d completed.%n%n", counter);
                    break;
                }
                case 3: {
                    System.out.println();
                    one.read();
                    two.read();
                    System.out.printf("First complex number is: %s%n", one);
                    System.out.printf("Second complex number is: %s%n", two);
                    System.out.printf("Result: %s * %s = %s%n", one, two, one.multiply(two));
                    counter++;
                    System.out.printf("   Command number %d completed.%n%n", counter);
                    break;
                }
                case 4: {
                    System.out.println();
                    one.read();
                    two.read();
                    System.out.printf("First complex number is: %s%n", one);
                    System.out.printf("Second complex number is: %s%n", two);
                    System.out.printf("Result: %s / %s = %s%n", one, two, one.divide(two));
                    counter++;
                    System.out.printf("   Command number %d completed.%n%n", counter);
                    break;
                }
                case 5: {
                    System.out.println();
                    one.read();
                    System.out.printf("The complex number is: %s%n", one);
                    System.out.printf("Result: |%s| = %s%n", one, one.cAbs());
                    counter++;
                    System.out.printf("   Command number %d completed.%n%n", counter);
                    break;
                }
                case 6: {
                    System.out.println();
                    one.read();
                    two.read();
                    System.out.printf("First complex number is: %s%n", one);
                    System.out.printf("Second complex number is: %s%n", two);
                    if (one.equals(two)) System.out.println("The complex numbers are equal.");
                    else System.out.println("The complex numbers are NOT equal.");
                    counter++;
                    System.out.printf("   Command number %d completed.%n%n", counter);
                    break;
                }
            }

        }
    }

    //method to print menu
    private static void menu() {
        System.out.println("Your options for Complex arithmetic are:");
        System.out.println("----------------------------------------");
        System.out.println(" 1) Add 2 complex numbers");
        System.out.println(" 2) Subtract 2 complex numbers");
        System.out.println(" 3) Multiply 2 complex numbers");
        System.out.println(" 4) Divide 2 complex numbers");
        System.out.println(" 5) Absolute value of a complex number");
        System.out.println(" 6) Compare 2 complex numbers");
        System.out.println(" 0) EXIT");
    }

    //input validation
    private static int getIntMenu(Scanner input, String prompt) {
        final int MAXIMUM = 6;
        final int MINIMUM = 0;
        int test = getInt(input, prompt);
        while (!(test <= MAXIMUM && test >= MINIMUM)) test = getInt(input, "INVALID! Out of range! REENTER: ");
        return test;
    }

    //input validation
    private static int getInt(Scanner input, String prompt) {
        System.out.print(prompt);
        while (!input.hasNextInt()) {
            input.next();
            System.out.print("INVALID! Not an integer! REENTER: ");
        }
        return input.nextInt();
    }
}