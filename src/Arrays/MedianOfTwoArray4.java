package Arrays;

/**
 * @author Qian
 * @create 2021-04-2412:49 上午
 */
public class MedianOfTwoArray4 {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{},new int[]{1}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        // if(m>n){
        //     int temp = m; m=n; n=temp;
        //     int[] tmp = nums2;nums2=nums1;nums1=tmp;
        // }

        int move = (n+m-1)/2+1;
        int i =0;
        int ind1Start = 0;
        int ind2Start = 0;
        int ind1End = n-1;
        int ind2End = m-1;
        int l = 0;
        int r = 0;
        while(move>0){
            if(ind1Start>=n){l = nums2[ind2Start++];}
            else if(ind2Start>=m){l = nums1[ind1Start++];}
            else{l = nums1[ind1Start]<nums2[ind2Start] ? nums1[ind1Start++]:nums2[ind2Start++];}
            if(ind1End<0){r = nums2[ind2End--];}
            else if(ind2End<0){r = nums1[ind1End--];}
            else{r = nums1[ind1End]>nums2[ind2End] ? nums1[ind1End--]:nums2[ind2End--];}
            move--;
        }
        return (l+r)/2.0;
    }
}
