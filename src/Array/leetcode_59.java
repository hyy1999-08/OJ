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

    public static int[][] generateMatrix(int n) {
        // 向右向下向左向上
        //约定向右为x正，向下为y正
        int[][] result = new int[n][n];
        if(n%2!=0){
            result[n/2][n/2]=n*n;
        }
        // x第几行row
        int xPos = 0;

        // y代表第几列column
        int yPos = 0;

        //每圈x起始位置
        int xInitial=0;

        // 每圈y起始位置
        int yInitial=0;

        // 负责生成数字填充
        int num = 1;

        // 每圈过后需要迭代的差值
        int offset = 1;
        while (num < n * n) {
            xPos = xInitial;
            yPos = yInitial;

            //（不考虑抽离方法，因为基本数据类型不好传递）
            // 往右边填充
            for(; yPos < n-offset; yPos++){
                result[xPos][yPos]=num++;
            }

            // 往下填充
            for( ; xPos < n-offset; xPos++){
                result[xPos][yPos]=num++;
            }

            // 往左边填充
            for(; yPos >= offset; yPos--){
                result[xPos][yPos]=num++;
            }

            // 往上边填充
            for(; xPos >= offset; xPos--){
                result[xPos][yPos]=num++;
            }

            xInitial++;
            yInitial++;
            offset++;
        }
        return result;
    }

}
