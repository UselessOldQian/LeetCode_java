package Arrays;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Qian
 * @create 2021-07-251:36 上午
 */
public class CreateMaxNumber321 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{3,4,6,5};
        int[] nums2 = new int[]{9,1,2,5,8,3};
        System.out.println(maxNumber(nums1, nums2, 5));
    }

    static public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] maxSeq = new int[k];
        int start = Math.max(0, k - m), end = Math.min(k, n);
        for(int i = start;i<end;++i){
            int[] subSeq1 = getMaxSeq(nums1,i);
            int[] subSeq2 = getMaxSeq(nums2,k-i);
            int[] newSeq = merge(subSeq1,subSeq2);
            if(compare(newSeq,0,maxSeq,0)>0){
                System.arraycopy(newSeq,0,maxSeq,0,k);
            }
        }
        return maxSeq;
    }

    static public int[] getMaxSeq(int[] nums, int i){
        if(i==0)
            return new int[0];
        Deque<Integer> stack = new LinkedList<>();
        int last = nums.length - i;
        for(int num:nums){
            while(!stack.isEmpty() && stack.peek()<num && last > 0){
                stack.pop();
                last--;
            }
            stack.push(num);
        }
        int[] ret = new int[stack.size()];
        for(int j = ret.length-1;j>=0;--j){
            ret[j] = stack.pop();
        }
        return ret;
    }

    static public int[] merge(int[] subsequence1, int[] subsequence2) {
        int x = subsequence1.length, y = subsequence2.length;
        if (x == 0) {
            return subsequence2;
        }
        if (y == 0) {
            return subsequence1;
        }
        int mergeLength = x + y;
        int[] merged = new int[mergeLength];
        int index1 = 0, index2 = 0;
        for (int i = 0; i < mergeLength; i++) {
            if (compare(subsequence1, index1, subsequence2, index2) > 0) {
                merged[i] = subsequence1[index1++];
            } else {
                merged[i] = subsequence2[index2++];
            }
        }
        return merged;
    }

    static public int compare(int[] nums1,int start1,int[] nums2,int start2){
        while(nums1.length>start1 && nums2.length>start2){
            int dif = nums1[start1++] - nums2[start2++];
            if(dif != 0){
                return dif;
            }
        }
        return nums1.length-start1 - (nums2.length-start2);
    }
}
