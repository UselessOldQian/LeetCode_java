package Math;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Qian
 * @create 2021-07-127:56 下午
 */
public class HappyNumber {
    public static void main(String[] args) {
        isHappy(19);
    }
    static public boolean isHappy(int n) {
        Set<Integer> set = new HashSet();
        while(!set.contains(n)){
            set.add(n);
            n = sumDigits(n);
        }
        return n==1;
    }

    static int sumDigits(int n){
        int ret = 0;
        while(n != 0){
            int digit = n%10;
            ret += digit * digit;
            n = n/10;
        }
        return ret;
    }
}
