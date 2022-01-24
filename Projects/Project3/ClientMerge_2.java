import java.io.File;
import java.util.*;
public class ClientMerge_2 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        UnorderedLinkedListInt list1 = new UnorderedLinkedListInt();
        UnorderedLinkedListInt list2 = new UnorderedLinkedListInt();
        UnorderedLinkedListInt list3;
        int num;
        System.out.println("Enter integers for the first list(999 to stop)");
        getInts(list1);
        System.out.println("Enter integers for the second list(999 to stop)");
        getInts(list2);
        System.out.print("\nThe first list is: ");
        list1.print();
        System.out.println("\nThe length of the first list is: " + list1.length());
        if (!list1.isEmptyList()) {
            System.out.println("First element/list1: " + list1.front());
            System.out.println("Last element/list1: " + list1.back());
        }
        System.out.print("\nThe second list is: ");
        list2.print();
        System.out.println("\nThe length of the second list is: " + list2.length());
        if (!list2.isEmptyList()) {
            System.out.println("First element/list2: " + list2.front());
            System.out.println("Last element/list2: " + list2.back());
        }
        list3 = list1.merge2(list2);
        System.out.print("\nAfter concatenating the 2 lists, the merged list1 is: ");
        list3.print();
        System.out.println("\nThe length of the merged list is: " + list3.length());
        if (!list3.isEmptyList()) {
            System.out.println("First element/merged list: " + list3.front());
            System.out.println("Last element/merged list: " + list3.back());
        }
        System.out.print("Enter key for split: ");
        num = input.nextInt(); //call your own getInt() method
        list3.split(list1, list2, num);
        System.out.print("\nThe first list after split is: ");
        list1.print();
        System.out.print("\nThe second list after split is: ");
        list2.print();
        System.out.println();
    }

    // get ints for the list -- eat any input other than an integer, continues until num = 999
    private static void getInts(UnorderedLinkedListInt list) {
        Scanner input = new Scanner(System.in);
        int num;
        while (input.hasNext()) {
            if (input.hasNextInt()) {
                num = input.nextInt();
                if (num != 999) list.insertLast(num);
                else break;
            }
            else input.next();
        }
    }
}