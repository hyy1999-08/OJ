package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author:Yaoye Huang
 * @create 2024- 07- 01 21:29
 */
public class leetcode_15 {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    // 排序法
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        // 怎么保证组合不重复
        // 1）排序完就好做了
        // 2）维护1个HashSet<>不能重复

        //法一:
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {

            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = nums[i];
            if (a > 0) {
                break;
            }
            for (int j = i + 1, z = nums.length - 1; j < z; ) {
                int b = nums[j];
                int c = nums[z];
                if (a + b > 0) {
                    break;
                }
                if (a + b + c == 0) {
                    List<Integer> partResult = new ArrayList<>();
                    partResult.add(a);
                    partResult.add(b);
                    partResult.add(c);
                    result.add(partResult);
                    while (j < z && nums[z]==nums[z-1])z--;
                    z--;
                    while (j < z && nums[j]==nums[j+1])j++;
                    j++;
                }else if(a+b+c>0){
                    while (j < z && nums[z]==nums[z-1])z--;
                    z--;
                }else if(a+b+c<0){
                    while (j < z && nums[j]==nums[j+1])j++;
                    j++;
                }
            }

        }

        return result;
    }

}
