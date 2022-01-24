/*
Alexander Jenkins
09/09/2020
 */
import java.util.*;
public class Lab2_1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String qElementPrompt = "How many elements/list: ";
        int[] numbers = initRand(getInt(input, qElementPrompt));
        System.out.println("The list is:");
        print(numbers);
        menu(input, numbers);
        input.close();
    }

    // getInt() method for integer input validation
    public static int getInt(Scanner input, String prompt){
        System.out.print(prompt);
        while (!input.hasNextInt()) {
            input.next();
            System.out.print("Not an integer! Try again: ");
        }
        return input.nextInt();
    }

    // initRand() method for filling arrays with random data
    public static int[] initRand(int length){
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++){
            numbers[i] = (int) ((Math.random()*99) + 1);
        }
        return numbers;
    }

    //  print() method to print the elements of an array
    public static void print(int[] numbers){
        for (int number : numbers) System.out.printf("%d ", number);
        System.out.print("\n");
    }

    // isAllEven() method
    public static boolean isAllEven(int[] numbers){
        for (int number : numbers) {
            if ((number % 2) != 0) return false;
        }
        return true;
    }

    // isUnique() method -- true if no 2 values in array are the same
    public static boolean isUnique(int[] numbers){
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = numbers.length-1; j > i; j--) {
                if (numbers[i] == numbers[j]) return false;
            }
        }
        return true;
    }

    // minGap() method -- adjacent value, second value - first value
    public static int minGap(int[] numbers){
        Integer minGap = null;
        Integer gap = null;
        for (int i = 0; i < numbers.length - 1; i++) {
            gap = (numbers[i]-numbers[i+1]);
            if (i == 0) minGap = gap;
            else if (gap < minGap) minGap = gap;
        }
        return minGap;
    }

    // menu() method
    public static void menu(Scanner input, int[] numbers){
        int option;
        String prompt = "Please enter your option: ";
        System.out.println("\nYour options are:");
        System.out.println("-------------------------------");
        System.out.println("1) All even values?");
        System.out.println("2) All unique values?");
        System.out.println("3) Print min gap between values");
        System.out.println("4) Statistics");
        System.out.println("5) Print 80th percentile");
        System.out.println("0) EXIT");
        option = getInt(input, prompt);
        switch (option){
            case 0: {
                System.out.println("Testing complete.");
                break;
            }
            case 1:{
                // call isEven()
                if (!isAllEven(numbers)) System.out.println("Some values/list are odd.");
                else System.out.println("All values/list are even.");
                menu(input, numbers);
                break;
            }
            case 2:{
                // call isUnique()
                if(!isUnique(numbers)) System.out.println("Some values/list appear multiple times.");
                else System.out.println("All values are unique.");
                menu(input, numbers);
                break;
            }
            case 3:{
                // call minGap()
                System.out.printf("The minimum gap between 2 adjacent values is %d\n", minGap(numbers));
                menu(input, numbers);
                break;
            }
            case 4:{
                // display stats [mean, variance, std dev]
                print(numbers);
                double mean = getMean(numbers);
                System.out.printf("The mean is %.2f\n", mean);
                System.out.printf("The variance is %.2f\n", getVariance(numbers, mean));
                System.out.printf("The standard deviation is %.2f\n", Math.sqrt(getVariance(numbers, mean)));
                menu(input, numbers);
                break;
            }
            case 5:{
                // display 80th percentile
                top_20(numbers);
                menu(input, numbers);
                break;
            }
            default: menu(input, numbers);
        }
    }

    // bubbleSort() method
    public static void bubbleSort(int[] numbers){
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j+1]){
                    int placeholder = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = placeholder;
                }
            }
        }
    }

    // copy() method
    public static void copy(int[] numbers, int[] numbersCopy){
        for (int i = 0; i < numbers.length; i++) numbersCopy[i] = numbers[i];
    }

    // top_20() method -- prints the values in the 80th percentile
    public static void top_20(int[] numbers){
        double top20 = numbers.length * 0.20;
        int[] numbersCopy = new int[numbers.length];
        copy(numbers, numbersCopy);
        bubbleSort(numbersCopy);
        System.out.println("The list sorted:");
        print(numbersCopy);
        System.out.println("80th-percentile from this list:");
        for (int i = numbers.length-1; i >= numbers.length - (int)top20; i--) System.out.printf("%d ", numbersCopy[i]);
    }

    // getMean() method
    public static double getMean(int[] numbers){
        int sum = 0;
        for (int number : numbers) sum += number;
        return (double) sum / numbers.length;
    }

    // getVariance() method
    public static double getVariance(int[] numbers, double mean) {
        double[] deviations = new double[numbers.length];
        for (int i = 0; i < deviations.length; i++) deviations[i] = numbers[i] - mean;
        double variance = 0;
        for (double deviation : deviations) variance += ((deviation * deviation) / deviations.length);
        return variance;
    }
}
