package BitOperation;

/**
 * @author Qian
 * @create 2021-04-2212:53 上午
 */
public class ReverseBits {
    public static void main(String[] args) {
        reverseBits(154378);
    }

    public static int reverseBits(int n) {
        int filter1 = 0x55555555;
        int filter2 = 0x33333333;
        int filter3 = 0x0f0f0f0f;
        int filter4 = 0x00ff00ff;
        int filter5 = 0x0000ffff;
        String show = Integer.toBinaryString(n);
        String showl = Integer.toBinaryString((n&filter5)<<16);
        String showr = Integer.toBinaryString((n>>16)&filter5);
        n = ((n&filter5)<<16)+((n>>16)&filter5);

        String show2 = Integer.toBinaryString(n);
        n = ((n&filter4)<<8)+((n>>8)&filter4);
        String show3 = Integer.toBinaryString(n);
        n = ((n&filter3)<<4)+((n>>4)&filter3);
        String show4 = Integer.toBinaryString(n);
        n = ((n&filter2)<<2)+((n>>2)&filter2);
        String show5 = Integer.toBinaryString(n);
        n = ((n&filter1)<<1)+((n>>1)&filter1);
        String show6 = Integer.toBinaryString(n);
        return n;
    }
}
