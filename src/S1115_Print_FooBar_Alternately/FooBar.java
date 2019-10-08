package S1115_Print_FooBar_Alternately;

import java.util.concurrent.Semaphore;

class FooBar {
    private int n;
    Semaphore A;
    Semaphore B;

    public FooBar(int n) {
        this.n = n;
        A = new Semaphore(1);
        B = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
//            A.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
//            B.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

//            B.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
//            A.release();
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
