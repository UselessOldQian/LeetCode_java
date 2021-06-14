package BitOperation;

/**
 * @author Qian
 * @create 2021-04-2212:03 上午
 */
public class CountBits {
    public static void main(String[] args) {
        System.out.println((76576>>3)&1234);
        System.out.println(76576>>3&1234);
        System.out.println(countBits(5));
    }

    public static int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i=0;i<=num;i++){
            if((i&1)==1){res[i]=res[i-1]+1;continue;}
            res[i] = getOnes(i);
        }
        return res;
    }

    public static int getOnes(int i){
        int filter1 = 0x55555555;
        int filter2 = 0x33333333;
        int filter3 = 0x0f0f0f0f;
        int filter4 = 0x00ff00ff;
        int filter5 = 0x0000ffff;
        i = (i&filter1)+((i>>1)&filter1);
        String show1 = Integer.toBinaryString(i&filter1);
        String show2 = Integer.toBinaryString((i>>1)&filter1);
        String show = Integer.toBinaryString(i);
        i = (i&filter2)+((i>>2)&filter2);
        show = Integer.toBinaryString(i);
        i = (i&filter3)+((i>>4)&filter3);
        show = Integer.toBinaryString(i);
        i = (i&filter4)+((i>>8)&filter4);
        i = (i&filter5)+((i>>8)&filter5);
        show = Integer.toBinaryString(i);
        return i;
    }
}
