package demo;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @author:Yaoye Huang
 * @create 2024- 29- 02 20:29
 */
public class demoTest {


    /*
    * 爬楼梯有两种方式：一次上一级和一次上两级，对于一个n级的楼梯，有多少种爬法？
    *
    *
    * */
    public static void main(String[] args) {
        System.out.println(climbStairs(-1));
        System.out.println(climbStairs(0));
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));

        System.out.println(climbStairs(10));

    }




    static int climbStairs(int n){
        int[] myArray = new int[3];

        if (n < 0) {
            return -1;
        }
        if (n <= 2) {
            return n;
        }


        // 1.初始化
        // myArray[i]表示爬到i层有几种方式
        myArray[0] = 1;
        myArray[1] = 1;

        for (int i = 2; i <= n; i++) {
            // myArray[2]放结果，myArray[1]放第一个数，myArray[0]放第二个数
            myArray[2] = myArray[1] + myArray[0];
            myArray[0] = myArray[1];
            myArray[1] = myArray[2];
        }

        return myArray[2];
    }










}
