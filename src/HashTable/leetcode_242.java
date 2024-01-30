package HashTable;

import java.util.Scanner;

/**
 * @author:Yaoye Huang
 * @create 2024- 07- 01 21:29
 */
public class leetcode_242 {

    public static void main(String[] args) {
        System.out.println(isAnagram("a", "ab"));
    }

    public static boolean isAnagram(String s, String t) {
        // 统计次数
        int[] amounts = new int[26];
        for(char i:s.toCharArray()){
            amounts[i-'a']++;
        }
        for(char i:t.toCharArray()){
            amounts[i-'a']--;
        }

        for(int i:amounts){
            if( i!= 0){
                return false;
            }
        }
        return true;
    }




}
