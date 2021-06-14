package DynamicProgramming;

/**
 * @author Qian
 * @create 2021-04-228:46 下午
 */
public class NumSquares {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    public static int numSquares(int n) {
        int[] res = new int[n+1];
        res[0] = 0;
        int[] perfects = getPerfects(n);
        int curPerfect = 1;
        for(int i = 1;i<=n;++i){
            if(i>=perfects[curPerfect+1]){curPerfect++;}
            res[i] = Math.min(res[i-1]+1,res[i-perfects[curPerfect]]+1);
        }
        return res[n];
    }

    public static int[] getPerfects(int n){
        int maxPerfect = (int)Math.sqrt(n)+1;
        int[] res = new int[maxPerfect+1];
        for(int i = 0;i<=maxPerfect;i++){
            res[i] = i*i;
        }
        return res;
    }
}
