package DynamicProgramming;

/**
 * @author Qian
 * @create 2021-04-225:16 下午
 */
public class UniquePass62 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,2));
    }
    public static int uniquePaths(int m, int n) {
        int[][] dpArray = new int[m][n];

        for(int i = 0;i<dpArray[0].length;i++){
            for(int j = 0;j<dpArray.length;j++){
                if(i==0){
                    dpArray[j][0] = 1;
                    continue;
                }
                if(j==0){
                    dpArray[0][i] = 1;
                    continue;
                }
                dpArray[j][i] = dpArray[j][i-1]+dpArray[j-1][i];
            }
        }
        return dpArray[m-1][n-1];
    }
}
