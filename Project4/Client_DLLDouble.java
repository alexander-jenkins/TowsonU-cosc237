public class Client_DLLDouble {
    public static void main(String[] args) {
        int hour;
        int minute;
        int second;
        DoubleLinkedList<Double>list_1 = new DoubleLinkedList<Double>();
        DoubleLinkedList<Double>list_2 = new DoubleLinkedList<Double>();
        double item;
        list_1.insertNode(12.1);
        list_1.insertNode(33.5);
        list_1.insertNode(53.4);
        list_1.insertNode(11.3);
        list_1.insertNode(67.2);
        list_1.insertNode(69.7);
        list_1.insertNode(19.9);
        list_1.insertNode(77.7);
        list_1.insertNode(88.8);
        list_1.insertNode(45.6);
        list_1.insertNode(30.1);
        list_1.insertNode(92.7);
        list_1.insertNode(99.9);
        System.out.println("Inserted in first list the doubles: 12.1, 33.5, 53.4, 11.3, 67.2, 69.7, 19.9, 77.7, 88.8, 45.6, 30.1, 92.7, 99.9");
        System.out.println("(Testing toString) First list sorted is: " + list_1);
        System.out.println("(Testing recursive toString) First list sorted is: [head] -" + list_1.recursiveToString());
        System.out.println("(Testing backwards) First list reversed (print) is: " + list_1.backwardsString());
        System.out.print("(Testing recursive backwards) First list reversed (print) is: " + list_1.recursiveBackwardsString());
        System.out.println(" -[head]");
        System.out.println("Will copy in second list only doubles that are greater than 30.1. List one destroyed.");
        while (!list_1.isEmptyList()) {
            item = list_1.front();
            list_1.deleteNode(item);
            if(item > 30.1)list_2.insertNode(item);
        }
        System.out.println("Second list should hold doubles that are greater than 30.1 (sorted): " + list_2);
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
        if(list_1.search(92.7))System.out.println("Found");
        else
            System.out.println("Not found");
        list_1.reversePrint();
    }
}