package test;

public class InterruptTest {
    public static void main(String[] args){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.print(Thread.currentThread() + " hello");
                }
            }
        });
        try {
        thread.start();
        Thread.sleep(50);
        System.out.print("Main thread interrupted thread!");
        thread.interrupt();
        thread.join();
        System.out.print("Thread joined!");
        Thread.currentThread().interrupt();
        System.out.print("Main is over!");

        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
    }
}
