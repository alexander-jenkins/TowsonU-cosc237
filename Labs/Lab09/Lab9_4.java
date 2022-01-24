//Testing the method removeDuplicates using the Java ArrayList class 
import java.util.ArrayList;
public class Lab9_4 {
    public static void main(String[] args)  {
        ArrayList <Integer> list = new ArrayList <Integer>(); 
        list.add(2);
        list.add(2); 
        list.add(2); 
        list.add(5); 
        list.add(5);
        list.add(8);
        list.add(9);
        list.add(9);
        System.out.println("The original list is: "); 
        print(list); 
        System.out.println("The list after method call is: ");
        removeDuplicates(list);
        print(list); 
    }
    
    public static void removeDuplicates(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int placeholder = list.get(i);
            int count = 0;
            // remove copies of each item
            for (int j = 0; j < list.size(); j++) {
                count++;
                if (list.get(j) == placeholder && count > 1) list.remove(j);
            }
        }
    }
    
    public static void print(ArrayList <Integer> someList) {
        for(Integer i:someList)
            System.out.print(i + "  ");
        System.out.println();
    }
}
/*OUTPUT:
The original list is: 
2  2  2  5  5  8  9  9  
The list after method call is: 
2  5  8  9  
*/