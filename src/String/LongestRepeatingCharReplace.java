package String;

/**
 * @author Qian
 * @create 2021-06-1012:32 上午
 */
public class LongestRepeatingCharReplace {
    public static void main(String[] args) {
        characterReplacement("HotFIX", 1);
        characterReplacement("Hot Fix revision2", 1);
        characterReplacement("AABABBA", 1);
        characterReplacement("Hot Fix revision three", 1);
    }

    static public int characterReplacement(String s, int k) {
        int start = 0;
        int end = 0;
        int[] count = new int[26];
        int majority = 0;
        int res = 0;
        int idx = 0;
        while(end < s.length()){
            idx = s.charAt(end)-'A';
            majority = Math.max(++count[idx],majority);
            if(start-end+1-majority>k){
                idx = s.charAt(start)-'A';
                --count[idx];
                start++;
            }else{
                res = Math.max(res,end-start+1);
            }
            end++;
        }
        return res;
    }
}
