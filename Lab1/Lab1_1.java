/*
    Alexander Jenkins
    09/02/2020
 */
package dev.alexjenkins;
import java.util.Scanner;
public class Lab1_1 {
    public static void main(String[] args) {
        // Create scanner and initialize num and prompt
        Scanner input = new Scanner(System.in);
        int num = 0;
        String prompt = "Enter a 2-digit number (with different digits), or enter 0 to stop: ";

        // Grab input for num from user and make sure it is valid
        num = getInt(input, prompt);
        while (num != 0) {
            while ((num < 10 || num > 99) || (num % 11 == 0)) {
                System.out.println("Number is not good for the game.");
                num = getInt(input, prompt);
            }
            System.out.println("Number is good for the game! Play!");
            num = getInt(input, prompt);
        }
    }

    // reusable method for getting an integer input
    public static int getInt(Scanner input, String prompt){
        System.out.print(prompt);
        while (!input.hasNextInt()) {
            input.next();
            System.out.print("Not an integer! Try again: ");
        }
        return input.nextInt();
    }

}