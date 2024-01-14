package Array;

import java.lang.reflect.GenericArrayType;
import java.util.Scanner;

/**
 * @author:Yaoye Huang
 * @create 2024- 07- 01 21:29
 */
public class leetcode_59 {

    public static void main(String[] args) {
        int a[] = new int[]{1,4,4};
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入：");
        int n=sc.nextInt();
        int[][] array=generateMatrix(n);
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }

    // 法一：暴力,找到所有可能并记录最小值,超出时间限制
    public static int[][] generateMatrix(int n) {
        if(n==1){
            int[][] result=new int[1][1];
            result[0][0]=1;
            return  result;
        }
        // 向右向下向左向上
        //约定向右为x正，向下为y正
        int xPos = 0;
        int yPos = 0;
        int num = 1;

        int[][] result = new int[n][n];
        if(n%2!=0){
            result[n/2][n/2]=n*n;
        }
        int xInitial=0;
        int yInitial=0;
        int round = n - 1;
        while (num < n * n) {
            xPos=xInitial;
            yPos=yInitial;
            rightFill(result, xPos, yPos, round, num);
            xPos = xPos + round;
            num += round;
            if (num >= n * n) {
                break;
            }
            downFill(result, xPos, yPos, round, num);
            yPos = yPos + round;
            num += round;
            leftFill(result, xPos, yPos, round, num);
            xPos = xPos - round;
            num += round;
            upFill(result, xPos, yPos, round, num);
            num += round;
            if (num >= n * n) {
                break;
            }
            xInitial++;
            yInitial++;
            round -= 2;
        }
        return result;
    }

    private static void rightFill(int[][] result, int xPos, int yPos, int n,int num){
        for (int i = yPos, j = xPos; j < xPos + n; j++, num++) {
            result[i][j]=num;
        }
    }

    private static void downFill(int[][] result, int xPos, int yPos, int n,int num){
        for (int i = yPos, j = xPos; i < yPos + n; i++, num++) {
            result[i][j]=num;
        }
    }

    private static void leftFill(int[][] result, int xPos, int yPos, int n,int num){
        for (int i = yPos, j = xPos; j > xPos - n; j--, num++) {
            result[i][j]=num;
        }
    }

    private static void upFill(int[][] result, int xPos, int yPos, int n,int num){
        for (int i = yPos, j = xPos; i > yPos - n; i--, num++) {
            result[i][j]=num;
        }
    }


}
