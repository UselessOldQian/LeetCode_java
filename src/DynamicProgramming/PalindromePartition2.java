package DynamicProgramming;

import java.util.Arrays;

/**
 * @author Qian
 * @create 2021-07-075:33 下午
 */
public class PalindromePartition2 {
    public static void main(String[] args) {
        minCut("abbab");
    }

    static public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        boolean[][] isPalin = new boolean[n][n];
        for(int i = 0;i<n;i++){
            isPalin[i][i] = true;
        }
        for(int i = n-1;i>=0;i--){
            for(int j = i+1;j<n;j++){
                if(i+1==j){
                    isPalin[i][j] = s.charAt(i)==s.charAt(j);
                }
                else{
                    isPalin[i][j] = (isPalin[i+1][j-1] && s.charAt(i)==s.charAt(j));
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (isPalin[0][i]) {
                dp[i] = 0;
            } else {
                for (int j = 0; j < i; ++j) {
                    if (isPalin[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[n-1];
    }
}
