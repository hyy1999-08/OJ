package Array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:Yaoye Huang
 * @create 2024- 07- 01 21:29
 */
public class leetcode_977 {

    public static void main(String[] args) {
        int a[] = new int[]{-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares_2(a)));
    }

    // 法一：暴力排序
    public static int[] sortedSquares(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    //法二:相向
    public static int[] sortedSquares_2(int[] nums) {
        int[] result = new int[nums.length];
        int currentPos = nums.length - 1;
        for (int left = 0, right = nums.length - 1; currentPos >= 0; currentPos--) {
            int leftVal = nums[left] * nums[left];
            int rightVal = nums[right] * nums[right];
            if (leftVal < rightVal) {
                result[currentPos] = rightVal;
                right--;
            } else {
                result[currentPos] = leftVal;
                left++;
            }

        }
        return result;
    }


}
