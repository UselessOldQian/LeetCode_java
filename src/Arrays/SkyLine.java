package Arrays;

import java.util.*;

/**
 * @author Qian
 * @create 2021-07-0812:41 上午
 */
public class SkyLine {
    public static void main(String[] args) {
        int a = (int)(Math.ceil(17/(2+4.0)));
        System.out.println(a);
        int[][] builings = new int[][]{{2,9,10},{9,12,15},{10,12,5}};
        getSkyline(builings);
    }
    static public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        List<int[]> heights = new ArrayList();
        for(int[] building: buildings){
            heights.add(new int[]{building[0],-building[2]});
            heights.add(new int[]{building[1],building[2]});
        }
        heights.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)->(b-a));
        priorityQueue.add(0);
        int preHeight = 0;
        for(int[] height: heights){
            if(height[1]<0){
                priorityQueue.add(-height[1]);
            }else{
                priorityQueue.remove(height[1]);
            }
            int curHeight = priorityQueue.peek();
            if(curHeight!=preHeight){
                ans.add(Arrays.asList(height[0],curHeight));
                preHeight = curHeight;
            }
        }
        return ans;
    }
}
