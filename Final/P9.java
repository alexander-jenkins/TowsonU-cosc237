public class P9 {
    public static void main(String[] args) {
        //recInt(7);
        int x = f(12, 14);
        System.out.print(x);

    }
    public static void recInt(int x) {
        if (x > 1) {
            recInt(x - 1);
            System.out.print(", " + x);
        }
        else if (x == 1) System.out.print(x);
    }

    public static int f(int i, int j){
        if (i < 11) {
            if (j < 11) return i + j;
            else return j + f(i, j - 2);
        }
        else return i + f(i - 1, j);
    }
}
