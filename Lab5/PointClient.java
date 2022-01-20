import java.util.Scanner;
public class PointClient {
    public static void main(String[] args) {
        // init the points
        Point point1 = new Point();
        Point point2 = new Point(7, 13);
        Point point3 = new Point(7, 15);

        Scanner input = new Scanner(System.in);

        // print out the points using .toString()
        System.out.println("---After declaration, constructors invoked--- Using toString():");
        System.out.println("First point is: " + point1.toString());
        System.out.println("Second point is: " + point2.toString());
        System.out.println("Third point is: " + point3.toString());

        // test for alignment
        // test if pt2 lines up vertically with pt3
        if (point2.isVertical(point3)) System.out.println("Second point " + point2.toString() + " lines up vertically with third point " + point3.toString());
        else System.out.println("Second point " + point2.toString() + " doesn't line up vertically with third point " + point3.toString());
        // test if pt2 lines up horizontally with p3
        if (point2.isHorizontal(point3)) System.out.println("Second point " + point2.toString() + " lines up horizontally with third point " + point3.toString());
        else System.out.println("Second point " + point2.toString() + " doesn't line up horizontally with third point " + point3.toString());

        // manually enter point1, both x and y, using integer validation and making sure that both locations are greater than 0
        int x = getInt(input,"Enter the x-coordinate for first point: ");
        while (x < 0) {
            x = getInt(input,"ERROR! Should be positive. Enter the x-coordinate for first point: ");
        }
        int y = getInt(input,"Enter the y-coordinate for first point: ");
        while (y < 0) {
            y = getInt(input,"ERROR! Should be positive. Enter the y-coordinate for first point: ");
        }

        // set point1 to new info and print its loc
        point1.set(x, y);
        System.out.println("First point (after call to set) is " + point1.toString());

        // calculate distances for points 1 and 2
        System.out.printf("The distance from origin to point1 is %.2f\n", point1.distanceFromOrigin());
        System.out.printf("The distance from origin to point2 is %.2f\n", point2.distanceFromOrigin());
        System.out.printf("The distance from point1 to point2 is %.2f\n", point1.distance(point2));

        // translate the points
        point1.translate(5, 10);
        System.out.println("First point (after call to translate (5, 10)) is " + point1.toString());
        point2.translate(15, 5);
        System.out.println("Second point (after call to translate (15, 5)) is " + point2.toString());

        // test for equality
        if (point1.equals(point2)) System.out.println("---Call to equals: The 2 points ARE equal");
        else System.out.println("---Call to equals: The 2 points are NOT equal");

        // call copy methods
        // call copy
        System.out.println("---Calls to copy and print--- ");
        point1.copy(point1);
        point2.copy(point1);
        System.out.println("First point (after call to copy) is " + point1.toString());
        System.out.println("Second point (after call to copy) is " + point2.toString());

        // test for equality after copying
        if (point1.equals(point2)) System.out.println("---Call to equals after call to copy: The 2 points ARE equal");
        else System.out.println("---Call to equals after call to copy: The 2 points are NOT equal");

        /*
        // check code for cases that weren't in the sample output

        // get methods
        System.out.println("x of point 1 = " + point1.getX());
        System.out.println("y of point 1 = " + point1.getY());

        // print method
        point1.print();

        // get copy method
        Point point4 = point3.getCopy();
        // print point 4
        point4.print();

        // slope method -- slope between 1 and 2
        System.out.println("The slope between points 1 and 3 is " + point1.slope(point4));
         */
    }

    // integer validation method
    public static int getInt(Scanner input, String prompt){
        System.out.print(prompt);
        while (!input.hasNextInt()) {
            input.next();
            System.out.print("Not an integer, try again: ");
        }
        return input.nextInt();
    }
}
