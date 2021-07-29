package S47_Permutations_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScanExecutor {

    public static void main(String[] args) {

        int[] register = {0, 0, 0};
        boolean isBreak = false;

        List<Integer> n1 = new ArrayList<>();
        n1.add(1);
        n1.add(2);
        n1.add(3);



        List<Integer> n2 = new ArrayList<>();
        n2.add(2);
        n2.add(2);
        n2.add(3);

//        System.out.println(String.valueOf(n1.equals(n2)));
//        System.out.println(String.valueOf(n1 == n2));


        List<List<Integer>> list = new ArrayList<>();

        list.add(n1);
        System.out.println(list.contains(n1));
        n1.clear();
        n1.add(2);
        n1.add(2);
        n1.add(3);
        System.out.println(list.contains(n1));
        System.out.println(list.contains(n2));

    }

}
