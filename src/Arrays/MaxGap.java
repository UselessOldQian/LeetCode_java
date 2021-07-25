package Arrays;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Qian
 * @create 2021-07-103:02 上午
 */
public class MaxGap {
    public static void main(String[] args) {
        maximumGap(new int[]{1,2,3,100});
    }

    static public int maximumGap(int[] nums) {
        Deque<Integer> deque = new LinkedList<>();
        deque.pollFirst();
        boolean r = false;
        r = !r;
        System.out.println(r);
        if(nums.length<2)
            return 0;
        // int ret = 0;
        // Arrays.sort(nums);
        // for(int i =1;i<nums.length;i++){
        //     ret = Math.max(ret,nums[i]-nums[i-1]);
        // }
        // return ret;
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();

        int interval = (int)Math.ceil((max-min)/(nums.length-1.0));
        int bucketsNum = (max-min)/interval + 1;
        int[][] buckets = new int[bucketsNum][2];
        for(int[] bucket:buckets){
            bucket = new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE};
        }

        for(int num: nums){
            int bucketInd = (num-min)/interval;
            buckets[bucketInd][0] = Math.min(buckets[bucketInd][0],num);
            buckets[bucketInd][1] = Math.max(buckets[bucketInd][1],num);
        }
        int maxGap = 0;
        int prevValid = 0;
        for(int i = 0;i<buckets.length;i++){
            if(buckets[i][0] == Integer.MAX_VALUE)
                continue;
            if(i>0)
                maxGap = Math.max(maxGap,buckets[i][0] - buckets[prevValid][1]);
            maxGap = Math.max(maxGap,buckets[i][1] - buckets[i][0]);
            prevValid = i;
        }
        return maxGap;
    }
}
