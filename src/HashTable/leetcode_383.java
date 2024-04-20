package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:Yaoye Huang
 * @create 2024- 07- 01 21:29
 */
public class leetcode_383 {

    public static void main(String[] args) {
        System.out.println(canConstruct("abaaaa", "aaab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        for (char i : magazine.toCharArray()) {
            arr[i - 'a']++;
        }
        for (char i : ransomNote.toCharArray()) {
            if (arr[i - 'a'] == 0) {
                return false;
            }
            arr[i - 'a']--;
        }

        return true;
    }

}
