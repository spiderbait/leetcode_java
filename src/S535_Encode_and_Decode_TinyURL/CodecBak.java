package S535_Encode_and_Decode_TinyURL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CodecBak {

    private HashMap<Character,Integer> encodeMapping;
    private HashMap<Integer,Character> binaryMapping;

    CodecBak() {
        int firstLowerCase = 'a';
        int firstUpperCase = 'A';
        char[] symbols = {'-', '_', '/', '.'};

        int keyIndex = 0;
        this.encodeMapping = new HashMap<>();
        this.binaryMapping = new HashMap<>();

        for(int i=firstUpperCase; i<firstUpperCase+26; i++) {
            this.encodeMapping.put((char)i, keyIndex);
            this.binaryMapping.put(keyIndex, (char)i);
            keyIndex ++;
        }

        for(int i=firstLowerCase; i<firstLowerCase+26; i++) {
            this.encodeMapping.put((char)i, keyIndex);
            this.binaryMapping.put(keyIndex, (char)i);
            keyIndex ++;
        }

        for(int i=0; i<10; i++) {
            this.binaryMapping.put(keyIndex+i, (char)i);
        }

        for(char c: symbols) {
            this.encodeMapping.put(c, keyIndex);
            keyIndex ++;
        }


        System.out.println(this.binaryMapping.size());
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String[] urlSplits = longUrl.split("://");

        String protocol = urlSplits[0];
        String address = urlSplits[1];
        String[] a;
        List<String> binaryList = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for (char c: address.toCharArray()) {
            sb.append(Integer.toBinaryString(encodeMapping.get(c)));
        }

        StringBuilder tSb = new StringBuilder();
        int tSbCounter = 0;
        for (int i=sb.length()-1; i>=0; i--) {
            tSb.insert(0, sb.charAt(i));
            tSbCounter ++;
            if(tSbCounter == 64) {
                binaryList.add(tSb.toString());
                tSb.delete(0, tSb.length());
                tSbCounter = 0;
            }
            if(i == 0) {
                for(int j=tSbCounter; j<=64; j++) {
                    tSb.insert(0, '0');
                }
                binaryList.add(tSb.toString());
                tSb.delete(0, tSb.length());
                tSbCounter = 0;
            }
        }

        return binaryList.get(0);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {

        return "";
    }

    public String binaryToShort(List<String> binaryList) {

        return "";
    }

    public static void main(String[] args) {
        CodecBak codec = new CodecBak();
        String url = "https://leetcode.com/problems/design-tinyurl";
        System.out.println(codec.encode(url));
        System.out.println(Integer.toBinaryString(123));
    }

}
