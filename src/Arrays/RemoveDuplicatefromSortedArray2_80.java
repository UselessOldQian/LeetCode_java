package Arrays;

/**
 * @author Qian
 * @create 2021-04-029:37 下午
 */
public class RemoveDuplicatefromSortedArray2_80 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,2,2,2,3,3,4,4,4};
        int len = removeDuplicates(arr);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length<=2){
            return 2;
        }
        int j=2;
        for(int i=2;i<nums.length;i++){
            if(nums[j-2]!=nums[i]){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }
}
