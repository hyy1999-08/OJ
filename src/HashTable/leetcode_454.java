package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:Yaoye Huang
 * @create 2024- 07- 01 21:29
 */
public class leetcode_454 {

    public static void main(String[] args) {
        System.out.println(fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }


    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 总和, 组合数
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        HashMap<Integer, Integer> resultMap2 = new HashMap<>();

        // 直接干
        for (int a:nums1) {
            for (int b:nums2) {
                resultMap.put(a+b,resultMap.getOrDefault(a+b,0)+1);
            }
        }

        int sum = 0;
        for(int c:nums3){
            for(int d:nums4){
                sum+=resultMap.getOrDefault(-c - d,0);
            }
        }


        return sum;
    }

}
