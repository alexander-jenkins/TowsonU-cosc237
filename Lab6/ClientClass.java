public class ClientClass {
    public static void main(String[] args) {
        // instantiate the objects
        Class_1 first = new Class_1();
        Class_1 second = new Class_1(6, 3);
        Class_2 third = new Class_2();
        Class_2 fourth = new Class_2(4, 8, 9);

        // print out the objects
        first.print();
        System.out.println();
        second.print();
        System.out.println();
        third.print();
        System.out.println();
        fourth.print();
        System.out.println();
        // print another way
        System.out.println("First is " + first.toString());
        System.out.println("Second is " + second.toString());
        System.out.println("Third is " + third.toString());
        System.out.println("Fourth is " + fourth.toString());

        // change the values of the objects
        first.set(1, 4);
        second.set(2, 5);
        third.set(3, 6, 7);
        fourth.set(4, 7, 8);

        // print the objects again
        first.print();
        System.out.println();
        second.print();
        System.out.println();
        third.print();
        System.out.println();
        fourth.print();
    }

}
