package ConCurrent;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.CountDownLatch;

public class ReadThread extends Thread{

    private final int BUFF_LEN = 256;
    private long start;
    private long end;
    private RandomAccessFile raf;
    private String keywords;
    private int curCount = 0;
    private CountDownLatch doneSignal;

    public ReadThread(long start, long end, RandomAccessFile raf, String keywords, CountDownLatch doneSignal) {
        this.start = start;
        this.end = end;
        this.raf = raf;
        this.keywords = keywords;
        this.doneSignal = doneSignal;
    }

    public void run() {
        try {
            raf.seek(start);
            long contentLen = end - start;
            long times = contentLen / (BUFF_LEN+1);
            System.out.println(this.toString() + "Numbers to read: " + times);
            byte[] buff = new byte[BUFF_LEN];
            int hasRead = 0;
            String result = null;
            for (int i = 0; i < times; i ++) {
                hasRead = raf.read(buff);
                if (hasRead < 0) {
                    break;
                }
                result = new String(buff, "gb2312");
                int count = this.getCountByKeywords(result, keywords);
                if (count > 0) {
                    this.curCount += count;
                }
            }
            KeywordsCount kc = KeywordsCount.getCountObject();
            kc.addCount(this.curCount);
            doneSignal.countDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public RandomAccessFile getRaf() {
        return raf;
    }

    public void setRaf(RandomAccessFile raf) {
        this.raf = raf;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getCurCount() {
        return curCount;
    }

    public void setCurCount(int curCount) {
        this.curCount = curCount;
    }

    public int getCountByKeywords(String statement, String key) {
        return statement.split(key).length - 1;
    }

    public CountDownLatch getDoneSignal() {
        return doneSignal;
    }

    public void setDoneSignal(CountDownLatch doneSignal) {
        this.doneSignal = doneSignal;
    }
}
