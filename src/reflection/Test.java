package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Test {
    private String fruitName;
    private Class<?> cls;
    private Constructor c;
    private Object o;

    Test(String fruitName) {
        try {
            this.fruitName = fruitName;
            this.cls = Class.forName("reflection." + fruitName);
            this.c = this.cls.getDeclaredConstructor();
            this.o = this.c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    public void printTest() {
//        System.out.println("This is a test function.");
//    }
    public void printNumbers() {
        try {
            Method m = this.cls.getMethod("printNum");
            m.invoke(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setNumbers(int n) {
        try {
            Method m = cls.getMethod("setNum", int.class);
            m.invoke(o, 123);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getNumbers() {
        int n = -1;
        try {
            Method m = cls.getMethod("getNum");
            n = (int)m.invoke(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }


    public static void main(String[] args) {
        Test t = new Test("Apple");
        t.printNumbers();
        t.setNumbers(123);
        int n = t.getNumbers();
        System.out.println(n);
//        try {
//            Class<?> t = Class.forName("reflection.Test");
//            Method m = t.getMethod("printTest");
//            Constructor c = t.getConstructor();
//            Object o = c.newInstance();
//            m.invoke(o);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
