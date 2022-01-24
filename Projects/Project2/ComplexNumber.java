import java.util.Scanner;
public class ComplexNumber {

    // private class data
    private double a; // real portion
    private double b; // imaginary portion

    // Constructors
    // default
    public ComplexNumber() {
        a = 0;
        b = 0;
    }
    // alternate
    public ComplexNumber(double newA, double newB) {
        a = newA;
        b = newB;
    }

    // IO methods
    // print method
    public void print() {
        System.out.printf("(%.2f, %.2f)", a, b);
    }
    // read
    public void read() {
        final String PROMPT = "Enter complex number (real imaginary): ";
        Scanner input = new Scanner(System.in);
        System.out.print(PROMPT);
        String nums = input.nextLine();
        while(countDoubles(nums) != 2) { // get a new string if the current string does not have only 2 doubles
            System.out.print("Error: " + PROMPT);
            nums = input.nextLine();
        }
        Scanner doubles = new Scanner(nums);  // new scanner to set a and b to the respective doubles
        a = doubles.nextDouble();
        b = doubles.nextDouble();
    }
    // getters
    public double getReal() {
        return a;
    }
    public double getImaginary() {
        return b;
    }

    // Ops
    // equals
    public boolean equals(ComplexNumber other) {
        return (a == other.a) && (b == other.b);
    }
    // copy
    public void copy(ComplexNumber other) {
        a = other.a;
        b = other.b;
    }
    // getCopy
    public ComplexNumber getCopy() {
        return new ComplexNumber(a, b);
    }
    // toString
    public String toString() {
        return String.format("(%.2f, %.2f)", a, b);
    }

    // Arithmetics
    // add two complex numbers
    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber((a + other.a), (b + other.b));
    }
    // subtract two complex numbers
    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber((a - other.a), (b - other.b));
    }
    // multiply
    public ComplexNumber multiply(ComplexNumber other) {
        return new ComplexNumber(((a * other.a) - (b * other.b)), ((a * other.b) + (b * other.a)));
    }
    // divide
    public ComplexNumber divide(ComplexNumber other) {
        return new ComplexNumber((((a * other.a) + (b * other.b)) / (Math.pow(other.a, 2) + Math.pow(other.b, 2))), (((b * other.a) - (a * other.b)) / (Math.pow(other.a, 2) + Math.pow(other.b, 2))));
    }
    // complex absolute value
    public double cAbs() {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    // helper methods
    private int countDoubles(String nums) {
        Scanner test = new Scanner(nums);
        int q = 0;
        while (test.hasNext()) { // loops through each token in the string
            if (test.hasNextDouble()) q++; // tests for a double, if current token is not a double, return 0
            else {
                test.close();
                return 0;
            }
            test.next();
        }
        test.close();
        return q;
    }
}
