package String;

/**
 * @author Qian
 * @create 2021-06-0911:09 下午
 */
public class LongestSubstringAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(longestSubstring("baaabcb", 3));
    }

    static public int longestSubstring(String s, int k) {
        return helper(s,0,s.length(),k);
    }

    static int helper(String s, int start, int end, int k){
        if(end-start < k)
            return 0;
        int[] countMap = new int[26];
        for(int i = start;i<end;i++){
            countMap[s.charAt(i)-'a']++;
        }
        for(int mid = start;mid < end;mid++){
            if(countMap[s.charAt(mid)-'a']<k){
                return Math.max(helper(s,start,mid,k),helper(s,mid+2,end,k));
            }
        }
        return end-start;
    }
}
