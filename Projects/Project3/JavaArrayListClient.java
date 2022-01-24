import java.io.*;
import java.util.*;

public class JavaArrayListClient {
    public static void main(String[] args) {
        // init the vars for lists, scanners, etc
        Scanner input = new Scanner(System.in);
        String fname;
        int key;
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        // fill list one, handle FNF error
        System.out.print("Please input the name of the file to be opened for first list: ");
        fname = input.nextLine();
        try {
            readFile(fname, list1);
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
        }

        // fill list two, handle FNF error
        System.out.print("Please input the name of the file to be opened for second list: ");
        fname = input.nextLine();
        try {
            readFile(fname, list2);
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
        }

        // print out the lists
        System.out.println("The fist list is:");
        System.out.println(list1);
        System.out.println("The second list is:");
        System.out.println(list2);

        // merge the lists and print the result
        result = merge(list1, list2);
        System.out.println("The merged list is:");
        System.out.println(result);

        // sort the list using the bubble sort method
        System.out.println("The merged list sorted is:");
        bubbleSort(result);
        System.out.println(result);

        // split the list
        key = getInt(input, "Enter key for split: ");
        split(result, list1, list2, key);

        // print the new lists
        System.out.println("The fist list after split is:");
        System.out.println(list1);
        System.out.println("The second list after split is:");
        System.out.println(list2);
    }

    private static void readFile(String fname, ArrayList<Integer> list) throws FileNotFoundException {
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
            list.add(inputs.nextInt());
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

    // merge two ArrayList<Integer> into one -- value returning
    private static ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        // set up the placeholders
        ArrayList<Integer> result = new ArrayList<Integer>();

        // add list one to the result
        for (int i = 0; i < list1.size(); i++) result.add(list1.get(i));

        // add list two to the result
        for (int i = 0; i < list2.size(); i++) result.add(list2.get(i));

        // return the merged list
        return result;
    }

    // split an array list into two -- void method
    private static void split(ArrayList<Integer> main, ArrayList<Integer> list1, ArrayList<Integer> list2, int key) {
        // clear lists one and two
        list1.clear();
        list2.clear();

        // init the placeholders
        int num;
        for(int i = 0; i < main.size(); i++) {
            num = main.get(i);
            if (num <= key) list1.add(num);
            else list2.add(num);
        }
    }

    // bubble sort method -- void method
    private static void bubbleSort(ArrayList<Integer> list) {
        // init placeholders
        Integer temp;
        // outer loop for the sort
        for (int i = 0; i < list.size() - 1; i++) {
            // inner loop for the sort
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j+1)) > 0) {
                    // swap the next value with the current one
                    temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
    }
}
