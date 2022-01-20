/*
    Alexander Jenkins
    09/02/2020
 */
package dev.alexjenkins;
import java.util.Scanner;
public class Lab1_2 {
    public static void main(String[] args){
        // initialize starting variables, scanner
        Scanner input = new Scanner(System.in);
        String startPrompt = "Do you want to start (y/n): ";
        String quantityPrompt = "How many chars/last row? ";
        String charPrompt = "What character? ";
        char response = '0';
        char character = '0';
        int numChars = 0;

        // ask if want to start
        response = getChar(input, startPrompt);
        while(Character.toLowerCase(response) != 'y'){
            if (Character.toLowerCase(response) != 'n') {
                System.out.print("ERROR: Bad response. ");
            }
            response = getChar(input, startPrompt);
        }

        // get num of chars / last row, range: 5 - 21
        numChars = getInt(input, quantityPrompt);
        while (numChars < 5 || numChars > 21){
            System.out.print("ERROR! Valid range 5 - 21. ");
            numChars = getInt(input, quantityPrompt);
        }

        // get the char to print
        character = getChar(input, charPrompt);

        // print the box
        printBox(numChars, character);
    }
D
    public static int getInt(Scanner input, String prompt){
        System.out.print(prompt);
        while (!input.hasNextInt()) {
            input.next();
            System.out.print("Not an integer, try again: ");
        }
        return input.nextInt();
    }

    public static char getChar(Scanner input, String charPrompt){
        System.out.print(charPrompt);
        return input.next().charAt(0);
    }

    public static void printBox(int quantity, char character){
        for (int i = 0; i < quantity; i++){
            for (int q = 0; q < quantity; q++){
                if (i == 0 || i == quantity - 1){
                    System.out.print(character);
                }
                else {
                    if (q == 0 || q == quantity - 1) System.out.print(character);
                    else System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }

}