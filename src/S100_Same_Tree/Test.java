package S100_Same_Tree;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(null);
        list.add(3);

        for (int i: list) {
            System.out.println(i);
        }
    }
}
