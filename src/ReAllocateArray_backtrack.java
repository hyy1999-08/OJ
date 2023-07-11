import java.util.*;

/**
 * @author:Yaoye Huang
 * @create 2023- 10- 07 23:59
 */
public class ReAllocateArray_backtrack {
    private static HashSet<String> result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        result = new HashSet<>();
        String target = sc.next();
        Map<Character, Integer> dict = getDict(target);
        getNum(new StringBuilder(), dict,target.length());
        System.out.println(result.size());
        System.out.println(Arrays.toString(result.toArray()));
    }

    private static void getNum(StringBuilder target, Map<Character, Integer> dict,int length) {
        if (target.length()==length) {
            result.add(target.toString());
            return;
        }

        for (Map.Entry<Character, Integer> entry : dict.entrySet()) {
            char ctemp = entry.getKey();
            int num = entry.getValue();
            if (num > 0) {
                target.append(ctemp);
                dict.put(ctemp, num - 1);

                getNum(target, dict,length);

                target.deleteCharAt(target.length() - 1);
                dict.put(ctemp, dict.getOrDefault(ctemp, 0) + 1);
            }
        }
    }

    private static Map<Character, Integer> getDict(String target) {
        HashMap<Character, Integer> myMap = new HashMap<>();
        for (char i : target.toCharArray()) {
            myMap.put(i, myMap.getOrDefault(i, 0) + 1);
        }
        return myMap;
    }
}
