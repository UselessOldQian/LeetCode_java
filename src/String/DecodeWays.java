package String;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Qian
 * @create 2021-05-0912:26 上午
 */
public class DecodeWays {
    public static void main(String[] args) {
        //numDecodings("0");
        int[] arr = new int[10];
        int n = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        if((n=arr.length)==10){
            System.out.println(n);
        }
        Stack<Integer> stack = new Stack<>();
        stack.isEmpty();
        queue.offer(2);
        queue.poll();
        queue.offer(1);
        Arrays.asList();
    }
    public static int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=s.charAt(0)-'0'==0 ? 0:1;

        for(int i =2;i<=n;i++){
            int s1 = s.charAt(i-1)-'0'==0 ? 0:1;
            int s2 = 0;
            if(s1==1){
                s2 = Integer.parseInt(s.substring(i-2,i))<=26 ? 1:0;
            }
            dp[i] = s1*dp[i-1]+s2*dp[i-2];
        }
        return dp[n];
    }
}
