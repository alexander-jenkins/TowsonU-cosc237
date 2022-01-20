public class Point {
    // coordinates
    private int x, y;

    // constructors
    // default
    public Point() {
        x = 0;
        y = 0;
    }
    // alternate
    public Point(int x1, int y1) {
        x = x1;
        y = y1;
    }

    // getters
    // get x
    public int getX() {
        return x;
    }
    // get y
    public int getY() {
        return y;
    }

    // set method
    public void set(int xS, int yS) {
        x = xS;
        y = yS;
    }

    // print
    public void print() {
        System.out.println("(" + x + ", " + y + ")");
    }

    // to string
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // equals method
    public boolean equals(Point p) {
        if(x != p.x) return false;
        else return y == p.y;
    }

    // copy methods
    // copy method
    public void copy(Point p) {
        x = p.x;
        y = p.y;
    }
    // get copy
    public Point getCopy(){
        return new Point(x, y);
    }

    // distance methods
    // distance from origin
    public double distanceFromOrigin() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
    // distance from point
    public double distance(Point p) {
        return Math.sqrt(Math.pow((p.x - x), 2) + Math.pow((p.y - y), 2));
    }

    // translate the point on the grid
    public void translate(int xT, int yT) {
        x += xT;
        y += yT;
    }

    // test if lined up horizontally or vertically
    // horizontal test
    public boolean isHorizontal(Point p) {
        return y == p.y;
    }
    // vertical test
    public boolean isVertical(Point p) {
        return x == p.x;
    }

    // get the slope between two points
    public double slope(Point p) {
        return ((double)(p.y - y))/(p.x - x);
    }
}
