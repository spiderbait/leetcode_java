package S1114_Print_in_Order;

import java.util.concurrent.Semaphore;

public class Solution {

    Semaphore A;
    Semaphore B;
    Semaphore C;

    Solution() {
        A = new Semaphore(1);
        B = new Semaphore(0);
        C = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        A.acquire();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        B.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        B.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        C.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        C.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args) throws InterruptedException{
        PrintFirst printFirst = new PrintFirst();
        PrintSecond printSecond = new PrintSecond();
        PrintThird printThird = new PrintThird();

        Solution s = new Solution();
        s.first(printFirst);
        s.second(printSecond);
        s.third(printThird);
    }
}
