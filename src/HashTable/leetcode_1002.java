package HashTable;

import java.lang.module.FindException;
import java.util.*;

/**
 * @author:Yaoye Huang
 * @create 2024- 07- 01 21:29
 */
public class leetcode_1002 {

    public static void main(String[] args) {
        // String数组初始化
        String[] words = new String[]{"bella","label","roller"};
        commonChars2(words).stream().forEach(System.out::println);

    }

    // 法一：递归调用
    public static List<String> commonChars(String[] words) {
        return find(words,Arrays.asList(words[0]) ,1);
    }

    public static List<String> find(String[] words,List<String> result, int index){
        if(index==words.length||result.size()==0){
            return result;
        }

        String reduce = result.stream().reduce((i, j) -> i + j).get();
        String word = words[index];
        char[] reduceArray = reduce.toCharArray();
        char[] wordArray = word.toCharArray();
        int[] dict=new int[26];
        for(char i:reduceArray){
            dict[i-'a']++;
        }
        List<String> temp=new ArrayList<>();
        for (char i: wordArray){
            if(dict[i-'a']>0){
                temp.add(String.valueOf(i));
                dict[i-'a']--;
            }

        }

        return find(words,temp,index+1);
    }

    // 法二：取公共值也可以用取所有里面最小的Min
    public static List<String> commonChars2(String[] words) {
        int[] dict = new int[26];

        for (char j : words[0].toCharArray()) {
            dict[j - 'a']++;
        }

        for(String i:words){
            int[] newDict = new int[26];
            for (char j : i.toCharArray()) {
                newDict[j - 'a']++;
            }

            for(int j=0;j<newDict.length;j++){
                dict[j] = Math.min(dict[j], newDict[j]);
            }

        }

        List<String> result=new ArrayList<>();
        for (int i = 0; i < dict.length; i++) {
            int num = dict[i];
            while(num!=0){
                result.add(String.valueOf((char)(i+'a')));
                num--;
            }
        }
        return result;
    }



}
