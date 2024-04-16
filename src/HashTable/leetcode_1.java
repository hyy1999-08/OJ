package HashTable;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author:Yaoye Huang
 * @create 2024- 07- 01 21:29
 */
public class leetcode_1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));
    }

    // 方法一： 先放到Map然后一个个对着查
    public static int[] twoSum(int[] nums, int target) {
        // 值，坐标
        Map<Integer, Integer> dictMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            dictMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (dictMap.containsKey(target - num) && dictMap.get(target - num) != i) {
                return new int[]{i, dictMap.get(target - num)};
            }
        }
        System.out.println(3);
        return new int[0];
    }

    // 优化：不用提前放到Map里，反正都是要遍历一遍
    public static int[] twoSum_2(int[] nums, int target) {
        // 值，坐标
        Map<Integer, Integer> dictMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (dictMap.containsKey(target - num)) {
                return new int[]{i, dictMap.get(target - num)};
            }
            dictMap.put(nums[i], i);
        }

        return new int[0];
    }

}
