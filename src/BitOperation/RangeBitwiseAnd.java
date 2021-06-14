package BitOperation;

/**
 * @author Qian
 * @create 2021-04-2110:29 下午
 */
public class RangeBitwiseAnd {
    public static void main(String[] args) {
        System.out.println(0x3333);
        System.out.println(rangeBitwiseAnd(5,7));
    }

    public static int rangeBitwiseAnd(int left, int right) {
        int left_count = (int)(Math.log(left)/Math.log(2));
        int right_count = (int)(Math.log(right)/Math.log(2));
        if(left_count != right_count){
            return 0;
        }
        int diff = left^right;
        int diffDigit = (int)(Math.log(diff)/Math.log(2))+1;
        return right>>diffDigit<<diffDigit;
    }

//    public static int getDiffDigit(int diff){
//        int diff_count = (int)(Math.log(diff)/Math.log(2))+1;
//        while(diff_count>0){
//            int d = diff>>diff_count;
//            if((d&1)==1){return diff_count+1;}
//            diff_count--;
//        }
//        return 0;
//    }
}
