/*
Alexander Jenkins
09/16/2020
 */
import java.util.*;
public class Lab3_2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String startPrompt = "Start (y/n): ";
        String continuePrompt = "Continue (y/n): ";
        String rowsPrompt = "How many rows: ";
        String columnsPrompt = "How many columns: ";
        while (!shouldContinue(input, startPrompt)){
            shouldContinue(input, startPrompt);
        }
        do {
            // get size of the array from the user
            int rows = getInt(input, rowsPrompt);
            int columns = getInt(input, columnsPrompt);
            // create 2d array
            int[][] bits = initRand(rows, columns);
            print(bits);
            isFlipped(bits);
        } while (shouldContinue(input, continuePrompt));
    }

    // shouldContinue method -- determines whether or not to start/loop program -- reuse of code
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

    // initRand() method to fill a 2d array with ones and zeros
    public static int[][] initRand(int rows, int columns){
        int[][] bits = new int[rows][columns];
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                bits[j][i] = (int) Math.round(Math.random());
            }
        }
        return bits;
    }

    // print() method to print a 2d array & include the row index number on every line
    public static void print(int[][] bits){
        for (int i = 0; i < bits.length; i++) {
            for (int j = 0; j < bits[i].length; j++) {
                if (j == 0) System.out.printf("[%d] ", i);
                System.out.printf("%d ", bits[i][j]);
            }
            System.out.print("\n");
        }
    }

    // todo create an isFlipped() method to check if an array has a row that is flipped
    public static void isFlipped(int[][] bits) {
        for (int i = 0; i < bits.length; i++) { // loop through each array
            for (int j = i; j < bits.length; j++) {
                int flag = 0;
                for (int k = 0; k < bits[i].length; k++){
                    if (bits[i][k] == bits[][])
                }
            }
        }
    }
}