package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Qian
 * @create 2021-04-241:39 下午
 */
public class MergeInterval {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{15,18},{2,6},{8,10}};
        System.out.println(mergeInterval(intervals));
    }

    public static int[][] mergeInterval(int[][] intervals){
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> resList = new ArrayList<>();
        for(int i = 0;i<intervals.length;i++){
            int l = intervals[i][0];
            int r = intervals[i][1];
            if(i==0||resList.get(resList.size()-1)[1]<l){
                resList.add(intervals[i]);
            }else {
                resList.get(resList.size()-1)[1] = Math.max(r,resList.get(resList.size()-1)[1]);
            }
        }
        return resList.toArray(new int[resList.size()][]);

    }
}
