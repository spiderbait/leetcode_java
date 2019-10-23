package reflection;

public class Apple {
    private int n;

    Apple() {
        this.n = 5;
    }

    public void printNum(){
        System.out.println("You have " + n + " apple(s).");
    }

    public void setNum(int n) {
        this.n = n;
    }

    public int getNum() {
        return this.n;
    }
}
