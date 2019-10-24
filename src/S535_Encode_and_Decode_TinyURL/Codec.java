package S535_Encode_and_Decode_TinyURL;

import java.util.HashMap;

public class Codec {

    private int n = 0;
    HashMap<String, String> urlMapping;
    char[] convertMapping = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C',
            'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z'};

    Codec() {
        this.urlMapping = new HashMap<>();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortCode = DecToRadix(this.n);
        this.urlMapping.put(shortCode, longUrl);
        return "http://tinyurl.com/" + shortCode;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String shortCode = shortUrl.split("://")[1].split("/")[1];
        return this.urlMapping.get(shortCode);
    }

    public String DecToRadix(int n) {

        StringBuilder sb = new StringBuilder();
        int reminder = 0;

        while(n != 0) {
            reminder = n % 62;
            sb.insert(0, convertMapping[reminder]);
            n /= 62;
        }

        if(sb.length() < 6) {
            int sbLength = sb.length();
            for(int i=0; i < 6 - sbLength; i++) {
                sb.append('0');
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        String shortUrl = codec.encode("https://leetcode.com/problems/encode-and-decode-tinyurl/");
        String longUrl = codec.decode(shortUrl);
        System.out.println(shortUrl);
        System.out.println(longUrl);

    }
}
