package DynamicProgramming;

/**
 * @author Qian
 * @create 2021-04-2210:13 下午
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] a = {1,2,1,1};
        System.out.println(rob(a));
    }

    public static int rob(int[] nums) {
        if(nums.length >= 2)
            nums[1] = Math.max(nums[0],nums[1]);
        if(nums.length == 2){ return nums[1];}
        for(int i = 2;i<nums.length;i++){
            nums[i] = Math.max(nums[i-1],nums[i-2]+nums[i]);
        }
        return nums[nums.length-1];
    }
}
