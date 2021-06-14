package String;

/**
 * @author Qian
 * @create 2021-04-2612:26 下午
 */
public class CountAndSay {
    public static void main(String[] args) {

        char[] chars = "asdfasf".toCharArray();
        chars.toString();
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
        System.out.println(countAndSay(7));
        System.out.println(countAndSay(8));
    }

    public static String countAndSay(int n){
        StringBuilder res = new StringBuilder();
        res.append(1);
        for(int i = 2;i<=n;i++) {
            res = getCountandSay(res);
        }
        return res.toString();
    }

    public static StringBuilder getCountandSay(StringBuilder s){
        StringBuilder sb = new StringBuilder();
        char lastChar = s.charAt(0);
        int count = 1;
        for(int i =1;i<s.length();i++){
            if(lastChar != s.charAt(i)){
                sb = sb.append(count);
                sb = sb.append(lastChar);
                lastChar = s.charAt(i);
                count = 1;
            }else {
                count++;
            }
        }
        sb = sb.append(count);
        sb = sb.append(lastChar);
        return sb;
    }
}
