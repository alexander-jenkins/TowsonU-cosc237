//Class: ClientUnorderedLinkedListInt
//Input: 37 10 88 59 27 20 14 32 89 100 12 999
import java.util.*;
public class ClientUnorderedLinkedListInt {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        UnorderedLinkedListInt intList = new UnorderedLinkedListInt();
        UnorderedLinkedListInt tempList;
        int num;
        System.out.println("Enter integers (999 to stop)");
        num = input.nextInt();
        while (num != 999) {
            intList.insertLast((Integer) num);
            num = input.nextInt();
        }
        System.out.print("\nTesting .insertLast and .print. The original list is: ");
        intList.print();
        System.out.println("\nTesting .length. The length of the list is: " + intList.length());
        if (!intList.isEmptyList()) {
            System.out.println("Testing .front. First element/list: " + intList.front());
            System.out.println("Testing .back. Last element/list: "  + intList.back());
        }
        System.out.println("Testing .sum. The sum of data in all nodes is: " + intList.findSum());
        System.out.println("Testing .min. The smallest data in all nodes is: " + intList.findMin());
        System.out.print("Testing .search. Enter the number to search for/list: ");
        num = input.nextInt();
        if (intList.search(num))
            System.out.println(num + " found in this list.");
        else
            System.out.println(num + " is not in this list.");
        System.out.print("Testing .remove. Enter the number to be deleted from list: ");
        num = input.nextInt();
        intList.deleteNode(num);
        System.out.print("Testing .toString. After deleting " + num + ", the list is: " + intList);
        //intList.print();
        System.out.println("\nThe length of the list after delete is: " + intList.length());    
    }
}
/*OUTPUT:
Enter integers (999 to stop)
37 10 88 59 27 20 14 32 89 100 12 999
Testing .insertLast and .print. The original list is: 37 10 88 59 27 20 14 32 89 100 12 
Testing .length. The length of the list is: 11
Testing .front. First element/list: 37
Testing .back. Last element/list: 12
Testing .sum. The sum of data in all nodes is: 488
Testing .min. The smallest data in all nodes is: 10
Testing .search. Enter the number to search for/list: 20
20 found in this list.
Testing .remove. Enter the number to be deleted from list: 59
Testing .toString. After deleting 59, the list is: [37, 10, 88, 27, 20, 14, 32, 89, 100, 12]
The length of the list after delete is: 10
*/