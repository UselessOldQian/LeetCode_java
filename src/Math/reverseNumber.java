package Math;

/**
 * @author Qian
 * @create 2021-04-1612:36 下午
 */
public class reverseNumber {
    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
    static public int reverse(int x) {
        int px = Math.abs(x);
        boolean isNegative = false;
        if(px!=x) isNegative = true;
        int ret = 0;
        while(px > 0){
            int digit = x%10;
            px = px/10;
            ret = ret*10 + digit;
        }
        if(isNegative) ret = -ret;
        return ret;
    }
}
