public class Client_DLLInteger {
    public static void main(String[] args) {
        DoubleLinkedList<Integer>list_1 = new DoubleLinkedList<Integer>();
        DoubleLinkedList<Integer>list_2 = new DoubleLinkedList<Integer>();
        int item;
        list_1.insertNode(12);
        list_1.insertNode(56);
        list_1.insertNode(34);
        list_1.insertNode(77);
        list_1.insertNode(88);
        list_1.insertNode(66);
        list_1.insertNode(99);
        list_1.insertNode(3);
        list_1.insertNode(13);
        list_1.insertNode(19);
        list_1.insertNode(23);
        list_1.insertNode(61);
        list_1.insertNode(44);
        System.out.println("Inserted in first list the integers: 12, 56, 34, 77, 88, 66, 99, 3, 13, 19, 23, 61, 44");
        System.out.println("(Testing toString) First list sorted is: " + list_1);
        System.out.println("(Testing recursive toString) First list sorted is: [head] -" + list_1.recursiveToString());
        System.out.println("(Testing backwards) First list reversed (print) is: " + list_1.backwardsString());
        System.out.print("(Testing recursive backwards) First list reversed (print) is: " + list_1.recursiveBackwardsString());
        System.out.println(" -[head]");
        System.out.println("Will copy in second list only integers that are over 50. List one destroyed.");
        while (!list_1.isEmptyList()) {
            item = list_1.front();
            list_1.deleteNode(item);
            if(item > 50)list_2.insertNode(item);
        }
        System.out.println("Second list should hold integers that are over 50 (sorted): " + list_2);
        System.out.println("First list should be empty. Nothing printed. ");
        list_1.print();
        System.out.print("(Testing equals) ");
        if(list_1.equals(list_2))System.out.println("The 2 lists are equals");
        else
            System.out.println("The 2 lists are NOT equals");
        System.out.print("(Testing copy) ");
        list_1.copy(list_2);
        System.out.println("First list after copy is: " + list_1);
        System.out.print("(Testing reversed copy) ");
        list_1.reversedCopy(list_2);
        System.out.println("First list as the copy of the second list reversed is: " + list_1);
        if(list_1.search(76))System.out.println("Found");
        else
            System.out.println("Not found");
        list_1.reversePrint();
    }
}