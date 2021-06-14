package DynamicProgramming;

import Tree.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author Qian
 * @create 2021-04-294:26 下午
 */
public class FrogJump {
    public static void main(String[] args) {

    }

    public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                int diff = stones[j]-stones[i];
                if(diff>i+1){
                    continue;
                }
                dp[j][diff] = dp[i][diff-1]||dp[i][diff]||dp[i][diff+1];
                if(j==n-1 && dp[j][diff]==true){
                    return true;
                }
            }
        }
        return false;
    }
}
