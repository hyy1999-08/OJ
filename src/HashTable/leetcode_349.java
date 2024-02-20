package HashTable;

import javax.xml.transform.Result;
import java.util.*;

/**
 * @author:Yaoye Huang
 * @create 2024- 07- 01 21:29
 */
public class leetcode_349 {

    public static void main(String[] args) {
        System.out.println(intersection(new int[]{}, new int[]{2,4,5}));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> dict = new HashSet<>();
        for (int i : nums1) {
            dict.add(i);
        }

        Set<Integer> result = new HashSet<>();
        for (int j : nums2) {
            if (dict.contains(j)) {
                result.add(j);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

}
