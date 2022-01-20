import java.util.*;
public class TimeClient {
    public static void main(String[] args) {
        // create the scanner and initial time objects / variables
        Scanner input = new Scanner(System.in);
        Time t1 = new Time(8, 15, 30);
        Time t2 = new Time();
        int hours, minutes, seconds;

        // print out time one in military and standard forms
        System.out.print("Initial time t1 (alternate constructor invoked) - military format: ");
        t1.printMilitary();
        System.out.print("\n");
        System.out.print("Initial time t1 (alternate constructor invoked) - standard format: ");
        t1.printStandard();
        System.out.print("\n");

        // print out time two in military and standard forms
        System.out.print("Initial time t2 (default constructor invoked) - military format: ");
        t2.printMilitary();
        System.out.print("\n");
        System.out.print("Initial time t2 (default constructor invoked) - standard format: ");
        t2.printStandard();
        System.out.print("\n");

        // set time for t2 and print the new time
        t2.set(9, 45, 35);
        System.out.print("t2 after call to setTime - military format: ");
        t2.printMilitary();
        System.out.print("\n");
        System.out.print("t2 after call to setTime - standard format: ");
        t2.printStandard();
        System.out.print("\n");

        // determine if the times are equal and print the result
        if (t1.equals(t2)) System.out.println("After call to equals: times are equal.");
        else System.out.println("After call to equals: times are NOT equal.");

        // determine which time is the lesser
        if (t1.lessThan(t2)) System.out.println("After call to lessThan: t1 is less than t2.");
        else System.out.println("After call to lessThan: t1 is not less than t2.");

        // set t1 to a new time using inputted values
        hours = getInt(input, "Enter hours: ");
        minutes = getInt(input, "Enter mins: ");
        seconds = getInt(input, "Enter secs: ");
        t1.set(hours, minutes, seconds);

        // print the new t1 in standard form
        System.out.print("New time t1 after call to setTime - standard format: ");
        t1.printStandard();
        System.out.print("\n");

        // advance the time in t1 by a second
        t1.advanceSecs();

        // print out the new t1 in standard form again
        System.out.print("New time t1 after call to advanceSecs - standard format: ");
        t1.printStandard();
        System.out.print("\n");

        // copy the new t1 into t2
        t2.copy(t1);

        // print out the new t2
        System.out.print("New time t2 after call to copy - standard format: ");
        t2.printStandard();
        System.out.print("\n");

        // test toString for t2
        System.out.printf("Test toString for t2: %s\n", t2);

        // test all methods for Lab4_3

        // test for inequality
        if (t1.notEquals(t2)) System.out.println("t2 does not equal t2.");
        else System.out.println("t1 equals t2.");

        // test for lessOrEqual
        if (t1.lessOrEquals(t2)) System.out.println("t1 is less than or equal to t1");
	    else System.out.println("t1 is greater than t2.");

	    // test greaterThan
        if (t1.greaterThan(t2)) System.out.println("t1 is greater than t2.");
        else System.out.println("t2 is greater than t1.");

        // test greater or equal to
        if (t1.greaterOrEquals(t2)) System.out.println("t1 is greater than or equal to t2.");
        else System.out.println("t2 is greater than t1.");

        // test the incrementer methods
        t1.advanceSecs();
        t1.advanceMins();
        t1.advanceHrs();

        // copy the new t1 into t2
        t2 = t1.getCopy();

        // print using the to military and to standard
        System.out.println("t1 in standard form is: " + t1.toStandard());
        System.out.println("t2 in standard form is: " + t2.toStandard());
        System.out.println("t1 in military form is: " + t1.toMilitary());
        System.out.println("t2 in military form is: " + t2.toMilitary());
    }

    private static int getInt(Scanner input, String prompt){ // helper -- helps build other methods
        System.out.print(prompt);
        while (!input.hasNextInt()) {
            input.next();
            System.out.print("Not an integer! Try again: ");
        }
        return input.nextInt();
    }
}
