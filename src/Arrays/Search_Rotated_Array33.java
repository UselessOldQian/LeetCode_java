package Arrays;

/**
 * @author Qian
 * @create 2021-04-024:55 下午
 */
public class Search_Rotated_Array33 {

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2},0));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while(left<right){
            mid = left+(right-left)/2;
            if(nums[mid]>nums[right]){
                left = mid + 1;
            }
            else{
                right = mid;
            }

        }
        if(target>nums[nums.length-1]){
            left = 0;
            right = right-1;
            while(left<right){
                mid = left+(right-left)/2;
                if(nums[mid]==target){
                    return mid;
                }
                if(nums[mid]>target){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
        }else{
            right = nums.length-1;
            while(left<right){
                mid = left+(right-left)/2;
                if(nums[mid]==target){
                    return mid;
                }
                if(nums[mid]>target){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
        }
        mid = left+(right-left)/2;
        if(nums[mid]==target){
            return mid;
        }
        return -1;
    }
}
