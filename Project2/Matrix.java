import java.util.Random;
public class Matrix {
    public final int MAX = 20;
    private int size;
    private int[][] table;


    //default constructor
    public Matrix() {
        table = new int[MAX][MAX];
    }

    //alternate constructor
    public Matrix(int s) {
        size = s;
        table = new int[size][size];
    }

    //method that returns size
    public int getSize() {
        return size;
    }

    //method that returns element
    public int getElement(int r, int c) {
        return table[r][c];
    }

    //method that sets element
    public void setElement(int r, int c, int value) {
        table[r][c] = value;
    }

    //method that initializes a matrix
    public void init(int low, int up) {
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = r.nextInt(up - low + 1) + low;
            }
        }
    }

    //method to print
    public void print() {
        for (int r = 0; r < size; r++){
            for (int c = 0; c < size; c++)
                System.out.printf("%5d", table[r][c]);
            System.out.println();
        }

    }

    //method to add two matrices
    public Matrix add(Matrix a){
        Matrix sum = new Matrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sum.setElement(i, j, (table[i][j] + a.table[i][j]));
            }
        }
        return sum;
    }

    //method to subtract two matrices
    public Matrix subtract(Matrix a) {
        Matrix difference = new Matrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                difference.setElement(i, j, (table[i][j] - a.table[i][j]));
            }
        }
        return difference;
    }

    //method to multiply two matrices
    public Matrix multiply(Matrix a) {
        Matrix product = new Matrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    product.table[i][j] += table[i][k] * a.table[k][j];
                }
            }
        }
        return product;
    }

    //method to multiply a matrix by a constant
    public Matrix multiplyConst(int whatConst) {
        Matrix product = new Matrix(size);
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) product.setElement(i, j, table[i][j] * whatConst);
        }
        return product;
    }

    //method that transposes a matrix
    public Matrix transpose() {
        Matrix transposition = new Matrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++){
                if (i != j) transposition.setElement(j, i, table[i][j]);
                else transposition.setElement(i, j, table[i][j]);
            }
        }
        return transposition;
    }

    //method that finds the trace of a matrix
    public int trace() {
        int trace = 0;
        for (int i = 0; i < size; i++) trace += table[i][i];
        return trace;
    }

    //method to check for equality
    public boolean equals(Matrix a){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (table[i][j] == a.getElement(i, j)) continue;
                else return false;
            }
        }
        return true;
    }

    //method to make a copy
    public void copy(Matrix a) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = a.getElement(i, j);
            }
        }
    }

    //method to return a copy
    public Matrix getCopy() {
        Matrix copy = new Matrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                copy.setElement(i, j, table[i][j]);
            }
        }
        return copy;
    }
}