/*
    Alexander Jenkins
    and
    Jacob Lingelbach
 */
import java.util.*;
public class Project1_1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int counter = 0;
        menu(input, counter);
    }

    // menu() method for determining which operations to perform
    public static void menu(Scanner input, int counter){
        System.out.println("Your options are:");
        System.out.println("------------------------------------");
        System.out.println("    1) Add 2 matrices");
        System.out.println("    2) Subtract 2 matrices");
        System.out.println("    3) Multiply 2 matrices");
        System.out.println("    4) Multiply matrix by a constant");
        System.out.println("    5) Transpose matrix");
        System.out.println("    6) Matrix trace");
        System.out.println("    0) EXIT");
        switch (getInt(input, "Please enter your option: ")) {
            case 0: { // ends program
                System.out.println("Testing completed.");
                break;
            }
            case 1: { // add matrices together
                addMatrices(input);
                counter++;
                System.out.println("                                      Command number " + counter + " completed.");
                menu(input, counter);
                break;
            }
            case 2: { // subtract matrices from one another
                subtractMatrices(input);
                counter++;
                System.out.println("                                      Command number " + counter + " completed.");
                menu(input, counter);
                break;
            }
            case 3: { // multiply matrices together
                multiplyMatrices(input);
                counter++;
                System.out.println("                                      Command number " + counter + " completed.");
                menu(input, counter);
                break;
            }
            case 4: { // multiply a matrix by a constant
                multiplyMatrixConstant(input);
                counter++;
                System.out.println("                                      Command number " + counter + " completed.");
                menu(input, counter);
                break;
            }
            case 5: { // transpose a matrix
                transposeMatrix(input);
                counter++;
                System.out.println("                                      Command number " + counter + " completed.");
                menu(input, counter);
                break;
            }
            case 6: { // trace a matrix
                traceMatrix(input);
                counter++;
                System.out.println("                                      Command number " + counter + " completed.");
                menu(input, counter);
                break;
            }
            default: { // restart the loop upon invalid response
                System.out.println("Invalid response, please try again.");
                menu(input, counter);
                break;
            }
        }

    }

    // traceMatrix() -- traces a matrix
    public static void traceMatrix(Scanner input) {
        int size = getInt(input, "Enter the size of the square matrix: ");
        int[][] matrix = generate(size);
        int trace = 0;
        for (int i = 0; i < size; i++) trace += matrix[i][i]; // find the trace -- sum the diagonal
        System.out.println("The matrix is:");
        print(matrix);
        System.out.printf("The trace for this matrix is: %d\n", trace);
    }

    // transposeMatrices
    public static void transposeMatrix(Scanner input) {
        int size = getInt(input, "Enter the size of the square matrix: ");
        int[][] matrix = generate(size);
        int[][] transposition = new int[size][size]; // create array for the transposed matrix
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++){
                if (i != j) transposition[j][i] = matrix[i][j]; // reflect across y = -x
                else transposition[i][j] = matrix[i][j]; // keep the diagonals the same
            }
        }
        System.out.println("The matrix is:");
        print(matrix);
        System.out.println("The transposed matrix is:");
        print(transposition);
    }

    // multiplyMatrixConstant() -- multiplies a matrix by a constant
    public static void multiplyMatrixConstant(Scanner input) {
        int size = getInt(input, "Enter the size of the square matrix: ");
        int[][] matrix = generate(size);
        final int CONSTANT = getInt(input, "Enter the multiplication constant: ");
        System.out.println("First matrix is:");
        print(matrix);
        System.out.println("The resulting matrix is:");
        int[][] product = new int[size][size]; // create array for the product
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) product[i][j] = (matrix[i][j]) * CONSTANT; // multiply each item in the array by the constant
        }
        print(product);
    }

    // multiplyMatrices() -- multiplies 2 matrices together
    public static void  multiplyMatrices(Scanner input) {
        int size = getInt(input, "Enter the size of the square matrix: ");
        int[][] matrix1 = generate(size);
        System.out.println("First matrix is:");
        print(matrix1);
        int[][] matrix2 = generate(size);
        System.out.println("Second matrix is:");
        print(matrix2);
        System.out.println("The resulting matrix is:");
        int[][] product = new int[size][size]; // create array for product
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    product[i][j] += matrix1[i][k] * matrix2[k][j]; // sum the products of each row times the column
                }
            }
        }
        print(product);
    }

    // addMatrices() -- adds 2 matrices together
    public static void addMatrices(Scanner input){
        int size = getInt(input, "Enter the size of the square matrix: ");
        int[][] matrix1 = generate(size);
        System.out.println("First matrix is:");
        print(matrix1);
        int[][] matrix2 = generate(size);
        System.out.println("Second matrix is:");
        print(matrix2);
        System.out.println("The resulting matrix is:");
        int[][] sum = new int[size][size]; // create an array for sum
        for(int i = 0; i < size; i++){
            for (int j = 0; j < size; j++) sum[i][j] = matrix1[i][j] + matrix2[i][j]; // sum 2 matrices
        }
        print(sum);
    }

    // subtractMatrices -- subtracts 2 matrices from each other
    public static void subtractMatrices(Scanner input){
        int size = getInt(input, "Enter the size of the square matrix: ");
        int[][] matrix1 = generate(size);
        System.out.println("First matrix is:");
        print(matrix1);
        int[][] matrix2 = generate(size);
        System.out.println("Second matrix is:");
        print(matrix2);
        System.out.println("The resulting matrix is:");
        int[][] difference = new int[size][size]; // create an array for the difference
        for(int i = 0; i < size; i++){
            for (int j = 0; j < size; j++) difference[i][j] = matrix1[i][j] - matrix2[i][j]; // subtract the 2 matrices
        }
        print(difference);
    }

    // getInt() -- performs input validation on an integer input
    public static int getInt(Scanner input, String prompt) {
        System.out.print(prompt);
        while (!input.hasNextInt()) { // forces user to keep retrying until they input an integer
            input.next();
            System.out.print("WRONG TYPE! Not an integer! REENTER: ");
        }
        return input.nextInt(); // returns the validated integer
    }

    // generate() method for creating a square matrix with values 1 - 10
    public static int[][] generate(int size){
        int[][] matrix = new int[size][size]; // create a new matrix
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (int) Math.round(Math.random()*10); // get a random number 1 - 10
            }
        }
        return matrix; // return the random matrix
    }

    // print() method to print the matrix
    public static void print(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] >= 10) System.out.printf("%d ", matrix[i][j]); // print 2d matrix with proper formatting
                else if (matrix[i][j] < 0) System.out.printf(" %d", matrix[i][j]);
                else System.out.printf(" %d ", matrix[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }

}