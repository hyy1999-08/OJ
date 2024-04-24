package String;

/**
 * @author:Yaoye Huang
 * @create 2024- 04- 22 21:29
 */
public class leetcode_28 {

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issip"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        // 正常来说肯定是一个个比较，但是不应该重头
        // 所以也就是每个数组下标维护跟这个一模一样的
        // 正推法建立在对后面的数组遍历，无法用到之前的
        // 逆推法则可以使用之前的信息建立前缀表
        char[] needleArray = needle.toCharArray();
        int[] next = getNext(needleArray);
        char[] haystackArray = haystack.toCharArray();
        for (int x = 0, y = 0; x < haystack.length(); ) {
            while (y > 0 && haystackArray[x] != needleArray[y]) {
                y = next[y - 1] + 1;
            }
            if (haystackArray[x]== needleArray[y]){
                if (y == needleArray.length-1) {
                    return x - y;
                }
                x++;
                y++;
            }else{
                x++;
            }
        }
        return -1;
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
