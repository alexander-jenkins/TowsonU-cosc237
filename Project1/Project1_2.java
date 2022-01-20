/*
    Alexander Jenkins
    and
    Jacob Lingelbach
*/
import java.util.*;
public class Project1_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        menu(input); // call the menu and pass it the scanner for input
    }

    // menu() -- performs all 6 tasks and loops itself
    public static void menu(Scanner input) {
        System.out.println("Your options are:");
        System.out.println("-----------------------------------------");
        System.out.println("    1) Shift left");
        System.out.println("    2) Shift left (k steps)/in place");
        System.out.println("    3) Shift left (k steps)/second array");
        System.out.println("    4) Shift right");
        System.out.println("    5) Shift right (k steps)/in place");
        System.out.println("    6) Shift right (k steps)/second array");
        System.out.println("    0) EXIT");
        switch (getIntMenu(input, "Please enter your option: ")) { // gets option from user, with validation
            case 0: { // break loop
                System.out.println("Testing completed.");
                break;
            }
            case 1: { // passes an random array to shiftLeft()
                int size;
                do size = getInt(input, "How many elements in the list: ");
                while (size < 1);
                int[] array = initRand(size);
                shiftLeft(array);
                menu(input);
                break;
            }
            case 2: { // passes a random array to shiftLeft() -- this one is overloaded to specify k
                int size;
                do size = getInt(input, "How many elements in the list: ");
                while (size < 1);
                int[] array = initRand(size);
                int k = getInt(input, "Input k (step for shift left): ");
                shiftLeft(array, k);
                menu(input);
                break;
            }
            case 3: { // passes a random array to shiftLeftK()
                int size;
                do size = getInt(input, "How many elements in the list: ");
                while (size < 1);
                int[] array = initRand(size);
                int k = getInt(input, "Input k (step for shift left): ");
                shiftLeftK(array, k);
                menu(input);
                break;
            }
            case 4: { // passes a random array to shiftRight()
                int size;
                do size = getInt(input, "How many elements in the list: ");
                while (size < 1);
                int[] array = initRand(size);
                shiftRight(array);
                menu(input);
                break;
            }
            case 5: { // passes a random array to shiftRight() -- overloaded to specify k
                int size;
                do size = getInt(input, "How many elements in the list: ");
                while (size < 1);
                int[] array = initRand(size);
                int k = getInt(input, "Input k (step for shift right): ");
                shiftRight(array, k);
                menu(input);
                break;
            }
            case 6: { // passes a random array to shiftRightK()
                int size;
                do size = getInt(input, "How many elements in the list: ");
                while (size < 1);
                int[] array = initRand(size);
                int k = getInt(input, "Input k (step for shift right): ");
                shiftRightK(array, k);
                menu(input);
                break;
            }
            default: { // user inputted invalid response, re-try input
                System.out.println("INVALID RESPONSE! REENTER: ");
                menu(input);
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

    // initRand() -- fills an array with randomly generated values
    public static int[] initRand(int num) {
        int[] array = new int[num];
        for(int i=0; i<array.length; i++) { // loop through an array and assign a random number to each index
            array[i] = (int )(Math.random() * 100 + 1);
        }
        return array;
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