package Array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:Yaoye Huang
 * @create 2024- 06- 01 18:18
 */
public class leetcode_704 {


    public static void main(String[] args) {
        int a[]=new int[]{-1,0,3,5,9,12};
        System.out.println(Arrays.toString(a));
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入你的数字:");
        int target=sc.nextInt();
        int start=0;


        System.out.println(biSort(a, start, a.length - 1, target));

    }


    @Test
    public void test(){



    }


    // 左闭合右闭合
    public static int biSort(int tarray[], int start, int end, int target){
        if(start>end){
            return -1;
        }
        // 回溯结束条件
        int mPos=(start+end)/2;
        int mVal=tarray[mPos];


        if (mVal == target) {
            return mPos;
        }else if(target<mVal){
            return biSort(tarray,start,mPos-1,target);
        }else if(target>mVal){
            return biSort(tarray,mPos+1,end,target);
        }
        return -1;
    }

}
