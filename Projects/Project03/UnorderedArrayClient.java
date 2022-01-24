import java.util.*;
import java.io.*;
public class UnorderedArrayClient {
    public static void main(String[] args){
        // init the vars for lists, scanners, etc
        Scanner input = new Scanner(System.in);
        String fname;
        int key;
        UnorderedArrayList list_1 = new UnorderedArrayList();
        UnorderedArrayList list_2 = new UnorderedArrayList();
        UnorderedArrayList result;

        // fill list one, handle FNF error
        System.out.print("Please input the name of the file to be opened for first list: ");
        fname = input.nextLine();
        try {
            readFile(fname, list_1);
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
        }

        // fill list two, handle FNF error
        System.out.print("Please input the name of the file to be opened for second list: ");
        fname = input.nextLine();
        try {
            readFile(fname, list_2);
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
        }

        // print out the lists
        System.out.println("The fist list is:");
        list_1.print();
        System.out.println("The second list is:");
        list_2.print();

        // merge the lists and print the result
        result = list_1.merge(list_2);
        System.out.println("The merged list is:");
        result.print();

        // split the list
        key = getInt(input, "Enter key for split: ");
        result.split(list_1, list_2, key);

        // print the new lists
        System.out.println("The fist list after split is:");
        list_1.print();
        System.out.println("The second list after split is:");
        list_2.print();
    }

    private static void readFile(String fname, UnorderedArrayList list) throws FileNotFoundException {
        File read = new File(fname);
        Scanner s = new Scanner(read);
        Scanner inputs = new Scanner(read);
        int count = 0;
        do {
            if (s.hasNextInt()) count++;
            s.next();
        } while (s.hasNext());
        for (int i = 0; i < count; i++){
            if (!inputs.hasNextInt()) {
                do inputs.next();
                while (!inputs.hasNextInt());
            }
            list.insertEnd(inputs.nextInt());
        }
        s.close();
        inputs.close();
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
