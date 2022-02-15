package exercises.sortedArray;

import java.util.Scanner;

public class SortedArray {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int array[] = getIntegers(5);
        sortIntegers(array);
        printArray(array);
    }

    public static int[] getIntegers(int numberOfIntegers) {
        System.out.println("Enter " + numberOfIntegers + " integer values:\r");
        int values[] = new int[numberOfIntegers];
        for (int i = 0; i < numberOfIntegers; i++) {
            values[i] = scanner.nextInt();
        }

        return values;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + " value is " + array[i]);
        }
    }

    public static int[] sortIntegers(int[] array) {
        int[] sortedArray = array;
        for (int i = 0; i < sortedArray.length; i++) {
            int highestValue = sortedArray[i];
            int highestElementIndex = i;
            for (int j = i + 1; j < sortedArray.length; j++) {
                if (sortedArray[j] > highestValue) {
                    highestValue = sortedArray[j];
                    highestElementIndex = j;
                }
            }
            int temporary = sortedArray[i];
            sortedArray[highestElementIndex] = temporary;
            sortedArray[i] = highestValue;
        }

        return sortedArray;
    }
}
