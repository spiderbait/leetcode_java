package S27_Remove_Element;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] integerArray = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(Arrays.copyOf(integerArray, integerArray.length - 1)));

    }
}
