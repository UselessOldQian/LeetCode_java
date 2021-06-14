package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qian
 * @create 2021-04-242:35 下午
 */
public class InsertInterval {
    public static void main(String[] args) {
        insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}},new int[]{4,8});
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resList = new ArrayList<>();
        resList.add(newInterval);
        int ind = 0;
        for(int[] interval: intervals){
            if(interval[0]>newInterval[1]){
                resList.add(ind+1,interval);
            }else if(interval[1]<newInterval[0]){
                resList.add(ind++,interval);
            }else{
                resList.set(ind, new int[]{Math.min(interval[0],newInterval[0]),Math.max(interval[1],newInterval[1])});
            }
        }
        return resList.toArray(new int[resList.size()][]);
    }
}
