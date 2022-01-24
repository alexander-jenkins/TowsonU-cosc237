import java.util.*;
public class ClientEmployee {
    public static void main(String[] args) {

        // --------------------------------------------------------------------------------
        // given code from the lab directions\
        Scanner input = new Scanner(System.in);
        String first, last, dept;
        double pay_rate;
        int hours;
        Employee prof = new Employee("John", "Doe", 25.50, 50, "COSC");
        Employee newEmp = new Employee();
        // --------------------------------------------------------------------------------

        // collect information on the new employee
        System.out.print("Enter the employee's last name: ");
        last = input.nextLine();
        System.out.print("Enter the employee's first name: ");
        first = input.nextLine();
        System.out.print("Enter the employee's department: ");
        dept = input.nextLine();
        System.out.print("Enter the employee's pay-rate: ");
        pay_rate = input.nextDouble();
        hours = getInt(input, "Enter the employee's hours worked: ");

        // configure the new employee
        newEmp.setAll(first, last, pay_rate, hours, dept);

        // print out the employees records
        System.out.println("--- Record for both employees with overridden .toString from subclass ---");
        System.out.printf("%s", prof);
        System.out.printf("%s", newEmp);
        System.out.println("--- Output with calls to overridden method print from subclass ---");
        prof.print();
        newEmp.print();
        System.out.println("--- Output with calls to getters from the superclass ---");
        System.out.printf("The wages for %s %s from the %s department are $%.2f\n", newEmp.getFirstName(), newEmp.getLastName(), newEmp.getDepartment(), newEmp.calculatePay());
        System.out.println("--- Call to overridden equals/subclass for 2 Employee objects---");
        if (prof.equals(newEmp)) System.out.println("These two employees have the same record.");
        else System.out.println("Couldn't find and employee with the same record.");
    }

    private static int getInt(Scanner input, String prompt) {
        System.out.print(prompt);
        while (!input.hasNextInt()) {
            input.next();
            System.out.print("Not an integer! Try again: ");
        }
        return input.nextInt();
    }

}
