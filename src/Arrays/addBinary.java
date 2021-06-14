package Arrays;
import java.util.Arrays;

/**
 * @author Qian
 * @create 2021-04-243:32 下午
 */
public class addBinary {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,2};
        Arrays.sort(a);
        System.out.println(a);
        System.out.println(addBinary67("11","1"));
    }

    public static String addBinary67(String a, String b) {
        int na = a.length()-1;
        int nb = b.length()-1;
        StringBuilder res = new StringBuilder();
        int carry = 0;
        while(na>0 || nb>0){
            int digita = na >= 0 ? Character.getNumericValue(a.charAt(na--)):0;
            int digitb = nb >= 0 ? Character.getNumericValue(b.charAt(nb--)):0;
            int sum = digitb+digita + carry;
            carry = sum >= 2 ? 1:0;
            res.append(sum%2);
        }
        if(carry==1){res.append(carry);}
        return res.reverse().toString();
    }
}
