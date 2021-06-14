package Arrays;

/**
 * @author Qian
 * @create 2021-06-109:19 下午
 */
public class MaxProductArray {
    public static void main(String[] args) {
        maxProduct(new int[]{-2, -4, -6});
    }


    static public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = max;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                max = Math.max(min*nums[i],nums[i]);
                min = Math.min(max*nums[i],nums[i]);
            }else{
                max = Math.max(max*nums[i],nums[i]);
                min = Math.min(min*nums[i],nums[i]);
            }
            res = Math.max(res,max);
        }
        return res;
    }
}