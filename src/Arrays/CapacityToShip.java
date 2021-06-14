package Arrays;

import java.util.Arrays;

/**
 * @author Qian
 * @create 2021-04-2912:35 下午
 */
public class CapacityToShip {
    public static void main(String[] args) {
        shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10},5);
    }
    public static int shipWithinDays(int[] weights, int D) {
        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
        int mid = 0;
        while(left<right){
            mid = left+(right-left)/2;
            int days = conveyDays(mid,weights);
            if(days>D){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return right;
    }

    public static int conveyDays(int load,int[] weights){
        int days = 1;
        int loadLast = load;
        for(int weight:weights){
            if(loadLast>=weight){
                loadLast -= weight;
            }else{
                days++;
                loadLast = load-weight;
            }

        }
        return days;
    }
}
