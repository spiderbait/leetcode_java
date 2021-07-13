package MultiThread;

class MyThread extends Thread {
    public void run() {
        for (int i=0; i < 10; i++) {
            System.out.println(i + " sub");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadOne extends Thread {
    public void run() {
        for (int i=0; i < 10; i++) {
            System.out.println(i + " thread one");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadTwo extends Thread {
    public void run() {
        for (int i=0; i < 10; i++) {
            System.out.println(i + " thread two");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class MultiThread {
    public static void main(String[] args) {
        ThreadOne tOne = new ThreadOne();
        ThreadTwo tTwo = new ThreadTwo();
        tOne.start();
        tTwo.start();
    }
}
