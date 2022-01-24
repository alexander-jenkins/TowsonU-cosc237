import java.util.Scanner;

public class StackQueueClient {
    public static void main(String[] args) {
        /*
            Alexander Jenkins
            Lab 11
         */

        // init required vars
        int toDelete;

        // init the stack
        LinkedStackClass<Integer> numbers = new LinkedStackClass<Integer>();
        getInts(numbers);

        // print in order
        System.out.println("The original stack printed in direct order (bottom to top) is:");
        numbers.printStack();

        // print front and back
        System.out.println("The stack printed in reverse order (top to bottom) is:");
        numbers.printBackStack();

        // print how many items the stack has
        System.out.printf("The stack stores %d items.%n", numbers.countItems());

        // print stack's top item
        System.out.printf("The stack's first item is %d.%n", numbers.peek());

        // print the stack's second item
        System.out.printf("The stack's second item is %d.%n", numbers.getSecond());

        // todo remove all instances of a number and print
        toDelete = getInt("Enter value to be removed from stack: ");
        numbers.removeItem(toDelete);
        System.out.printf("The stack after removing every occurrence of %d is:%n", toDelete);

        // todo reverse the stack and print
        System.out.println("Reversed the stack. The new stack printed in direct order is:");

        // todo create and print a queue
        System.out.println("The queue is:");

        // todo reverse the queue
        System.out.println("The reversed queue is:");

    }

    private static void getInts(LinkedStackClass<Integer> stack) {
        Scanner input = new Scanner(System.in);
        int num;
        while (input.hasNext()) {
            if (input.hasNextInt()) {
                num = input.nextInt();
                if (num != 999) stack.push(num);
                else break;
            }
            else input.next();
        }
    }

    private static int getInt(String prompt) {
        Scanner input = new Scanner(System.in);
        System.out.print(prompt);
        while (!input.hasNextInt()) {
            input.next();
            System.out.print("Not an integer! Try again: ");
        }
        return input.nextInt();
    }

}
