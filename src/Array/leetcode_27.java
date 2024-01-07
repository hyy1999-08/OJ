package Array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:Yaoye Huang
 * @create 2024- 07- 01 21:29
 */
public class leetcode_27 {

    public static void main(String[] args) {
        int a[] = new int[]{3, 2, 2, 3};
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的参数");
        int target = sc.nextInt();
        System.out.println(removeElement(a, target));
    }

    public static int removeElement(int[] nums, int val) {
        int left = 0, right = 0;
        while (right != nums.length) {
            if (val == nums[left] || val == nums[right]) {
                while (right < nums.length && nums[right] == val) right++;
            }
            if (right < nums.length) {
                nums[left++] = nums[right++];
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums.length - (right - left);
    }




}
