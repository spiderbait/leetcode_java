package S929_Unique_Email_Addresses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public String periodTrim(String str) {
        String rst = "";
        for(int i=0; i<str.length(); i++){
            if (str.charAt(i) == '.') {
                continue;
            } else {
                rst += str.charAt(i);
            }
        }
        return rst;
    }

    public int numUniqueEmails(String[] emails) {

        int count = 0;
        List<String> realEmails = new ArrayList<>();

        for(String email: emails) {
            String[] emailAddrSplit = email.split("@");
            String localName = emailAddrSplit[0];
            String domainName = emailAddrSplit[1];
            localName = periodTrim(localName);
            localName = localName.split("\\+")[0];
            String realEmail = localName + "@" + domainName;
            if (realEmails.contains(realEmail)) {
                continue;
            } else {
                count ++;
                realEmails.add(realEmail);
            }
        }
        System.out.println(realEmails);

        return count;
    }

    public static void main(String[] args){

        Solution solution = new Solution();
        String[] s = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(solution.numUniqueEmails(s));

    }
}

//class Solution {
//    public int numUniqueEmails(String[] emails) {
//        Set<String> seen = new HashSet();
//        for (String email: emails) {
//            int i = email.indexOf('@');
//            String local = email.substring(0, i);
//            String rest = email.substring(i);
//            if (local.contains("+")) {
//                local = local.substring(0, local.indexOf('+'));
//            }
//            local = local.replaceAll(".", "");
//            seen.add(local + rest);
//        }
//
//        return seen.size();
//    }
//}
