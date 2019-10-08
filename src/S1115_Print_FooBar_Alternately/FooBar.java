package S1115_Print_FooBar_Alternately;

import java.util.concurrent.Semaphore;

class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        PrintFoo printFoo = new PrintFoo();
        PrintBar printBar = new PrintBar();

        FooBar fooBar = new FooBar(2);

        fooBar.foo(printFoo);
        fooBar.bar(printBar);
    }
}
