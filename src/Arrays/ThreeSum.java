package Arrays;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

/**
 * @author Qian
 * @create 2021-05-089:21 下午
 */
public class ThreeSum {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String a = "asdfas";
        String b = "Asdf";
        a += b.charAt(2);
        System.out.println(a);
        System.out.println(a.length());
        System.out.println(a.substring(0,a.length()-1));
        List<List<Integer>> ans = threeSum(new int[]{-1,0,1,2,-1,-4});
        List<List<Integer>> ans2 = threeSum(new int[]{-1,0,3,2,-1,-4});
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(n<3){
            return res;
        }
        Arrays.sort(nums);
        for(int i = 1;i < n-1;i++){
            int L = i-1;
            int R = i+1;
            while(L>=0 && R<n){
                int sum = nums[L]+nums[R]+nums[i];
                if(sum==0){
                    res.add(new LinkedList<Integer>(Arrays.asList(nums[L],nums[i],nums[R])));
                    while(L-1>=0 && nums[L-1] == nums[L])
                        L--;
                    L--;
                    while(R+1<n && nums[R+1] == nums[R])
                        R++;
                    R++;
                }else if(sum>0){
                    while(L-1>=0 && nums[L-1] == nums[L])
                        L--;
                    L--;
                }else{
                    while(R+1<n && nums[R+1] == nums[R])
                        R++;
                    R++;
                }
            }
        }
        return res;
    }
}
