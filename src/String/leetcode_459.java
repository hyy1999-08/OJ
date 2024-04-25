package String;

/**
 * @author:Yaoye Huang
 * @create 2024- 04- 22 21:29
 */
public class leetcode_459 {

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("aba"));
    }

    // 重复由某个子部分组成，转化为了两个全集组成其中必有全集的搜索
    public static boolean repeatedSubstringPattern(String s) {
        return kmp((s + s).substring(1, s.length() * 2 - 1), s);
    }

    public static boolean kmp(String haystack, String needle) {
        char[] needleArray = needle.toCharArray();
        int[] next = getNext(needleArray);
        char[] haystackArray = haystack.toCharArray();
        for (int i = 0, j = 0; i < haystackArray.length - 1; ) {
            while (j > 0 && haystackArray[i] != needleArray[j]) {
                j = next[j - 1] + 1;
            }
            if (haystackArray[i] == needleArray[j]) {
                if (j == needleArray.length - 1) {
                    return true;
                }
                i++;
                j++;
            } else {
                i++;
            }
        }
        return false;
    }


    private static int[] getNext(char[] temp) {
        int j = -1;
        int[] next = new int[temp.length];
        next[0] = -1;

        for (int i = 1; i < temp.length; i++) {
            j = next[i - 1] + 1;
            while (j > 0 && temp[j] != temp[i]) {
                j = next[j - 1] + 1;
            }
            if (temp[i] == temp[j]) {
                next[i] = j;
            } else {
                next[i] = -1;
            }
        }
        return next;
    }
}
