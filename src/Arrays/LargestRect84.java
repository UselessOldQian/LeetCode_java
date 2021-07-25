package Arrays;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Qian
 * @create 2021-07-242:20 下午
 */
public class LargestRect84 {
    public static void main(String[] args) {
        largestRectangleArea(new int[]{2,1,5,6,2,3});
    }

    static public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int max = 0;
        for(int i=0;i<heights.length;i++){
            int last = stack.peek();
            if(last==-1 || heights[last]<heights[i]){
                stack.push(i);
                continue;
            }
            while(last != -1 && heights[last]>=heights[i]){
                int h = heights[stack.pop()];
                last = stack.peek();
                max = Math.max(max,h*(i-last-1));
            }
        }
        while(stack.peek()!=-1){
            int h = heights[stack.pop()];
            max = Math.max(max,h*(heights.length-stack.peek()-1));
        }
        return max;
    }
}
