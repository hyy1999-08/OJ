import java.util.Map;
import java.util.Scanner;

/**
 * @author:Yaoye Huang
 * @create 2023- 05- 07 23:14
 */
public class RedAndGreen_25 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String target=sc.next();
        System.out.println(getNum(target));

    }
    //要么先红再绿，要么全红，要么全绿

    public static int getNum(String target){
        if(target.isEmpty()||target.length()==1){
            return 0;
        }

        char[] ctarget=target.toCharArray();

        int greenNum;
        int[] result_g = new int[ctarget.length];

        if(ctarget[0]=='G'){
            greenNum = 1;
            result_g[0]=0;
        }else{
            greenNum = 0;
            result_g[0]=1;
        }

        // 2.初始化
        result_g[0] = ctarget[0]=='G'? 0 : 1;

        for(int index=1;index<ctarget.length;index++){
            char currentChar=ctarget[index];
            if(currentChar=='G'){
                //绿色结尾，有两种符合，要么全涂绿，要么前面红，后面绿
                result_g[index]=Math.min(result_g[index-1], greenNum);

                //记录绿色个数
                greenNum+=1;
            }else{
                //红色
                //要么把前面的绿的全涂红，要么就涂成绿色，涂的次数+1
                result_g[index]=Math.min(result_g[index-1],greenNum)+1;
            }
        }
        return Math.min(greenNum,result_g[ctarget.length-1]);

    }




}
