package ConCurrent;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.CountDownLatch;

public class MultiReadTest {
    public static void main(String[] args) {
        final int DOWN_THREAD_NUM = 10;
        final String OUT_FILE_NAME = "/Users/tianzhuoli/Desktop/dev/AI_try_catch.py";
        final String keywords = "aa";

        CountDownLatch doneSignal = new CountDownLatch(DOWN_THREAD_NUM);
        RandomAccessFile[] outArr = new RandomAccessFile[DOWN_THREAD_NUM];

        try {
            long length = new File(OUT_FILE_NAME).length();
            System.out.println("File length in byte: " + length);
            long npt = length / DOWN_THREAD_NUM;
            System.out.println("NPT in byte: " + npt);
            long left = length % DOWN_THREAD_NUM;
            for (int i = 0; i < DOWN_THREAD_NUM; i ++) {
                outArr[i] = new RandomAccessFile(OUT_FILE_NAME, "rw");
                if (i != 0) {
                    System.out.println("i != 0");
                }
                if (i == DOWN_THREAD_NUM - 1) {
                    new ReadThread(i * npt, (i + 1) * npt + left, outArr[i], keywords, doneSignal).start();
                } else {
                    new ReadThread(i * npt, (i + 1) * npt + left, outArr[i], keywords, doneSignal).start();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
