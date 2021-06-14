package String;

/**
 * @author Qian
 * @create 2021-04-262:56 下午
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        int[][] DP = new int[n][n];
        int maxLen = 0;
        int start = 0;
        int end = 0;
        for(int i = 0;i<n;++i){
            DP[i][i] = 1;
            if(i<n-1 && s.charAt(i)==s.charAt(i+1)){
                DP[i][i+1] = 2;
                if(DP[i][i+1]>maxLen){
                    maxLen = DP[i][i+1];
                    start = i;
                    end = i+1;
                }
            }
        }

        for(int i = n-3;i>=0;--i){
            for(int j =i+2;j<n;++j){
                if(DP[i+1][j-1]>0&&s.charAt(i)==s.charAt(j)) {
                    DP[i][j] = DP[i + 1][j - 1] + 2;
                    if (DP[i][j] > maxLen) {
                        maxLen = DP[i][j];
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end+1);

    }
}
