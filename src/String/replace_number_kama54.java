package String;

public class replace_number_kama54 {

    public static void main(String[] args) {
        System.out.print(replaceNum("a1b2c3"));
    }


    public static String replaceNum(String s){
        char[] target=s.toCharArray();
        StringBuilder stringBuilder=new StringBuilder();
        for(char i:target){
            if(Character.isDigit(i)){
                stringBuilder.append("number");
                continue;
            }

            stringBuilder.append(i);
        }

        return stringBuilder.toString();
    }

}
