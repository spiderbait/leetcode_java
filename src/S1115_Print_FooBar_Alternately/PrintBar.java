package S1115_Print_FooBar_Alternately;

public class PrintBar implements Runnable{
    @Override
    public void run() {
        System.out.print("Bar");
    }
}
