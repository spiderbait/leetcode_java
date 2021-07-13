package ConCurrent;

import java.awt.*;
import java.awt.event.KeyEvent;

public class KeywordsCount {
    private static KeywordsCount kc;

    private int count = 0;
    private KeywordsCount() {

    }

    public static synchronized KeywordsCount getCountObject() {
        if (kc == null) {
            kc = new KeywordsCount();
        }
        return kc;
    }

    public synchronized void addCount(int count) {
        this.count += count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
