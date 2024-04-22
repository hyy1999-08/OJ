package String;

/**
 * @author:Yaoye Huang
 * @create 2024- 04- 22 21:29
 */
public class leetcode_151 {

    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }

    public static String reverseWords(String s) {
        String[] target = s.trim().split(" ");
        StringBuilder result = new StringBuilder();
        for (int j = target.length - 1; j >= 0; j--) {
            if (target[j].equals("")) {
                continue;
            }
            result.append(target[j]);
            result.append(" ");
        }

        result.deleteCharAt(result.length()-1);
        return result.toString();
    }
}
