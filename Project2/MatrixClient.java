//Client for Matrix
import java.util.Scanner;
public class MatrixClient {
    public static final int MAX = 20;
    public static final int LOW = 1;
    public static final int UP = 10;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCommands = 0;
        int infiniteLoop = 1;
        int size;
        int value;
        int tr;

        size = getIntSize(input, "Enter the size of the square matrix: ");
        Matrix first = new Matrix(size);
        Matrix second = new Matrix(size);
        Matrix result = new Matrix(size);

        while (infiniteLoop == 1) {
            menu();
            switch (getIntMenu(input, "Please enter your option: ")) {
                case 0: {
                    System.out.println("Testing completed.");
                    infiniteLoop = 0;
                    break;
                }
                case 1: {
                    first.init(LOW, UP);
                    second.init(LOW, UP);
                    System.out.println("First matrix is:");
                    first.print();
                    System.out.println("Second matrix is:");
                    second.print();
                    System.out.println("The resulting matrix is:");
                    result = first.add(second);
                    result.print();
                    numCommands++;
                    System.out.printf("   Command number %d completed.%n%n", numCommands);
                    break;
                }
                case 2: {
                    first.init(LOW, UP);
                    second.init(LOW, UP);
                    System.out.println("First matrix is:");
                    first.print();
                    System.out.println("Second matrix is:");
                    second.print();
                    System.out.println("The resulting matrix is:");
                    result = first.subtract(second);
                    result.print();
                    numCommands++;
                    System.out.printf("   Command number %d completed.%n%n", numCommands);
                    break;
                }
                case 3: {
                    first.init(LOW, UP);
                    second.init(LOW, UP);
                    System.out.println("First matrix is:");
                    first.print();
                    System.out.println("Second matrix is:");
                    second.print();
                    System.out.println("The resulting matrix is:");
                    result = first.multiply(second);
                    result.print();
                    numCommands++;
                    System.out.printf("   Command number %d completed.%n%n", numCommands);
                    break;
                }
                case 4: {
                    value = getInt(input, "Enter the multiplication constant: ");
                    first.init(LOW, UP);
                    System.out.println("The original matrix is:");
                    first.print();
                    System.out.println("The resulting matrix is:");
                    result = first.multiplyConst(value);
                    result.print();
                    numCommands++;
                    System.out.printf("   Command number %d completed.%n%n", numCommands);
                    break;
                }
                case 5: {
                    first.init(LOW, UP);
                    System.out.println("The original matrix is:");
                    first.print();
                    System.out.println("The resulting matrix is:");
                    result = first.transpose();
                    result.print();
                    numCommands++;
                    System.out.printf("   Command number %d completed.%n%n", numCommands);
                    break;
                }
                case 6: {
                    first.init(LOW, UP);
                    System.out.println("The original matrix is:");
                    first.print();
                    tr = first.trace();
                    System.out.println("The trace for this matrix is: " + tr);
                    numCommands++;
                    System.out.printf("   Command number %d completed.%n%n", numCommands);
                    break;
                }
                case 7: {
                    first.init(LOW, UP);
                    System.out.println("The original matrix is:");
                    first.print();
                    System.out.println("The copy of this matrix is:");
                    result.copy(first);
                    result.print();
                    System.out.println("Testing for equality. Should be equal!!");
                    if (first.equals(result)) System.out.println("The matrices are equal!!");
                    else System.out.println("The matrices are NOT equal!!");
                    numCommands++;
                    System.out.printf("   Command number %d completed.%n%n", numCommands);
                    break;
                }
                case 8: {
                    first.init(LOW, UP);
                    second.init(LOW, UP);
                    System.out.println("The first matrix is:");
                    first.print();
                    System.out.println("The second matrix is:");
                    second.print();
                    if (first.equals(result)) System.out.println("The matrices are equal!!");
                    else System.out.println("The matrices are NOT equal!!");
                    numCommands++;
                    System.out.printf("   Command number %d completed.%n%n", numCommands);
                    break;
                }
            }
        }
    }

    //method to print menu
    private static void menu() {
        System.out.println("Your options are:");
        System.out.println("----------------------------------------");
        System.out.println(" 1) Add 2 matrices");
        System.out.println(" 2) Subtract 2 matrices");
        System.out.println(" 3) Multiply 2 matrices");
        System.out.println(" 4) Multiply matrix by a constant");
        System.out.println(" 5) Transpose matrix");
        System.out.println(" 6) Matrix trace");
        System.out.println(" 7) Make a copy");
        System.out.println(" 8) Test for equality");
        System.out.println(" 0) EXIT");
    }

    //input validation
    private static int getIntMenu(Scanner input, String prompt) {
        final int MAXIMUM = 8;
        final int MINIMUM = 0;
        int test = getInt(input, prompt);
        while (!(test <= MAXIMUM && test >= MINIMUM)) test = getInt(input, "INVALID! Out of range! REENTER: ");
        return test;
    }

    //input validation
    private static int getIntSize(Scanner input, String prompt) {
        int test = getInt(input, prompt);
        while (!(test <= MAX && test >= LOW)) {
            test = getInt(input, "Enter the size of the square matrix: ");
            System.out.println("INPUT ERROR!!! Invalid size. Positive and <= 20.");
        }
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