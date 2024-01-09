package Array;

import java.util.Arrays;

/**
 * @author:Yaoye Huang
 * @create 2024- 07- 01 21:29
 */
public class leetcode_209 {

    public static void main(String[] args) {
        int a[] = new int[]{1,4,4};
        System.out.println(minSubArrayLen_2(4, a));
    }

    // 法一：暴力,找到所有可能并记录最小值,超出时间限制
    public static int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    //法二: 连续，滑窗法
    public static int minSubArrayLen_2(int target, int[] nums) {
        int left = 0, right = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (; right < nums.length; right++) {
            sum += nums[right];
            // 左边记录
            while (sum >= target) {
                sum -= nums[left];
                // 临界的时候减完发现小了就记录
                if (sum < target) {
                    min = Math.min(min, right - left + 1);
                }
                // 该数组已记录所以++
                left++;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    //改良逻辑: 连续，滑窗法
    public static int minSubArrayLen_3(int target, int[] nums) {
        int left = 0, right = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (; right < nums.length; right++) {
            sum += nums[right];
            // 左边记录
            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum-=nums[left++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }


}
