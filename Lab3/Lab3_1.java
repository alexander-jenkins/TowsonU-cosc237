/*
Alexander Jenkins
09/16/2020
 */
import java.util.Scanner;
public class Lab3_1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String startPrompt = "Start (y/n): ";
        String continuePrompt = "Continue (y/n): ";
        String sizePrompt = "How many elements/array: ";
        while (!shouldContinue(input, startPrompt)){
            shouldContinue(input, startPrompt);
        }
        do {
            // get size of the array from the user
            int size = getInt(input, sizePrompt);
            // create both arrays
            int[] numbers = initRand(size);
            int[] twice = twice(numbers, size);
            System.out.print("The original array is:");
            print(numbers);
            System.out.print("The second array is:");
            print(twice);
        } while (shouldContinue(input, continuePrompt));
    }

    // shouldContinue method -- determines whether or not to start/loop program
    public static boolean shouldContinue(Scanner input, String prompt){
        System.out.print(prompt);
        char response = input.next().toLowerCase().charAt(0);
        while(response != 'y'){
            if (response != 'n') System.out.println("ERROR: Bad response. ");
            else System.exit(0);
            System.out.print(prompt);
            response = input.next().toLowerCase().charAt(0);
        }
        return true;
    }

    // getInt() method -- reuse of code
    public static int getInt(Scanner input, String prompt){
        System.out.print(prompt);
        while (!input.hasNextInt()) {
            input.next();
            System.out.print("Not an integer! Try again: ");
        }
        return input.nextInt();
    }

    // initRand() method -- reuse of code / fills the array with random values
    public static int[] initRand(int length){
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++){
            numbers[i] = (int) ((Math.random()*99) + 1);
        }
        return numbers;
    }

    // print() method -- reuse of code / prints out the array as a string, without the brackets and commas
    public static void print(int[] numbers){
        for (int number : numbers) System.out.printf("%d ", number);
        System.out.print("\n");
    }

    // twice() method that returns a second array holding 2 copies of each original value
    public static int[] twice(int[] numbers, int size){
        int[] twice = new int[size*2];
        int counter = 0;
        for (int number : numbers){
            twice[counter] = number;
            counter++;
            twice[counter] = number;
            counter++;
        }
        return twice;
    }
}