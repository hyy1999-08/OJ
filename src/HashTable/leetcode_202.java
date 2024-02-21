package HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author:Yaoye Huang
 * @create 2024- 07- 01 21:29
 */
public class leetcode_202 {

    public static void main(String[] args) {

        System.out.println(isHappy(2));
    }

    public static boolean isHappy(int n) {
        Set<Integer> dict = new HashSet<>();

        while (true) {
            int sum = 0;
            while (true) {
                int i = n % 10;
                n = n / 10;
                sum += i * i;
                if (n == 0) {
                    break;
                }
            }
            if (sum == 1) {
                return true;
            } else if (dict.contains(sum)) {
                return false;
            }
            dict.add(sum);
            n = sum;
        }
    }

}
