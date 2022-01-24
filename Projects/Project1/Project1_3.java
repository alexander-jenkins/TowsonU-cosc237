/*
    Alexander Jenkins
    and
    Jacob Lingelbach
 */
import java.util.*;
import java.io.*;
public class Project1_3 {
    public static void main(String[] args) {
        // initialize Scanners, file, and some counters
        Scanner input = new Scanner(System.in);
        File f;
        int intCount = 0;
        // open file and catch any errors
        try {
            System.out.print("Please input the name of the file to be opened: ");
            f = new File(input.next());
            Scanner s = new Scanner(f);
            // determine size of file and array
            do {
                if (s.hasNextInt()) intCount+=1;
                s.next();
            }
            while (s.hasNext());
            s.close();
            // create and fill the array from the file
            int[] array = new int[intCount];
            Scanner s2 = new Scanner(f);
            for (int i = 0; i < intCount; i++){
                if (!s2.hasNextInt()) {
                    do s2.next();
                    while (!s2.hasNextInt());
                }
                array[i] = s2.nextInt();
            }
            s2.close();
            // exit program if there are no integers in the file specified
            if (intCount == 0) {
                System.out.println("Found the file but it has no integers!");
                System.out.println("Testing complete. Exit program.");
                return;
            }
            System.out.printf("Found %d integers in file. Start processing.\n", intCount);
            menu(input, array);
        }
        catch (FileNotFoundException e) {
            System.out.println("--- File NOT Found! ---");
        }
    }

    public static void menu(Scanner input, int[] array) {
        System.out.println("Your options are:");
        System.out.println("-----------------------------------------");
        System.out.println("    1) Shift left");
        System.out.println("    2) Shift left (k steps)/in place");
        System.out.println("    3) Shift left (k steps)/second array");
        System.out.println("    4) Shift right");
        System.out.println("    5) Shift right (k steps)/in place");
        System.out.println("    6) Shift right (k steps)/second array");
        System.out.println("    0) EXIT");
        switch (getIntMenu(input, "Please enter your option: ")) {
            case 0: {
                System.out.print("Testing completed.");
                break;
            }
            case 1: {
                shiftLeft(array);
                menu(input, array);
                break;
            }
            case 2: {
                int k = getInt(input, "Input k (step for shift left): ");
                shiftLeft(array, k);
                menu(input, array);
                break;
            }
            case 3: {
                int k = getInt(input, "Input k (step for shift left): ");
                shiftLeftK(array, k);
                menu(input, array);
                break;
            }
            case 4: {
                shiftRight(array);
                menu(input, array);
                break;
            }
            case 5: {
                int k = getInt(input, "Input k (step for shift right): ");
                shiftRight(array, k);
                menu(input, array);
                break;
            }
            case 6: {
                int k = getInt(input, "Input k (step for shift right): ");
                shiftRightK(array, k);
                menu(input, array);
                break;
            }
            default: {
                System.out.println("INVALID RESPONSE! REENTER: ");
                menu(input, array);
                break;
            }
        }
    }

    // shiftLeft() -- shifts an array left
    public static void shiftLeft(int[] array) {
        System.out.println("The original list is: ");
        print(array);
        int temp = array[0]; // save first value
        for (int i = 0; i < array.length - 1; i++) { // shift items
            array[i] = array[i + 1];
        }
        array[array.length - 1] = temp;
        System.out.println("The list after left rotation is: ");
        print(array);
    }

    // overload shiftLeft() -- shifts an array left
    public static void shiftLeft(int[] array, int k) {
        System.out.println("The original list is: ");
        print(array);
        for (int j = 0; j < k; j++) { // loops k times
            int temp = array[0]; // save first value
            for (int i = 0; i < array.length - 1; i++) { // shift items
                array[i] = array[i + 1];
            }
            array[array.length - 1] = temp;
        }
        System.out.println("The list after left rotation of " + k + " positions is: ");
        print(array);
    }

    public static void shiftLeftK(int[] array, int k) {
        System.out.println("The original list is: ");
        print(array);
        int[] newArray = new int[array.length]; // make an array copy
        for (int i=0; i < array.length; i++)
            newArray[i] = array[i];
        for (int j = 0; j < k; j++) { // loop k times
            int temp = newArray[0]; // save first value
            for (int i = 0; i < newArray.length - 1; i++) { // shift items
                newArray[i] = newArray[i + 1];
            }
            newArray[newArray.length - 1] = temp;
        }
        System.out.println("The second list after left rotation of " + k + " positions is: ");
        print(newArray);
    }

    public static void shiftRight(int[] array) {
        System.out.println("The original list is: ");
        print(array);
        int temp = array[array.length - 1]; // save the last value
        for (int i = array.length - 1; i > 0; i--) // shift items
            array[i] = array[i - 1];
        array[0] = temp;
        System.out.println("The list after right rotation is: ");
        print(array);
    }

    public static void shiftRight(int[] array, int k) {
        System.out.println("The original list is: ");
        print(array);
        for (int j = 0; j < k; j++) { // loop until k
            int temp = array[array.length - 1]; // save the last value
            for (int i = array.length - 1; i > 0; i--) // shift items
                array[i] = array[i - 1];
            array[0] = temp;
        }
        System.out.println("The list after right rotation of " + k + " positions is: ");
        print(array);
    }

    public static void shiftRightK(int[] array, int k) {
        System.out.println("The original list is: ");
        print(array);
        int[] newArray = new int[array.length]; // create an array copy
        for (int i=0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        for (int j = 0; j < k; j++) { // loop k times
            int temp = newArray[newArray.length - 1];
            for (int i = newArray.length - 1; i > 0; i--) // shift items
                newArray[i] = newArray[i - 1];
            newArray[0] = temp;
        }
        System.out.println("The second list after right rotation of " + k + " positions is: ");
        print(newArray);
    }

    //  print() method to print the elements of an array
    public static void print(int[] numbers){
        for (int number : numbers) System.out.printf("%d ", number); // print every item in array with formatting
        System.out.print("\n");
    }

    // getInt() -- performs input validation on an integer input
    public static int getInt(Scanner input, String prompt) {
        System.out.print(prompt);
        while(!input.hasNextInt()) { // forces user to keep retrying until they input an integer
            input.next();
            System.out.print("WRONG TYPE! Not an integer! REENTER: ");
        }
        return input.nextInt(); // returns the validated integer
    }

    // getIntMenu() -- performs input validation on an integer input and ensures that it is in the proper range
    public static int getIntMenu(Scanner input, String prompt) {
        int rangeTest;
        System.out.print(prompt);
        while (true) {
            if (!input.hasNextInt()) {
                System.out.print("WRONG TYPE! Not an integer! REENTER: ");
            } else {
                rangeTest = input.nextInt();
                if (rangeTest >= 0 && rangeTest <= 6)
                    return rangeTest;
                System.out.print("INVALID! Out of range! REENTER: ");
            }
            input.nextLine();
        }
    }

}