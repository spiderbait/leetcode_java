package test;

public class Test {
    public static void main(String[] args) {
//        String n = "1000000000000000000000000000001";
//        System.out.println(Long.parseLong(n));
//        System.out.println(String.valueOf(Double.parseDouble(n)));
//        int n = 1;
//        boolean flag = false;
//        switch (n) {
//            case 1: n > 1 ? System.out.println("bigger") : System.out.println("smaller");
//
//        }
        int[][] a = new int[][]{{0, 0, 0, 0}, {0, 1, 0, 0}, {1, 0, 1, 0}, {0, 0, 0, 0}};
        
        loop:
        for (int i=0; i < 4; i ++) {
            for (int j=0; j < 4; j ++) {
                if (a[i][j] == 1) {
                    break loop;
                }
            }
            System.out.println("changeLine");
        }

    }
}
