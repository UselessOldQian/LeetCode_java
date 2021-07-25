package Arrays;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Qian
 * @create 2021-07-242:44 下午
 */
public class LargestRect85 {
    public static void main(String[] args) {
        String s = "sadf";
        StringBuilder sb = new StringBuilder();
        System.out.println((char)2+'a');
        maximalRectangle(new char[][]
                {{'1','0','1','0','0'},
                        {'1','0','1','1','1'},
                        {'1','1','1','1','1'},
                {'1','0','0','1','0'}});
    }

    static public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if(n==0)
            return 0;
        int m = matrix[0].length;
        if(m==0)
            return 0;
        int[][] hists = new int[n][m];
        for(int j = 0;j<m;++j){
            hists[0][j] = matrix[0][j]=='1' ? 1:0;
        }
        for(int i = 1;i<n;++i){
            for(int j = 0;j<m;++j){
                hists[i][j] = matrix[i][j]=='1' ? hists[i-1][j]+1: 0;
            }
        }
        int max = 0;
        for(int i=0;i<n;++i){
            Deque<Integer> stack = new LinkedList<>();
            stack.push(-1);
            for(int j = 0;j<m;++j){
                int last = stack.peek();
                if(last == -1 || hists[i][j] > hists[i][last]){
                    stack.push(j);
                    continue;
                }
                while(last != -1 && hists[i][last]>=hists[i][j]){
                    int h = stack.pop();
                    last = stack.peek();
                    max = Math.max(max,h*(j-1-last));
                }
                stack.push(j);
            }
        }
        return max;
    }
}
