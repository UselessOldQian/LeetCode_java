package Arrays;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Qian
 * @create 2021-07-1412:02 上午
 */
public class FindKthLargest {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
    static public int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length-1;
        while(l<r){
            int i = l;
            for(int j = l;j<r;++j){
                if(nums[j]>nums[r]){
                    swap(nums,i,j);
                    i++;
                }
            }
            swap(nums,r,i);
            if(i==k-1){
                return nums[i];
            }
            if(i>k-1){
                r = i-1;
            }else{
                l = i+1;
            }
        }
        return -1;
    }

    static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
