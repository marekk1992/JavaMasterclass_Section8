package exercises.minimumElement;

import java.util.Scanner;

public class MinimumElement {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] array = readElements(readInteger());
        System.out.println("Minimum value is " + findMin(array));
    }

    private static int[] readElements(int count) {
        int[] array = new int[count];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter a number:");
            array[i] = scanner.nextInt();
            scanner.nextLine();
        }

        return array;
    }

    private static int findMin(int[] array) {
        int minimumValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minimumValue) {
                minimumValue = array[i];
            }
        }
        return minimumValue;
    }

    private static int readInteger() {
        System.out.println("Enter size of an array:");
        int count = scanner.nextInt();
        scanner.nextLine();

        return count;
    }
}
