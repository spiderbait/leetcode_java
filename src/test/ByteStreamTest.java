package test;

public class ByteStreamTest {
    public static void main(String[] args) {

        String oldSeparator = "!@!";
        String oldValue = "20191111!@!great!@!233";

        byte[] oldSeparatorByte = oldSeparator.getBytes();
        byte[] oldValueByte = oldValue.getBytes();

        System.out.println(oldSeparatorByte);

        for(int i=0; i<oldSeparatorByte.length; i++) {
            System.out.println(oldSeparatorByte[i]);
        }


    }
}
