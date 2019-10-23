package reflection;

public class Banana {
    private int n;

    Banana() {
        this.n = 8;
    }

    public void printNum() {
        System.out.println("You have " + n + " banana(s).");
    }

    public void setNum(int n) {
        this.n = n;
    }

    public int getNum() {
        return this.n;
    }
}
