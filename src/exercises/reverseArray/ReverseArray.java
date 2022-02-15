package exercises.reverseArray;

import java.util.Arrays;

public class ReverseArray {

    private static void reverse(int[] array) {
        System.out.println("Array = " + Arrays.toString(array));
        int firstIndex = 0;
        int lastIndex = array.length - 1;
        while (firstIndex != lastIndex) {
            int temporary = array[firstIndex];
            array[firstIndex] = array[lastIndex];
            array[lastIndex] = temporary;
            firstIndex++;
            lastIndex--;
        }
        System.out.println("Reversed array = " + Arrays.toString(array));
    }
}
