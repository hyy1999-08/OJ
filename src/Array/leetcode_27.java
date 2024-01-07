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
        for (; right != nums.length; right++) {
            if (val != nums[right]) {
                nums[left++] = nums[right];
            }
        }
        return nums.length - (right - left);
    }




}
