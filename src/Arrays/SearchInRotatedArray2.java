package Arrays;

/**
 * @author Qian
 * @create 2021-07-1010:12 下午
 */
public class SearchInRotatedArray2 {
    public static void main(String[] args) {
        search(new int[]{1,0,1,1,1},0);
        search(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1}, 2);
    }
    static public boolean search(int[] nums, int target) {
        int pivot=searchPivot(nums);
        if(target>nums[0])
            return binarySearch(nums, 0, pivot-1,target);
        return binarySearch(nums, pivot, nums.length-1, target);
    }

    static int searchPivot(int[] nums){
        int l = 0,r = nums.length-1;
        while(l<r){
            if(nums[l]<nums[r])
                return l;
            int mid = l+(r-l)/2;
            if(nums[mid] == nums[r] && nums[mid] == nums[l]){
                if(r-1>=0 && nums[r] < nums[r-1])
                    return r;
                r--;
                l++;
            }
            else if(nums[mid] != nums[r]){
                if(nums[mid] > nums[r]){
                    l = mid+1;
                }
                else if(nums[mid] < nums[r]){
                    r = mid;
                }
            }
            else if(nums[mid] != nums[l]){
                if(nums[mid] > nums[l]){
                    l = mid +1;
                }
                else if(nums[mid] < nums[l]){
                    r = mid;
                }
            }
        }
        return r;
    }

    static boolean binarySearch(int[] nums, int start, int end, int target){
        while(start <= end){
            int mid = start + (end-start)/2;
            if(target==nums[mid])
                return true;
            if(target<nums[mid]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }

        }
        return false;
    }
}
