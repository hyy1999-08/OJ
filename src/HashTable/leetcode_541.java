package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:Yaoye Huang
 * @create 2024- 07- 01 21:29
 */
public class leetcode_541 {

    public static void main(String[] args) {
        System.out.println(reverseStr("a", 2));
    }

    public static String reverseStr(String s, int k) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2 * k) {
            if (i + k > s.length()) {
                result.append(reverseSubString(s.substring(i)));
                break;
            }


            String reversetarget = s.substring(i, i + k);
            result.append(reverseSubString(reversetarget));
            int endIndex= Math.min((i + 2 * k), s.length());
            result.append(s.substring(i+k, endIndex));
        }

        return result.toString();
    }


    public static String reverseSubString(String s) {
        char[] target=s.toCharArray();
        for (int i = 0,j=s.length()-1; i < s.length() / 2; i++,j--) {
            char temp=target[i];
            target[i]=target[j];
            target[j]=temp;
        }
        return new String(target);
    }

}
